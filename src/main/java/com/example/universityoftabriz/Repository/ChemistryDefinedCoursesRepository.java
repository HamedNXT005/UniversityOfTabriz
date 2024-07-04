package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryDefinedCourses;
import com.example.universityoftabriz.Objects.CivilDefinedCourses;
import com.example.universityoftabriz.Objects.ComputerDefinedCourses;
import com.example.universityoftabriz.Objects.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChemistryDefinedCoursesRepository extends JpaRepository<ChemistryDefinedCourses, Long> {
    List<ChemistryDefinedCourses> findByTeacherId(Long teacherId);

    List<ChemistryDefinedCourses> findByCourseId(Long courseId);

    Optional<ChemistryDefinedCourses> findByTeacherIdAndCourseId(Long teacherId, Long courseId);

    List<ChemistryDefinedCourses> findByCapacityGreaterThan(int capacity);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ChemistryDefinedCourses findLastRecord();
}
