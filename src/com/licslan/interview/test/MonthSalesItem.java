package com.licslan.interview.test;

import java.math.BigDecimal;

/**
 * @author WEILIN
 */
public class MonthSalesItem {

  int month;
  BigDecimal totalAmount;

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }
}
