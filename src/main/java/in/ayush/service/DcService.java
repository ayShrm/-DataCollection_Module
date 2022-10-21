package in.ayush.service;

import java.util.Map;

import in.ayush.dto.Children;
import in.ayush.dto.DcSummary;
import in.ayush.dto.EducationDto;
import in.ayush.dto.IncomeDto;
import in.ayush.dto.PlanSelectionDto;

public interface DcService {

	public Long loadCaseNum(Long appId);

	public Map<Integer, String> getPlanNames();

	public Long savePlanSelection(PlanSelectionDto planSelection);

	public Long saveIncomeData(IncomeDto incomeDto);

	public Long saveEducationData(EducationDto educationDto);

	public Long saveChildren(Children children);

	public DcSummary getSummary(Long caseNum);

}
