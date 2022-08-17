package Controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import Entity.DepartmentEntity;
import Exception.DepartmentException;
import Service.DepartmentService;

@RestController
public class DepartmentController {
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	DepartmentService dservice;
	@PostMapping("/adddepartment")
	public DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity dept) {  //@RequestBody converts the json data to Department Entity object
		logger.info("added data");
		return dservice.addDepartment(dept);
	}
	@GetMapping("/departments")
	public List<DepartmentEntity> fetchDepartments(){
		return dservice.getDepartments();
	}
	@GetMapping("/department/{id}")
	public DepartmentEntity fetchDepartmentById(@PathVariable("id") Integer deptId) throws DepartmentException {
		return dservice.getDepartmentById(deptId);
	}
	@DeleteMapping("/department/{id}")
	public void deleteDepartment(@PathVariable("id") Integer deptId) {
		 dservice.deleteDepartmentById(deptId);
	}
	@PutMapping("/department/{id}")
	public DepartmentEntity updateDepartment(@PathVariable Integer id,@RequestBody DepartmentEntity dept) {
		return dservice.updateDepartmentById(id,dept);
	}
	@GetMapping("/department/name/{name}")
	public DepartmentEntity getDepartmentNamebyName(@PathVariable String name) {
		return dservice.getDepartmentNamebyName(name);
	}
}
