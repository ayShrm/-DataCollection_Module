package in.ayush.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ayush.dto.Children;
import in.ayush.dto.ChildrenDto;
import in.ayush.dto.DcSummary;
import in.ayush.dto.EducationDto;
import in.ayush.dto.IncomeDto;
import in.ayush.dto.PlanSelectionDto;
import in.ayush.entity.CitizenAppEntity;
import in.ayush.entity.DcCasesEntity;
import in.ayush.entity.DcChildrenEntity;
import in.ayush.entity.DcEducationEntity;
import in.ayush.entity.DcIncomeEntity;
import in.ayush.entity.PlanEntity;
import in.ayush.repository.CitizenAppRepository;
import in.ayush.repository.DcCasesRepo;
import in.ayush.repository.DcChildrenRepo;
import in.ayush.repository.DcEducationRepo;
import in.ayush.repository.DcIncomeRepo;
import in.ayush.repository.PlanRepo;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private CitizenAppRepository appRepo;

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private DcCasesRepo casesRepo;

	@Autowired
	private DcChildrenRepo childrenRepo;

	@Autowired
	private DcEducationRepo eduRepo;

	@Autowired
	private DcIncomeRepo incomeRepo;

	@Override
	public Long loadCaseNum(Long appId) {
		Optional<CitizenAppEntity> applicationId = appRepo.findById(appId);
		if (applicationId.isPresent()) {
			DcCasesEntity caseEntity = new DcCasesEntity(applicationId.get());
			casesRepo.save(caseEntity);
			return caseEntity.getCaseNum();
		}
		return null;
	}

	@Override
	public Map<Integer, String> getPlanNames() {
		List<PlanEntity> findAll = planRepo.findAll();
		Map<Integer, String> plansMap = new HashMap<Integer, String>();
		for (PlanEntity entity : findAll) {
			plansMap.put(entity.getPlanId(), entity.getPlanName());
		}
		return plansMap;
	}

	@Override
	public Long savePlanSelection(PlanSelectionDto planSelection) {
		Long caseNum = planSelection.getCaseNum();
		String planName = planSelection.getPlanName();
		Optional<DcCasesEntity> caseEntity = casesRepo.findById(caseNum);
		if (caseEntity.isPresent()) {
			PlanEntity findByPlanName = planRepo.findByPlanName(planName);
			DcCasesEntity dcCasesEntity = caseEntity.get();
			dcCasesEntity.setPlanEntity(findByPlanName);
			casesRepo.save(dcCasesEntity);
			return dcCasesEntity.getCaseNum();
		}
		return null;
	}

	@Override
	public Long saveIncomeData(IncomeDto incomeDto) {
		Long caseNum = incomeDto.getCaseNum();
		Optional<DcCasesEntity> dbCaseNum = casesRepo.findById(caseNum);
		DcIncomeEntity incomeEntity = new DcIncomeEntity(dbCaseNum.get());
		if (dbCaseNum.isPresent()) {
			incomeEntity.setMonthlySalaryIncome(incomeDto.getMonthlySalaryIncome());
			incomeEntity.setRentIncome(incomeDto.getRentIncome());
			incomeEntity.setPropertyIcome(incomeDto.getPropertyIcome());
			incomeRepo.save(incomeEntity);
			return dbCaseNum.get().getCaseNum();
		}
		return null;
	}

	@Override
	public Long saveEducationData(EducationDto educationDto) {
		Long caseNum = educationDto.getCaseNum();
		String highestDegree = educationDto.getHighestDegree();
		Integer graduationYear = educationDto.getGraduationYear();
		String univerityName = educationDto.getUniverityName();
		Optional<DcCasesEntity> dbCaseNum = casesRepo.findById(caseNum);
		DcEducationEntity eduEntity = new DcEducationEntity(dbCaseNum.get());
		if (dbCaseNum.isPresent()) {
			eduEntity.setHighestDegree(highestDegree);
			eduEntity.setGraduationYear(graduationYear);
			eduEntity.setUniverityName(univerityName);
			eduRepo.save(eduEntity);
			return dbCaseNum.get().getCaseNum();
		}
		return null;
	}

	@Override
	public Long saveChildren(Children request) {
		Optional<DcCasesEntity> caseEntity = casesRepo.findById(request.getCaseNum());
		if (caseEntity.isPresent()) {
			List<ChildrenDto> children = request.getChildren();
			for (ChildrenDto entity : children) {
				DcChildrenEntity childrenEntity = new DcChildrenEntity(caseEntity.get());
				childrenEntity.setChildrenName(entity.getChildrenName());
				childrenEntity.setChildrenAge(entity.getChildrenAge());
				childrenEntity.setChildrenSsn(entity.getChildrenSsn());
				childrenRepo.save(childrenEntity);
			}
			return request.getCaseNum();
		}
		// Long caseNum = childrenDto.stream().findFirst().get().getCaseNum();
		// Long caseNum = childrenDto.get(0).getCaseNum();
		return null;
	}

	@Override
	public DcSummary getSummary(Long caseNum) {
		Optional<DcCasesEntity> dbCaseNum = casesRepo.findById(caseNum);
		if (dbCaseNum.isPresent()) {
			Optional<DcIncomeEntity> incomeData = incomeRepo.findByCaseNum(caseNum);
			Optional<DcEducationEntity> educationData = eduRepo.findByCaseNum(caseNum);
			List<Optional<DcChildrenEntity>> childrenData = childrenRepo.findByCaseNum(caseNum);

			DcSummary summary = new DcSummary();

			IncomeDto income = new IncomeDto();
			BeanUtils.copyProperties(incomeData.get(), income);
			summary.setIncome(income);

			EducationDto education = new EducationDto();
			BeanUtils.copyProperties(educationData.get(), education);
			summary.setEducation(education);

			List<ChildrenDto> children = new ArrayList<>();
			for (Optional<DcChildrenEntity> entity : childrenData) {
				ChildrenDto child = new ChildrenDto();
				BeanUtils.copyProperties(entity.get(), child);
				children.add(child);
			}
			summary.setChildren(children);

			PlanEntity planEntity = dbCaseNum.get().getPlanEntity();
			summary.setPlanName(planEntity.getPlanName());

			return summary;
		}
		return null;
	}

}
