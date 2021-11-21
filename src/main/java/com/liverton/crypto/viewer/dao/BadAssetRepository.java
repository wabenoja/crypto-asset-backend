package com.liverton.crypto.viewer.dao;

import com.liverton.crypto.viewer.dao.model.BadAsset;
import com.liverton.crypto.viewer.dao.model.FavoriteAsset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadAssetRepository extends JpaRepository<BadAsset, Long> {
  void deleteBySymbol(String symbol);
}
