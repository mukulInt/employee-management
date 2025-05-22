package com.managment.employee.service;

import com.managment.employee.dtos.request.EmployeeRequestDTO;
import com.managment.employee.dtos.response.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
  EmployeeResponseDTO create(EmployeeRequestDTO dto);
  List<EmployeeResponseDTO> getAll(String department);
  EmployeeResponseDTO getById(Long id);
  EmployeeResponseDTO update(Long id, EmployeeRequestDTO dto);
  void delete(Long id);
}
