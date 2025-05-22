package com.managment.employee.constoller;



import com.managment.employee.dtos.request.EmployeeRequestDTO;
import com.managment.employee.dtos.response.EmployeeResponseDTO;
import com.managment.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService service;

  @PostMapping
  public EmployeeResponseDTO addEmployee(@Valid @RequestBody EmployeeRequestDTO dto) {
    return service.create(dto);
  }

  @GetMapping
  public List<EmployeeResponseDTO> getAllEmployees(@RequestParam(required = false) String department) {
    return service.getAll(department);
  }

  @GetMapping("/{id}")
  public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public EmployeeResponseDTO updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO dto) {
    return service.update(id, dto);
  }

  @DeleteMapping("/{id}")
  public String deleteEmployee(@PathVariable Long id) {
    service.delete(id);
    return "Employee with ID " + id + " deleted successfully.";
  }
}