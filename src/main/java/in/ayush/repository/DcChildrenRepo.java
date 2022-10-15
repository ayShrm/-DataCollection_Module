package in.ayush.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ayush.entity.DcChildren;

public interface DcChildrenRepo extends JpaRepository<DcChildren, Serializable> {

}
