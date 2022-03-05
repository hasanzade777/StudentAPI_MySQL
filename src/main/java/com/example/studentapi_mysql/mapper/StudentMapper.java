package com.example.studentapi_mysql.mapper;

import com.example.studentapi_mysql.dto.StudentsDto;
import com.example.studentapi_mysql.model.Students;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface StudentMapper {
    @Mapping(target = "ad", source = "name")
    @Mapping(target = "soyad", source = "surname")
    StudentsDto mapToDto(Students student);

    List<StudentsDto> mapToDtoAll(List<Students> studentsList);
}
