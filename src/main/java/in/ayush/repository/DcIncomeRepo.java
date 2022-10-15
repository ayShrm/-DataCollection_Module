package in.ayush.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ayush.entity.DcIncome;

public interface DcIncomeRepo extends JpaRepository<DcIncome, Serializable> {

}
