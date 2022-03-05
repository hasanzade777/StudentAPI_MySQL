package com.example.studentapi_mysql.controller;

import com.example.studentapi_mysql.dto.StudentsDto;
import com.example.studentapi_mysql.model.Students;
import com.example.studentapi_mysql.service.StudentServices;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studapimysql")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServices services;

    @PostMapping
    public ResponseEntity<HttpStatus> addStudent(@RequestBody Students student) {
        services.addStudents(student);
        System.out.println(student);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public StudentsDto getStudentById(@PathVariable Long id) {
        return services.getStudentByID(id);
    }

    @GetMapping
    public List<StudentsDto> getAllStudents() {
        return services.getAllStudents();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateStudentById(@RequestBody Students student) {
        services.updateStudentByID(student);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        services.deleteStudentByID(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllStudents(){
        services.deleteAllStudents();
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
