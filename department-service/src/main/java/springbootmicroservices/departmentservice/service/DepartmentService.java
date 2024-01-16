package springbootmicroservices.departmentservice.service;

import springbootmicroservices.departmentservice.dto.departmentDto;
import springbootmicroservices.departmentservice.entity.Department;

public interface DepartmentService {
	
	departmentDto saveDepartment(departmentDto departmentdto);
	departmentDto getDepartmentByCode(String departmentcode);

}
