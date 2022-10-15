package in.ayush.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ayush.dto.ChildrenDto;
import in.ayush.dto.EducationDto;
import in.ayush.dto.IncomeDto;
import in.ayush.entity.DcChildren;
import in.ayush.entity.DcEducation;
import in.ayush.entity.DcIncome;
import in.ayush.repository.DcCasesRepo;
import in.ayush.repository.DcChildrenRepo;
import in.ayush.repository.DcEducationRepo;
import in.ayush.repository.DcIncomeRepo;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private DcCasesRepo casesRepo;

	@Autowired
	private DcChildrenRepo childrenRepo;

	@Autowired
	private DcEducationRepo eduRepo;

	@Autowired
	private DcIncomeRepo incomeRepo;

	@Override
	public Integer search(Integer appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean submitPlan(Integer caseNum, String planName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean submitIncome(Integer caseNum, IncomeDto incomeDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean submitEducation(Integer caseNum, EducationDto EduDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean submitChildren(Integer caseNum, ChildrenDto childrenDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, List<DcIncome>> getIncomeData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<DcEducation>> getEducationData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<DcChildren>> getChildrenData() {
		// TODO Auto-generated method stub
		return null;
	}

}
