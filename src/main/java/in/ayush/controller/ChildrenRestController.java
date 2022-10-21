package in.ayush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.dto.Children;
import in.ayush.dto.DcSummary;
import in.ayush.service.DcService;

@RestController
public class ChildrenRestController {

	@Autowired
	private DcService dcService;

	@PostMapping("/children")
	public ResponseEntity<DcSummary> kidsSubmit(@RequestBody Children request) {
		Long caseNum = dcService.saveChildren(request);
		DcSummary summary = dcService.getSummary(caseNum);
		return new ResponseEntity<>(summary, HttpStatus.CREATED);
	}

}
