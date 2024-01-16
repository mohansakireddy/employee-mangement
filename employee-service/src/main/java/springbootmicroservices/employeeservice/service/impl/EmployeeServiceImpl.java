package springbootmicroservices.employeeservice.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import springbootmicroservices.employeeservice.Dto.APIResponseDto;
import springbootmicroservices.employeeservice.Dto.DepartmentDto;
import springbootmicroservices.employeeservice.Dto.EmployeeDto;
import springbootmicroservices.employeeservice.entity.Employee;
import springbootmicroservices.employeeservice.repository.EmployeeRepo;
import springbootmicroservices.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	



	private EmployeeRepo empRepo;
	private RestTemplate restTemplate;
	//private WebClient webClient;
//	private APIClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeedto) {
		
		Employee emp= new Employee(
				employeedto.getId(),
				employeedto.getFirstName(),
				employeedto.getLastName(),
				employeedto.getEmail(),
				employeedto.getDepartmentcode()
				);
		
		Employee savedEmp= empRepo.save(emp);
		
		EmployeeDto savedEmpDto=new EmployeeDto(
				emp.getId(),
				emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail(),
				emp.getDepartmentcode()
				);
		
		
		return savedEmpDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long empID) {
		Employee employeeDetails = empRepo.findById(empID).get();
		//if (employeeDetails.isPresent()){

			EmployeeDto empDto= new EmployeeDto(
					employeeDetails.getId(),
					employeeDetails.getFirstName(),
					employeeDetails.getFirstName(),
					employeeDetails.getEmail(),
					employeeDetails.getDepartmentcode()



			);

			//using rest template
		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employeeDetails.getDepartmentcode(), DepartmentDto.class);
    	DepartmentDto departmentDto = responseEntity.getBody();
			APIResponseDto apiResponseDto= new APIResponseDto();
			apiResponseDto.setEmployee(empDto);
			apiResponseDto.setDepartment(departmentDto);


         return apiResponseDto;

		//using rest template
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+ getEmp.getDepartmentcode(), DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();
		
		//using webclient
		
//		DepartmentDto departmentDto = webClient.get()
//		.uri("http://localhost:8080/api/departments/"+ getEmp.getDepartmentcode())
//	     .retrieve()
//	     .bodyToMono(DepartmentDto.class)
//	     .block();
	
		//using feign client
/*
		DepartmentDto departmentDto=apiClient.getDepartmentByCode(employeeDetails.get.getDepartmentcode());

		EmployeeDto getEmpDto= EmployeeDto(
				employeeDetails.get()
		);
		APIResponseDto apiResponseDto= new APIResponseDto();
		apiResponseDto.setEmployee(getEmpDto);
		apiResponseDto.setDepartment(departmentDto);
	  */

	}

	public EmployeeServiceImpl(EmployeeRepo empRepo,RestTemplate restTemplate) {
		super();
		this.empRepo = empRepo;
		this.restTemplate=restTemplate;

	}
	
}
