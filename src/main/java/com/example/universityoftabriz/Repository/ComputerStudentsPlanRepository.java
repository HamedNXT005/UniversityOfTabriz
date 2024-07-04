package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ComputerStudentsPlanRepository extends JpaRepository<ComputerStudentsPlan, Long> {


    List<ComputerStudentsPlan> findByStudentId(Long studentId);

    List<ComputerStudentsPlan> findByCourseId(Long courseId);

    Optional<ComputerStudentsPlan> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ComputerStudentsPlan findLastRecord();
}
