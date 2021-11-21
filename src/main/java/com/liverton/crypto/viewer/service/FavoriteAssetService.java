package com.liverton.crypto.viewer.service;

public interface FavoriteAssetService {

  void addFavoriteAsset(String symbol);

  void removeFavoriteAsset(String symbol);
}
