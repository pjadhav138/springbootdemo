package com.tap4lap.api.model;

import lombok.Data;
import java.math.BigDecimal;

@Data // Lombok annotation for getters/setters/constructor
public class LoanSummaryDTO {
    private BigDecimal totalDisbursedAmount;
    private BigDecimal activeDisbursedAmount;
    private BigDecimal totalPendingRepayment; // This is the total value of all loans ever created
	public BigDecimal getTotalDisbursedAmount() {
		return totalDisbursedAmount;
	}
	public void setTotalDisbursedAmount(BigDecimal totalDisbursedAmount) {
		this.totalDisbursedAmount = totalDisbursedAmount;
	}
	public BigDecimal getActiveDisbursedAmount() {
		return activeDisbursedAmount;
	}
	public void setActiveDisbursedAmount(BigDecimal activeDisbursedAmount) {
		this.activeDisbursedAmount = activeDisbursedAmount;
	}
	public BigDecimal getTotalPendingRepayment() {
		return totalPendingRepayment;
	}
	public void setTotalPendingRepayment(BigDecimal totalPendingRepayment) {
		this.totalPendingRepayment = totalPendingRepayment;
	}


}
