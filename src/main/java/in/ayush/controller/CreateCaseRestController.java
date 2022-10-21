package in.ayush.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.dto.CreateCaseResponse;
import in.ayush.service.DcService;

@RestController
public class CreateCaseRestController {

	@Autowired
	private DcService dcService;

	@GetMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> search(@PathVariable Long appId) {
		Long caseNum = dcService.loadCaseNum(appId);
		Map<Integer, String> planMap = dcService.getPlanNames();
		CreateCaseResponse response = new CreateCaseResponse();
		response.setCaseNum(caseNum);
		response.setPlanNames(planMap);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
