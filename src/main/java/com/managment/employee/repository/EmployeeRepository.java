package com.managment.employee.repository;


import com.managment.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByDepartment(String department);
}
