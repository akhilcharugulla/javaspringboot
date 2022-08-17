package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import Entity.DepartmentEntity;
import Repository.DepartmentRepository;
import Service.DepartmentService;
@SpringBootTest
class DepartmentServiceLayerTest {

	@Autowired
	DepartmentService dService;
	@MockBean
	DepartmentRepository mockdRepo;
	@BeforeEach
	void setup() {
		DepartmentEntity mockdept = DepartmentEntity.builder().departmentAddress("jhgf").departmentCode("jk").departmentName("wuio").departmentId(6).build();
		Mockito.when(mockdRepo.findBydepartmentNameIgnoreCase("wuio")).thenReturn(mockdept);
	}

	@Test
	public void testGetDepartmentNamebyName() {
		String departmentName ="wuio";		
		DepartmentEntity dept = dService.getDepartmentNamebyName(departmentName);
		assertEquals(departmentName,dept.getDepartmentName());
	}
}
