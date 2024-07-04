package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryDefinedCourses;
import com.example.universityoftabriz.Objects.ChemistryHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChemistryHistoryOfPassedCoursesRepository extends JpaRepository<ChemistryHistoryOfPassedCourses, Long> {
    List<ChemistryHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<ChemistryHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    ChemistryHistoryOfPassedCourses findLastRecord();
}
