package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerStudentsPlanRepository extends JpaRepository<ComputerStudentsPlan, Long> {


    List<ComputerStudentsPlan> findByStudentId(Long studentId);

    List<ComputerStudentsPlan> findByCourseId(Long courseId);
}
