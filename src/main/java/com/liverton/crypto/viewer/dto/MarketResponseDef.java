package com.liverton.crypto.viewer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableType
@JsonIgnoreProperties(ignoreUnknown = true)
public interface MarketResponseDef {

  @JsonProperty("markets")
  List<CryptoAssetResponse> markets();
}
