package springbootmicroservices.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootmicroservices.departmentservice.dto.departmentDto;
import springbootmicroservices.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {



	




	private DepartmentService depService;
	
	//build save department rest api
	@PostMapping
	public ResponseEntity<departmentDto> saveDepartment(@RequestBody departmentDto depdto){
		
		departmentDto savedDto= depService.saveDepartment(depdto);
		return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
		
	}
	
	//getdepartment by code
		@GetMapping("{departmentcode}")
		public ResponseEntity<departmentDto> getDepartmentByCode(@PathVariable("departmentcode") String depcode){
			
			departmentDto getdep=depService.getDepartmentByCode(depcode);
			return new ResponseEntity<>(getdep, HttpStatus.OK);
			
		}
	
	
	
	
	//constructor
	
		public DepartmentController(DepartmentService depService) {
			super();
			this.depService = depService;
		}
		
	
}
