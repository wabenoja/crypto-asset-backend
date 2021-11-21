package com.liverton.crypto.viewer.service;

import com.liverton.crypto.viewer.dto.CryptoAssetResponseMin;
import java.util.List;

public interface ViewService {

  List<CryptoAssetResponseMin> getMarketData(String exchange, String quoteAsset);
}
