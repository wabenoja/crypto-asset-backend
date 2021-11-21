package com.liverton.crypto.viewer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableType
@JsonIgnoreProperties(ignoreUnknown = true)
public interface CryptoAssetResponseMinDef {

  @JsonProperty("base_asset")
  String baseAsset();

  @JsonProperty("symbol")
  String symbol();

  @JsonProperty("price")
  BigDecimal price();

  @JsonProperty("change_24h")
  BigDecimal change24h();

  @JsonProperty("volume_24h")
  BigDecimal volume24h();

  @JsonProperty("favorite")
  Boolean favorite();

  @JsonProperty("hidden")
  Boolean hidden();
}
