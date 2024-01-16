package springbootmicroservices.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import springbootmicroservices.departmentservice.dto.departmentDto;
import springbootmicroservices.departmentservice.entity.Department;
import springbootmicroservices.departmentservice.repository.DepartmentRepo;
import springbootmicroservices.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepo deprepo;
	@Override
	public departmentDto saveDepartment(departmentDto departmentdto) {
		// converting depdto to jpa entity
		
		Department dt= new Department(
				departmentdto.getId(),
				departmentdto.getDepartmentName(),
				departmentdto.getDepartmentDescription(),
				departmentdto.getDepartmentcode()
				);
		Department savedDepartment= deprepo.save(dt);
		
		//converting jpa to dto
		
		departmentDto saveddepdto= new departmentDto(
				savedDepartment.getId(),
				savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentcode()
				
				
				);
		
				
		
		return saveddepdto;
	}
	@Override
	public departmentDto getDepartmentByCode(String departmentcode) {
	   Department getdep= deprepo.findBydepartmentcode(departmentcode);
		   
		   departmentDto depDto= new departmentDto(
				   getdep.getId(),
				   getdep.getDepartmentName(),
				   getdep.getDepartmentDescription(),
				   getdep.getDepartmentcode()
				   );
				   
	
		return depDto;
	
	}


	//constrcts

	public DepartmentServiceImpl(DepartmentRepo deprepo) {
		super();
		this.deprepo = deprepo;
	}
	



	

}
