package springbootmicroservices.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootmicroservices.employeeservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
 