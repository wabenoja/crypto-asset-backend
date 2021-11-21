package com.liverton.crypto.viewer.rest;

import com.liverton.crypto.viewer.dto.CryptoAssetResponseMin;
import com.liverton.crypto.viewer.service.BadAssetService;
import com.liverton.crypto.viewer.service.FavoriteAssetService;
import com.liverton.crypto.viewer.service.ViewService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class MarketDataRestController {

  private final ViewService viewService;
  private final FavoriteAssetService favoriteAssetService;
  private final BadAssetService badAssetService;

  @Inject
  public MarketDataRestController(ViewService viewService,
      FavoriteAssetService favoriteAssetService,
      BadAssetService badAssetService) {
    this.viewService = viewService;
    this.favoriteAssetService = favoriteAssetService;
    this.badAssetService = badAssetService;
  }

  @GetMapping
  @ResponseBody
  public List<CryptoAssetResponseMin> getMarkets(@RequestParam("exchange") String exchange,
      @RequestParam("quoteAsset") String quoteAsset) {
    return viewService.getMarketData(exchange, quoteAsset);
  }

  @PostMapping("favorite/{symbol}")
  @ResponseBody
  public void addFavorite(@PathVariable("symbol") String symbol) {
    favoriteAssetService.addFavoriteAsset(symbol);
  }

  @DeleteMapping("favorite/{symbol}")
  @ResponseBody
  public void removeFavorite(@PathVariable("symbol") String symbol) {
    favoriteAssetService.removeFavoriteAsset(symbol);
  }

  @PostMapping("bad/{symbol}")
  @ResponseBody
  public void addBad(@PathVariable("symbol") String symbol) {
    badAssetService.addBadAsset(symbol);
  }

  @DeleteMapping("bad/{symbol}")
  @ResponseBody
  public void removeBad(@PathVariable("symbol") String symbol) {
    badAssetService.removeBadAsset(symbol);
  }

}
