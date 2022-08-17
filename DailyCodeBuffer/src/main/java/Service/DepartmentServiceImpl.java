package Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.DepartmentEntity;
import Exception.DepartmentException;
import Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepository dRepo;
	public  DepartmentServiceImpl(DepartmentRepository dRepo) {
		this.dRepo = dRepo;
	}
	public DepartmentEntity addDepartment(DepartmentEntity dept) {
		return dRepo.save(dept);
	}

	public List<DepartmentEntity> getDepartments() {
		return dRepo.findAll();
	}

	public DepartmentEntity getDepartmentById(Integer deptId) throws DepartmentException {
		Optional<DepartmentEntity> dep=dRepo.findById(deptId);
		if(dep.isPresent()) {
			return dRepo.findById(deptId).get();}
		else {
			throw new DepartmentException("Department not found with that Id");
		}
	}

	public void deleteDepartmentById(Integer deptId) {
		dRepo.deleteById(deptId);
	}

	public DepartmentEntity updateDepartmentById(Integer id, DepartmentEntity dept) {
		DepartmentEntity oldEntity=dRepo.findById(id).get();
		if(Objects.nonNull(dept.getDepartmentAddress()) && !"".equalsIgnoreCase(dept.getDepartmentAddress())) {
			oldEntity.setDepartmentAddress(dept.getDepartmentAddress());
		}
		if(Objects.nonNull(dept.getDepartmentCode()) && !"".equalsIgnoreCase(dept.getDepartmentCode())) {
			oldEntity.setDepartmentCode(dept.getDepartmentCode());
		}
		if(Objects.nonNull(dept.getDepartmentName()) && !"".equalsIgnoreCase(dept.getDepartmentName())) {
			oldEntity.setDepartmentName(dept.getDepartmentName());
		}
		return oldEntity;
	}

	public DepartmentEntity getDepartmentNamebyName(String name) {
		return dRepo.findBydepartmentNameIgnoreCase(name);
	}
}
