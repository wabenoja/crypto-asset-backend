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
import com.liverton.crypto.viewer.service.FavoriteAssetService;
import com.liverton.crypto.viewer.service.ViewService;
import feign.FeignException;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FavoriteAssetServiceImpl implements FavoriteAssetService {

  private final FavoriteAssetRepository favoriteAssetRepository;

  @Inject
  public FavoriteAssetServiceImpl(FavoriteAssetRepository favoriteAssetRepository) {
    this.favoriteAssetRepository = favoriteAssetRepository;
  }

  @Override
  public void addFavoriteAsset(String symbol) {
    FavoriteAsset asset = new FavoriteAsset();
    asset.setSymbol(symbol);

    favoriteAssetRepository.save(asset);
  }

  @Override
  @Transactional
  public void removeFavoriteAsset(String symbol) {
    favoriteAssetRepository.deleteBySymbol(symbol);
  }
}
