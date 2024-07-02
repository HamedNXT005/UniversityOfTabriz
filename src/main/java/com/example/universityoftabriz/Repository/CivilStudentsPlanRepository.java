package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.CivilStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CivilStudentsPlanRepository extends JpaRepository<CivilStudentsPlan, Long> {


    List<CivilStudentsPlan> findByStudentId(Long studentId);

    List<CivilStudentsPlan> findByCourseId(Long courseId);
}
