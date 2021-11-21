package com.liverton.crypto.viewer.dao.model;

import static java.util.Objects.hash;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "favorite_assets")
public class FavoriteAsset {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "symbol")
  private String symbol;


  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FavoriteAsset that = (FavoriteAsset) o;
    return symbol.equals(that.symbol);
  }

  @Override
  public int hashCode() {
    return hash(symbol);
  }
}
