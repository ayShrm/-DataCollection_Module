package in.ayush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.dto.IncomeDto;
import in.ayush.service.DcService;

@RestController
public class IncomeRestController {

	@Autowired
	private DcService dcService;

	@PostMapping("/income")
	public ResponseEntity<Long> incomeSubmit(@RequestBody IncomeDto incomeDto) {
		Long saveIncomeData = dcService.saveIncomeData(incomeDto);
		return new ResponseEntity<>(saveIncomeData, HttpStatus.CREATED);
	}

}
