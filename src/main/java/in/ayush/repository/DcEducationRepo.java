package in.ayush.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ayush.entity.DcEducation;

public interface DcEducationRepo extends JpaRepository<DcEducation, Serializable> {

}
