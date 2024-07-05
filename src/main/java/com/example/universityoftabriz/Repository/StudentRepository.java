package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student , Long> {

    List<Student> findByFaculty(String faculty);

    List<Student> findByMajor(String major);

    Optional<Student> findByUserName(String userName);

    Optional<Student> findByNameFAndNameL(String nameF, String nameL);

    Optional<Student> findByNationalCode(String nationalCode);

    List<Student> findByGpaTotalGreaterThan(float gpaTotal);

    @Query(value = "SELECT TOP 1 * FROM info_students ORDER BY id DESC", nativeQuery = true)
    Student findLastStudent();
}
