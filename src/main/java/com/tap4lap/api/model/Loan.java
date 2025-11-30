package com.tap4lap.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Loans")
@Data // Lombok annotation for getters/setters/etc.
public class Loan {

    @Id
    private String loanId;
    private String customerName;
    private String loanType;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private LocalDate loanStartDate;
    private Integer loanTermMonths;
    private String status;
    private Integer isApproved;
}
