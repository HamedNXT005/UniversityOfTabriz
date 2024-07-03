package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerHistoryOfPassedCoursesRepository extends JpaRepository<ComputerHistoryOfPassedCourses, Long> {
    List<ComputerHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<ComputerHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);

}
