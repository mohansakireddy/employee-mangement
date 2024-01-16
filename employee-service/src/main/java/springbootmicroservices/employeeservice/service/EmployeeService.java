package springbootmicroservices.employeeservice.service;

import springbootmicroservices.employeeservice.Dto.APIResponseDto;
import springbootmicroservices.employeeservice.Dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeedto);
	APIResponseDto getEmployeeById(Long empID);

}
