package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.CivilDefinedCourses;
import com.example.universityoftabriz.Objects.ComputerDefinedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CivilDefinedCoursesRepository extends JpaRepository<CivilDefinedCourses, Long> {

    List<CivilDefinedCourses> findByTeacherId(Long teacherId);

    List<CivilDefinedCourses> findByCourseId(Long courseId);

    Optional<CivilDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

    List<CivilDefinedCourses> findByCapacityGreaterThan(int capacity);
}
