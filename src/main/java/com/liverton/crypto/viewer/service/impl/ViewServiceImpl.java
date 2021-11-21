package com.liverton.crypto.viewer.service.impl;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import com.liverton.crypto.viewer.client.CryptingUpClient;
import com.liverton.crypto.viewer.dao.BadAssetRepository;
import com.liverton.crypto.viewer.dao.FavoriteAssetRepository;
import com.liverton.crypto.viewer.dao.model.BadAsset;
import com.liverton.crypto.viewer.dao.model.FavoriteAsset;
import com.liverton.crypto.viewer.dto.CryptoAssetResponse;
import com.liverton.crypto.viewer.dto.CryptoAssetResponseMin;
import com.liverton.crypto.viewer.service.ViewService;
import feign.FeignException;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {

  private static final Logger LOG = LoggerFactory.getLogger(ViewServiceImpl.class);
  private final CryptingUpClient client;
  private final FavoriteAssetRepository favoriteAssetRepository;
  private final BadAssetRepository badAssetRepository;

  @Inject
  public ViewServiceImpl(CryptingUpClient client,
      FavoriteAssetRepository favoriteAssetRepository,
      BadAssetRepository badAssetRepository) {
    this.client = client;
    this.favoriteAssetRepository = favoriteAssetRepository;
    this.badAssetRepository = badAssetRepository;
  }

  @Override
  public List<CryptoAssetResponseMin> getMarketData(String exchange, String quoteAsset) {
    final List<String> favoriteAssets = getFavoriteAssets();
    final List<String> badAssets = getBadAssets();

    try {
      return client.getMarkets().markets().stream()
          .filter(filterByExchangeAndAsset(exchange, quoteAsset))
          .map(response -> toDto(response, favoriteAssets.contains(response.symbol()),
              badAssets.contains(response.symbol())))
          .sorted(comparing(CryptoAssetResponseMin::favorite)
              .thenComparing(CryptoAssetResponseMin::price)
              .reversed())
          .collect(toList());
    } catch (FeignException e) {
      LOG.error("Problem fetching market data");
      return emptyList();
    }
  }

  private List<String> getBadAssets() {
    return badAssetRepository.findAll().stream().map(BadAsset::getSymbol)
        .collect(toList());
  }

  private List<String> getFavoriteAssets() {
    return favoriteAssetRepository.findAll().stream()
        .map(FavoriteAsset::getSymbol).collect(toList());
  }

  private Predicate<CryptoAssetResponse> filterByExchangeAndAsset(String exchange,
      String quoteAsset) {
    return response -> exchange.equalsIgnoreCase(response.exchangeId())
        && quoteAsset.equalsIgnoreCase(response.quoteAsset());
  }

  private CryptoAssetResponseMin toDto(CryptoAssetResponse response, Boolean favorite,
      Boolean hidden) {
    return CryptoAssetResponseMin.of(response.baseAsset(), response.symbol(), response.price(),
        response.change24h(), response.volume24h(), favorite, hidden);
  }
}
