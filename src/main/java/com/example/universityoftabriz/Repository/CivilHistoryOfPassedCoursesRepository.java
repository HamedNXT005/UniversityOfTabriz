package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.CivilHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CivilHistoryOfPassedCoursesRepository extends JpaRepository<CivilHistoryOfPassedCourses, Long> {
    List<CivilHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<CivilHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);

}
