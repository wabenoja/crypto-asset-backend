package com.liverton.crypto.viewer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableType
@JsonIgnoreProperties(ignoreUnknown = true)
public interface CryptoAssetResponseDef {

  @JsonProperty("exchange_id")
  String exchangeId();

  @JsonProperty("symbol")
  String symbol();

  @JsonProperty("base_asset")
  String baseAsset();

  @JsonProperty("quote_asset")
  String quoteAsset();

  @JsonProperty("price_unconverted")
  BigDecimal priceUnconverted();

  @JsonProperty("price")
  BigDecimal price();

  @JsonProperty("change_24h")
  BigDecimal change24h();

  @JsonProperty("spread")
  BigDecimal spread();

  @JsonProperty("volume_24h")
  BigDecimal volume24h();

  @JsonProperty("status")
  String status();

  @JsonProperty("created_at")
  String createdDate();

  @JsonProperty("updated_at")
  String updateDate();
}
