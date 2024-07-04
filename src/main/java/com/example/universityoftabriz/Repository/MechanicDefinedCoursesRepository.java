package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Objects.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MechanicDefinedCoursesRepository extends JpaRepository<MechanicDefinedCourses, Long> {


    List<MechanicDefinedCourses> findByTeacherId(Long teacherId);

    List<MechanicDefinedCourses> findByCourseId(Long courseId);

    Optional<MechanicDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

    List<MechanicDefinedCourses> findByCapacityGreaterThan(int capacity);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    MechanicDefinedCourses findLastRecord();
}
