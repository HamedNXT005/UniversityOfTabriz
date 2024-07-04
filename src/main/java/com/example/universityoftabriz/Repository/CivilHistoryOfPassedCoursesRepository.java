package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryDefinedCourses;
import com.example.universityoftabriz.Objects.CivilHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CivilHistoryOfPassedCoursesRepository extends JpaRepository<CivilHistoryOfPassedCourses, Long> {
    List<CivilHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<CivilHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    CivilHistoryOfPassedCourses findLastRecord();
}
