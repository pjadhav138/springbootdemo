package com.tap4lap.api.interfaces;

import java.math.BigDecimal;

// An interface-based projection for the native query results
public interface LoanAmountByMonthDTO {
    Integer getLoanYear();
    Integer getLoanMonth();
    BigDecimal getTotalAmount();
}