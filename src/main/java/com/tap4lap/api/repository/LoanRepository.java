package com.tap4lap.api.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tap4lap.api.interfaces.LoanAmountByMonthDTO;
import com.tap4lap.api.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {

	@Query(value = "SELECT " + "YEAR(loan_start_date) as loan_year, " + // Changed from 'year' to 'loan_year'
			"MONTH(loan_start_date) as loan_month, " + // Changed from 'month' to 'loan_month'
			"SUM(loan_amount) as totalAmount " + "FROM Loans "
			+ "GROUP BY YEAR(loan_start_date), MONTH(loan_start_date) " +
             "ORDER BY loan_year DESC, loan_month DESC", // Update ORDER BY aliases too
     nativeQuery = true)
	List<LoanAmountByMonthDTO> findTotalLoanAmountsGroupedByMonth();

	@Query("SELECT SUM(l.loanAmount) FROM Loan l")
	BigDecimal findTotalLoanAmountDisbursed();

	@Query(value = "SELECT SUM(loan_amount) FROM Loans WHERE status IN ('Active', 'Paid Off')", nativeQuery = true)
	BigDecimal findActualDisbursedAmount();
	
	@Query(value = "SELECT SUM(loan_amount) FROM Loans WHERE status IN ('Active')", nativeQuery = true)
	BigDecimal findActiveDisbursedAmount();
}
