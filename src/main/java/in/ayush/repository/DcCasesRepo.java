package in.ayush.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ayush.entity.DcCases;

public interface DcCasesRepo extends JpaRepository<DcCases, Serializable> {

}
