package com.example.studentapi_mysql.mapper;

import com.example.studentapi_mysql.dto.StudentsDto;
import com.example.studentapi_mysql.dto.StudentsDto.StudentsDtoBuilder;
import com.example.studentapi_mysql.model.Students;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-05T15:50:55+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentsDto mapToDto(Students student) {
        if ( student == null ) {
            return null;
        }

        StudentsDtoBuilder studentsDto = StudentsDto.builder();

        studentsDto.ad( student.getName() );
        studentsDto.soyad( student.getSurname() );
        studentsDto.id( student.getId() );
        studentsDto.age( student.getAge() );
        studentsDto.address( student.getAddress() );
        studentsDto.grade( student.getGrade() );

        return studentsDto.build();
    }

    @Override
    public List<StudentsDto> mapToDtoAll(List<Students> studentsList) {
        if ( studentsList == null ) {
            return null;
        }

        List<StudentsDto> list = new ArrayList<StudentsDto>( studentsList.size() );
        for ( Students students : studentsList ) {
            list.add( mapToDto( students ) );
        }

        return list;
    }
}
