package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerDefinedCourses;
import com.example.universityoftabriz.Objects.ElectricDefinedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComputerDefinedCoursesRepository extends JpaRepository<ComputerDefinedCourses, Long> {

    List<ComputerDefinedCourses> findByTeacherId(Long teacherId);

    List<ComputerDefinedCourses> findByCourseId(Long courseId);

    Optional<ComputerDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

}
