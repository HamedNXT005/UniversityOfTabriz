package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.CivilReport;
import com.example.universityoftabriz.Objects.CivilStudentsPlan;
import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CivilStudentsPlanRepository extends JpaRepository<CivilStudentsPlan, Long> {


    List<CivilStudentsPlan> findByStudentId(Long studentId);

    List<CivilStudentsPlan> findByCourseId(Long courseId);
    Optional<CivilStudentsPlan> findByStudentIdAndCourseId(Long studentId, Long courseId);

    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    CivilStudentsPlan findLastRecord();
}
