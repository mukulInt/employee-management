package com.managment.employee.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponseDTO {
  private Long id;
  private String name;
  private String department;
  private double salary;
}
