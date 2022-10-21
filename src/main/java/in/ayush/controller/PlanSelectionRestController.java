package in.ayush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.dto.PlanSelectionDto;
import in.ayush.service.DcService;

@RestController
public class PlanSelectionRestController {

	@Autowired
	private DcService dcService;

	@PostMapping("/saveplan")
	public ResponseEntity<Long> planSubmit(@RequestBody PlanSelectionDto planDto) {
		Long caseNum = dcService.savePlanSelection(planDto);
		return new ResponseEntity<>(caseNum, HttpStatus.CREATED);
	}

}
