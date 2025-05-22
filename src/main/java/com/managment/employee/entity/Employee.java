package com.managment.employee.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String department;

  @Column(nullable = false)
  private double salary;
}