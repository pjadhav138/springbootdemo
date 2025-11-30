package com.tap4lap.api.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tap4lap.api.interfaces.LoanAmountByMonthDTO;
import com.tap4lap.api.model.LoanSummaryDTO;
import com.tap4lap.api.model.User;
import com.tap4lap.api.repository.LoanRepository;
import com.tap4lap.api.repository.UserRepository;
import com.tap4lap.api.services.ImageService;

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
	
	@Autowired
	private ImageService service;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException{
		String response = this.service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(response);
	}
	
	@GetMapping("/download/{name}")
	public ResponseEntity<?> downloadImage(@PathVariable("name") String name) throws IOException{
		byte[] response = this.service.downloadImage(name);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(response);
	}
	
}