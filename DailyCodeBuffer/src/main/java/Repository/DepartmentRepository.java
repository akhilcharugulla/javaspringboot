package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer>{

	DepartmentEntity findBydepartmentName(String name);
	DepartmentEntity findBydepartmentNameIgnoreCase(String name);
}
