package com.liverton.crypto.viewer.service.impl;

import com.liverton.crypto.viewer.dao.BadAssetRepository;
import com.liverton.crypto.viewer.dao.FavoriteAssetRepository;
import com.liverton.crypto.viewer.dao.model.BadAsset;
import com.liverton.crypto.viewer.dao.model.FavoriteAsset;
import com.liverton.crypto.viewer.service.BadAssetService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BadAssetServiceImpl implements BadAssetService {

  private final BadAssetRepository badAssetRepository;

  @Inject
  public BadAssetServiceImpl(
      BadAssetRepository badAssetRepository) {
    this.badAssetRepository = badAssetRepository;
  }

  @Override
  public void addBadAsset(String symbol) {
    BadAsset asset = new BadAsset();
    asset.setSymbol(symbol);

    badAssetRepository.save(asset);
  }

  @Override
  @Transactional
  public void removeBadAsset(String symbol) {
    badAssetRepository.deleteBySymbol(symbol);
  }
}
