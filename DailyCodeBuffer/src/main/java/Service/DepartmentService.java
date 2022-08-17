package Service;

import java.util.List;

import Entity.DepartmentEntity;
import Exception.DepartmentException;

public interface DepartmentService {
	public DepartmentEntity addDepartment(DepartmentEntity dept);
	public List<DepartmentEntity> getDepartments();
	public DepartmentEntity getDepartmentById(Integer deptId) throws DepartmentException;
	public void deleteDepartmentById(Integer deptId);
	public DepartmentEntity updateDepartmentById(Integer id, DepartmentEntity dept);
	public DepartmentEntity getDepartmentNamebyName(String name);
}
