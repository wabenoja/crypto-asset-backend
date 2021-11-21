package com.liverton.crypto.viewer.dao.model;

import static java.util.Objects.hash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bad_assets")
public class BadAsset {

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
    BadAsset that = (BadAsset) o;
    return symbol.equals(that.symbol);
  }

  @Override
  public int hashCode() {
    return hash(symbol);
  }
}
