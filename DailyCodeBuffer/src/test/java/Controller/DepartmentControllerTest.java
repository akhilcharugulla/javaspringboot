package Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import Controller.DepartmentController;
import Entity.DepartmentEntity;
import Exception.DepartmentException;
import Service.DepartmentService;
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	 private DepartmentEntity department;

	@Autowired
	MockMvc mockmvc;
	
	@Autowired
	DepartmentService service;
	@BeforeEach
	void setUp() throws Exception {
		DepartmentEntity department = DepartmentEntity.builder()
				.departmentAddress("zxc")
				.departmentCode("vbn")
				.departmentName("qwert")
				.departmentId(1).build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		DepartmentEntity inputdepartment = DepartmentEntity.builder()
				.departmentAddress("zxc")
				.departmentCode("vbn")
				.departmentName("qwert").build();
		Mockito.when(service.addDepartment(inputdepartment)).thenReturn(department);
		
		mockmvc.perform(post("/adddepartment")
				.contentType(MediaType.APPLICATION_JSON)
				.content("\t\"departmentName\":\"qwert\",\n" +
		                "\t\"departmentAddress\":\"zxc\",\n" +
		                "\t\"departmentCode\":\"vbn\"\n" +
		                "}"))
				.andExpect(status().isOk());
	}

	@Test
	void testFetchDepartmentById() throws Exception {
		Mockito.when(service.getDepartmentById(1)).thenReturn(department);
		mockmvc.perform(get("/department/{id}").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.departmentName").value("qwer"));

		//.andExpect(content().json("$.departmentName"));

	}

}
