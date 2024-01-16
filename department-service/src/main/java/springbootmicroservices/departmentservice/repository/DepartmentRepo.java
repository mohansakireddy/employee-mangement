package springbootmicroservices.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootmicroservices.departmentservice.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{
	
      Department findBydepartmentcode(String departmentcode);

}
