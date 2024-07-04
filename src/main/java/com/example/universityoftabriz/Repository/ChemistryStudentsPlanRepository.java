package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryStudentsPlan;
import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChemistryStudentsPlanRepository extends JpaRepository<ChemistryStudentsPlan, Long> {


    List<ChemistryStudentsPlan> findByStudentId(Long studentId);

    List<ChemistryStudentsPlan> findByCourseId(Long courseId);

    Optional<ChemistryStudentsPlan> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ChemistryStudentsPlan findLastRecord();
}
