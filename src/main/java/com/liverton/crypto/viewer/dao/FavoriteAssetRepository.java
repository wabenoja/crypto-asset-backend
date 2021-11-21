package com.liverton.crypto.viewer.dao;

import com.liverton.crypto.viewer.dao.model.FavoriteAsset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteAssetRepository extends JpaRepository<FavoriteAsset, Long> {
  void deleteBySymbol(String symbol);
}
