package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerDefinedCourses;
import com.example.universityoftabriz.Objects.ElectricDefinedCourses;
import com.example.universityoftabriz.Objects.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ComputerDefinedCoursesRepository extends JpaRepository<ComputerDefinedCourses, Long> {

    List<ComputerDefinedCourses> findByTeacherId(Long teacherId);

    List<ComputerDefinedCourses> findByCourseId(Long courseId);

    Optional<ComputerDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

    List<ComputerDefinedCourses> findByCapacityGreaterThan(int capacity);

    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ComputerDefinedCourses findLastRecord();
}
