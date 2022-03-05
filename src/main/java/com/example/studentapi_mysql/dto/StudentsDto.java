package com.example.studentapi_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentsDto {
    private Long id;
    private String ad;
    private String soyad;
    private int age;
    private String address;
    private int grade;
}
