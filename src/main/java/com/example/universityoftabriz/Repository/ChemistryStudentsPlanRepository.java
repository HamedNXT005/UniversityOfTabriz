package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryStudentsPlan;
import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChemistryStudentsPlanRepository extends JpaRepository<ChemistryStudentsPlan, Long> {


    List<ChemistryStudentsPlan> findByStudentId(Long studentId);

    List<ChemistryStudentsPlan> findByCourseId(Long courseId);

    Optional<ChemistryStudentsPlan> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
