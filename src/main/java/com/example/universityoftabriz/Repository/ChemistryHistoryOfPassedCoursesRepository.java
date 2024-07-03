package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChemistryHistoryOfPassedCoursesRepository extends JpaRepository<ChemistryHistoryOfPassedCourses, Long> {
    List<ChemistryHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<ChemistryHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);

}
