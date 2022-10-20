package in.ayush.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.dto.ChildrenDto;
import in.ayush.dto.DcSummary;
import in.ayush.dto.EducationDto;
import in.ayush.dto.IncomeDto;
import in.ayush.dto.PlanSelectionDto;
import in.ayush.service.DcService;

@RestController
public class DcRestController {

	@Autowired
	private DcService dcService;

	@GetMapping("/casenum/{appId}")
	public ResponseEntity<String> search(@PathVariable Long appId) {
		Long caseNum = dcService.loadCaseNum(appId);
		if (caseNum == null) {
			return new ResponseEntity<>("Application number is wrong!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Case No. " + caseNum, HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<String>> planCategories() {
		List<String> planNames = dcService.getPlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}

	@PostMapping("/saveplan")
	public ResponseEntity<Long> planSubmit(PlanSelectionDto planDto) {
		Long savePlanSelection = dcService.savePlanSelection(planDto);
		return new ResponseEntity<>(savePlanSelection, HttpStatus.CREATED);
	}

	@PostMapping("/incomedata")
	public ResponseEntity<Long> incomeSubmit(@RequestBody IncomeDto incomeDto) {
		Long saveIncomeData = dcService.saveIncomeData(incomeDto);
		return new ResponseEntity<>(saveIncomeData, HttpStatus.CREATED);
	}

	@PostMapping("/educationdata")
	public ResponseEntity<Long> educaionSubmit(@RequestBody EducationDto eduDto) {
		Long saveEducationData = dcService.saveEducationData(eduDto);
		return new ResponseEntity<>(saveEducationData, HttpStatus.CREATED);
	}

	@PostMapping("/childrendata")
	public ResponseEntity<Long> kidsSubmit(@RequestBody List<ChildrenDto> kidsDto) {
		Long saveChildren = dcService.saveChildren(kidsDto);
		return new ResponseEntity<>(saveChildren, HttpStatus.CREATED);
	}

	@GetMapping("/summary/{appId}")
	public ResponseEntity<DcSummary> summary(@PathVariable Long appId) {
		DcSummary summary = dcService.getSummary(appId);
		return new ResponseEntity<>(summary, HttpStatus.OK);
	}

}
