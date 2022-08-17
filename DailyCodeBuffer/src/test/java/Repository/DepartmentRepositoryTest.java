package Repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import Entity.DepartmentEntity;
import Repository.DepartmentRepository;
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository dRepo;

    @Autowired
    private TestEntityManager entityManager;
	void setUp()  {
		DepartmentEntity dEntity = DepartmentEntity.builder()
				.departmentAddress("asd")
				.departmentCode("fgh")
				.build();
		entityManager.persist(dEntity);
	}
	 
    @Test
    public void whenFindById_thenReturnDepartment() {
    	DepartmentEntity department = dRepo.findById(1).get();
        assertEquals(department.getDepartmentName(), "jkl");
    }
}
