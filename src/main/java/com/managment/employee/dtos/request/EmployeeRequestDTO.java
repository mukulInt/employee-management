package com.managment.employee.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequestDTO {

  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotBlank(message = "Department must not be blank")
  private String department;

  @Min(value = 0, message = "Salary must be greater than 0")
  private double salary;
}
