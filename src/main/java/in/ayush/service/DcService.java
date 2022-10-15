package in.ayush.service;

import java.util.List;
import java.util.Map;

import in.ayush.dto.ChildrenDto;
import in.ayush.dto.EducationDto;
import in.ayush.dto.IncomeDto;
import in.ayush.entity.DcChildren;
import in.ayush.entity.DcEducation;
import in.ayush.entity.DcIncome;

public interface DcService {
	
	public Integer search(Integer appId);
	
	public boolean submitPlan(Integer caseNum, String planName);
	
	public Map<Integer, String> getPlanCategories();
	
	public boolean submitIncome(Integer caseNum, IncomeDto incomeDto);
	
	public boolean submitEducation(Integer caseNum, EducationDto EduDto);
	
	public boolean submitChildren(Integer caseNum, ChildrenDto childrenDto);
	
	public Map<Integer, List<DcIncome>> getIncomeData();
	
	public Map<Integer, List<DcEducation>> getEducationData();
	
	public Map<Integer, List<DcChildren>> getChildrenData();

}
