package com.example.studentapi_mysql.service;

import com.example.studentapi_mysql.dto.StudentsDto;
import com.example.studentapi_mysql.model.Students;

import java.util.List;

public interface StudentsMethods {
    void addStudents(Students student);
    void deleteStudentByID(Long id);
    StudentsDto getStudentByID(Long id);
    List<StudentsDto> getAllStudents();
    void updateStudentByID(Students student);
    void deleteAllStudents();
}
