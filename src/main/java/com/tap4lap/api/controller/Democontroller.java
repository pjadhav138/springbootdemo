package com.tap4lap.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tap4lap.api.interfaces.LoanAmountByMonthDTO;
import com.tap4lap.api.model.LoanSummaryDTO;
import com.tap4lap.api.model.User;
import com.tap4lap.api.repository.LoanRepository;
import com.tap4lap.api.repository.UserRepository;

@RestController
public class Democontroller {
	@Autowired
	UserRepository repository;

	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@PostMapping("test")
	public String name() {

		return "test";
	}

	@PostMapping("register")
	public User register(@RequestBody User user) {

		return repository.save(user);
	}

	@Autowired
	private LoanRepository loanRepository;

	@GetMapping("/total-disbursed-by-month")
	public List<LoanAmountByMonthDTO> getTotalLoanAmountsByMonth() {
		return loanRepository.findTotalLoanAmountsGroupedByMonth();
	}
	
	 @GetMapping("/summary")
	    public LoanSummaryDTO getLoanSummary() {
	       BigDecimal totalPending = loanRepository.findTotalLoanAmountDisbursed(); 
	        
	        BigDecimal actualDisbursed = loanRepository.findActualDisbursedAmount();
	        BigDecimal activeDisbursed = loanRepository.findActiveDisbursedAmount();
	        LoanSummaryDTO summary = new LoanSummaryDTO();
	        summary.setTotalDisbursedAmount(actualDisbursed);
	        summary.setTotalPendingRepayment(totalPending);
	        summary.setActiveDisbursedAmount(activeDisbursed);
	        return summary;
	    }
}