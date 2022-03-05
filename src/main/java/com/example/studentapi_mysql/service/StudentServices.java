package com.example.studentapi_mysql.service;

import com.example.studentapi_mysql.dto.StudentsDto;
import com.example.studentapi_mysql.mapper.StudentMapper;
import com.example.studentapi_mysql.model.Students;
import com.example.studentapi_mysql.repo.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServices implements StudentsMethods {
    private final StudentsRepository repository;
    private final StudentMapper mapper;

    @Override
    public void addStudents(Students student) {
        repository.save(student);
    }

    @Override
    public void deleteStudentByID(Long id) {
        repository.deleteById(id);
    }

    @Override
    public StudentsDto getStudentByID(Long id) {
        Students student = repository.findById(id).orElseThrow(() -> new RuntimeException("No ID" + id));
        StudentsDto dto = mapper.mapToDto(student);
        return dto;
    }

    @Override
    public List<StudentsDto> getAllStudents() {
        List<Students> studentsList = repository.findAll();
        return mapper.mapToDtoAll(studentsList);
    }

    @Override
    public void updateStudentByID(Students student) {
        Students this_update = repository.findById(student.getId()).orElseThrow(() -> new RuntimeException("No ID for this update"));
        if (student.getName() != null) {
            this_update.setName(student.getName());
            repository.save(this_update);
        }
        if (student.getSurname() != null) {
            this_update.setSurname(student.getSurname());
            repository.save(this_update);
        }
        if (student.getAge() != 0 && student.getAge() > 0) {
            this_update.setAge(student.getAge());
            repository.save(this_update);
        }
        if (student.getAddress() != null) {
            this_update.setAddress(student.getAddress());
            repository.save(this_update);
        }
    }

    @Override
    public void deleteAllStudents() {
        repository.deleteAll();
    }

}
