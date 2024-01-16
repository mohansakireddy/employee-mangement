package springbootmicroservices.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootmicroservices.employeeservice.Dto.APIResponseDto;
import springbootmicroservices.employeeservice.Dto.EmployeeDto;
import springbootmicroservices.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto){
		EmployeeDto savedEmpDto=empService.saveEmployee(empDto);
		
		return new ResponseEntity<>(savedEmpDto, HttpStatus.CREATED);
	}

	//build emp get api
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id")Long empId){
		
		APIResponseDto getEmployee= empService.getEmployeeById(empId);
		return new ResponseEntity<>(getEmployee, HttpStatus.OK);
	}
	
	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
}
