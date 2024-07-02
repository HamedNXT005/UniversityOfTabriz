package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher , Long> {

    Optional<Teacher> findByNameFAndNameL(String nameF, String nameL);

    List<Teacher> findByFaculty(String faculty);

    Optional<Teacher> findByNationalCode(String nationalCode);

    List<Teacher> findByStatus(String status);
}
