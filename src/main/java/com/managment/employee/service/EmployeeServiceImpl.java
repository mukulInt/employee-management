package com.managment.employee.service;

import com.managment.employee.dtos.request.EmployeeRequestDTO;
import com.managment.employee.dtos.response.EmployeeResponseDTO;
import com.managment.employee.entity.Employee;
import com.managment.employee.exception.EmployeeNotFoundException;
import com.managment.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository repository;

  private EmployeeResponseDTO mapToDTO(Employee emp) {
    return EmployeeResponseDTO.builder()
        .id(emp.getId())
        .name(emp.getName())
        .department(emp.getDepartment())
        .salary(emp.getSalary())
        .build();
  }

  @Override
  public EmployeeResponseDTO create(EmployeeRequestDTO dto) {
    Employee employee = Employee.builder()
        .name(dto.getName())
        .department(dto.getDepartment())
        .salary(dto.getSalary())
        .build();
    return mapToDTO(repository.save(employee));
  }

  @Override
  public List<EmployeeResponseDTO> getAll(String department) {
    List<Employee> employees = (department != null) ?
        repository.findByDepartment(department) : repository.findAll();

    return employees.stream().map(this::mapToDTO).collect(Collectors.toList());
  }

  @Override
  public EmployeeResponseDTO getById(Long id) {
    return mapToDTO(repository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id)));
  }

  @Override
  public EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto) {
    Employee existing = repository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));

    existing.setName(dto.getName());
    existing.setDepartment(dto.getDepartment());
    existing.setSalary(dto.getSalary());

    return mapToDTO(repository.save(existing));
  }

  @Override
  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new EmployeeNotFoundException(id);
    }
    repository.deleteById(id);
  }
}

