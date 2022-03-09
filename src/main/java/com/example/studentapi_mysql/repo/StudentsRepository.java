package com.example.studentapi_mysql.repo;

import com.example.studentapi_mysql.dto.StudentsDto;
import com.example.studentapi_mysql.model.Students;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students> findByName(String name);
}