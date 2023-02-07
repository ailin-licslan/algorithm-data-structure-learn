package com.licslan.interview.test;

import java.math.BigDecimal;
import java.time.Instant;


/**
 * @author WEILIN
 */
public class SaleItem {

  String transationId;
  Instant transationTime;
  BigDecimal amount;

  public String getTransationId() {
    return transationId;
  }

  public void setTransationId(String transationId) {
    this.transationId = transationId;
  }

  public Instant getTransationTime() {
    return transationTime;
  }

  public void setTransationTime(Instant transationTime) {
    this.transationTime = transationTime;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
