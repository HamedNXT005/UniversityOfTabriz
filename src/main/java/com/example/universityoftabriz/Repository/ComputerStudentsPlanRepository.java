package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComputerStudentsPlanRepository extends JpaRepository<ComputerStudentsPlan, Long> {


    List<ComputerStudentsPlan> findByStudentId(Long studentId);

    List<ComputerStudentsPlan> findByCourseId(Long courseId);

    Optional<ComputerStudentsPlan> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
