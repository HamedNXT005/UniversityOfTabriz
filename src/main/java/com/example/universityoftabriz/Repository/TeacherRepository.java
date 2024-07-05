package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher , Long> {
    Optional<Teacher> findByUserName(String userName);

    Optional<Teacher> findByNameFAndNameL(String nameF, String nameL);

    List<Teacher> findByFaculty(String faculty);

    Optional<Teacher> findByNationalCode(String nationalCode);

    List<Teacher> findByStatus(String status);

    @Query(value = "SELECT TOP 1 * FROM info_teachers ORDER BY id DESC", nativeQuery = true)
    Teacher findLastTeacher();
}
