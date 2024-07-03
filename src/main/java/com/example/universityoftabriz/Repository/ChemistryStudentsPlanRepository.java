package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChemistryStudentsPlanRepository extends JpaRepository<ChemistryStudentsPlan, Long> {


    List<ChemistryStudentsPlan> findByStudentId(Long studentId);

    List<ChemistryStudentsPlan> findByCourseId(Long courseId);
}
