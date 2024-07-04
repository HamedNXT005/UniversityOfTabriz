package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ElectricStudentsPlanRepository extends JpaRepository<ElectricStudentsPlan, Long> {

    List<ElectricStudentsPlan> findByStudentId(Long studentId);

    List<ElectricStudentsPlan> findByCourseId(Long courseId);
    Optional<ElectricStudentsPlan> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ElectricStudentsPlan findLastRecord();
}
