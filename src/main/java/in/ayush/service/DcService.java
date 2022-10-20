package in.ayush.service;

import java.util.List;

import in.ayush.dto.ChildrenDto;
import in.ayush.dto.DcSummary;
import in.ayush.dto.EducationDto;
import in.ayush.dto.IncomeDto;
import in.ayush.dto.PlanSelectionDto;

public interface DcService {

	public Long loadCaseNum(Long appId);

	public List<String> getPlanNames();

	public Long savePlanSelection(PlanSelectionDto planSelection);

	public Long saveIncomeData(IncomeDto incomeDto);

	public Long saveEducationData(EducationDto educationDto);

	public Long saveChildren(List<ChildrenDto> childrenDto);

	public DcSummary getSummary(Long caseNum);

}
