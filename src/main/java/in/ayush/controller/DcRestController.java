package in.ayush.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.dto.ChildrenDto;
import in.ayush.dto.EducationDto;
import in.ayush.dto.IncomeDto;
import in.ayush.entity.DcChildren;
import in.ayush.entity.DcEducation;
import in.ayush.entity.DcIncome;
import in.ayush.service.DcService;

@RestController
public class DcRestController {

	@Autowired
	private DcService dcService;

	public ResponseEntity<Integer> search(@PathVariable Integer appId) {
		Integer caseNum = dcService.search(appId);
		return new ResponseEntity<>(caseNum, HttpStatus.CREATED);
	}

	public ResponseEntity<Map<Integer, String>> planCategories() {
		Map<Integer, String> planCategories = dcService.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}

	public ResponseEntity<String> planSubmit(@PathVariable Integer caseNum, @RequestBody String planName) {
		boolean submitPlan = dcService.submitPlan(caseNum, planName);
		if (submitPlan) {
			return new ResponseEntity<>("Plan Data Submitted", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Plan Data Save Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> incomeSubmit(@PathVariable Integer caseNum, @RequestBody IncomeDto incomeDto) {
		boolean submitIncome = dcService.submitIncome(caseNum, incomeDto);
		if (submitIncome) {
			return new ResponseEntity<>("Income Data Submitted", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Income Data Save Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> educaionSubmit(@PathVariable Integer caseNum, @RequestBody EducationDto eduDto) {
		boolean submitEducation = dcService.submitEducation(caseNum, eduDto);
		if (submitEducation) {
			return new ResponseEntity<>("Education Data Submitted", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Education Data Save Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> kidsSubmit(@PathVariable Integer caseNum, @RequestBody ChildrenDto kidsDto) {
		boolean submitChildren = dcService.submitChildren(caseNum, kidsDto);
		if (submitChildren) {
			return new ResponseEntity<>("Education Data Submitted", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Education Data Save Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Map<Integer, List<DcIncome>>> incomeData(@PathVariable Integer caseNum) {
		Map<Integer, List<DcIncome>> incomeData = dcService.getIncomeData();
		return new ResponseEntity<>(incomeData, HttpStatus.OK);
	}

	public ResponseEntity<Map<Integer, List<DcEducation>>> educationData(@PathVariable Integer caseNum) {
		Map<Integer, List<DcEducation>> educationData = dcService.getEducationData();
		return new ResponseEntity<>(educationData, HttpStatus.OK);
	}

	public ResponseEntity<Map<Integer, List<DcChildren>>> childrenData(@PathVariable Integer caseNum) {
		Map<Integer, List<DcChildren>> childrenData = dcService.getChildrenData();
		return new ResponseEntity<>(childrenData, HttpStatus.OK);
	}

}
