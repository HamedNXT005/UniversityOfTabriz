package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MechanicDefinedCoursesRepository extends JpaRepository<MechanicDefinedCourses, Long> {


    List<MechanicDefinedCourses> findByTeacherId(Long teacherId);

    List<MechanicDefinedCourses> findByCourseId(Long courseId);

    Optional<MechanicDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);
}
