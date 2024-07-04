package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ElectricDefinedCourses;
import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ElectricDefinedCoursesRepository extends JpaRepository<ElectricDefinedCourses, Long> {

    List<ElectricDefinedCourses> findByTeacherId(Long teacherId);

    List<ElectricDefinedCourses> findByCourseId(Long courseId);

    Optional<ElectricDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

    List<ElectricDefinedCourses> findByCapacityGreaterThan(int capacity);
}
