package com.liverton.crypto.viewer.client;

import com.liverton.crypto.viewer.dto.MarketResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "crypting-up-client", url = "https://www.cryptingup.com")
public interface CryptingUpClient {

  @GetMapping(path = "/api/markets")
  MarketResponse getMarkets();
}
