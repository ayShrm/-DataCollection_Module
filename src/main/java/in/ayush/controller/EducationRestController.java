package in.ayush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ayush.dto.EducationDto;
import in.ayush.service.DcService;

@RestController
public class EducationRestController {

	@Autowired
	private DcService dcService;

	@PostMapping("/education")
	public ResponseEntity<Long> educaionSubmit(@RequestBody EducationDto eduDto) {
		Long saveEducationData = dcService.saveEducationData(eduDto);
		return new ResponseEntity<>(saveEducationData, HttpStatus.CREATED);
	}

}
