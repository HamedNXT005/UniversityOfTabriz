package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryDefinedCourses;
import com.example.universityoftabriz.Objects.CivilDefinedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChemistryDefinedCoursesRepository extends JpaRepository<ChemistryDefinedCourses, Long> {
    List<ChemistryDefinedCourses> findByTeacherId(Long teacherId);

    List<ChemistryDefinedCourses> findByCourseId(Long courseId);

    Optional<ChemistryDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

}
