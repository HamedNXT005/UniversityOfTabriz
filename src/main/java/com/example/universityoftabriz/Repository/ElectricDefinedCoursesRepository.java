package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ElectricDefinedCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ElectricDefinedCoursesRepository extends JpaRepository<ElectricDefinedCourses, Long> {

    List<ElectricDefinedCourses> findByTeacherId(Long teacherId);

    List<ElectricDefinedCourses> findByCourseId(Long courseId);

    Optional<ElectricDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

    List<ElectricDefinedCourses> findByCapacityGreaterThan(int capacity);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ElectricDefinedCourses findLastRecord();

    Optional<ElectricDefinedCourses> findById(Long id);
}
