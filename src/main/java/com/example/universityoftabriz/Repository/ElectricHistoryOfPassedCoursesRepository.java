package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.MechanicHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectricHistoryOfPassedCoursesRepository extends JpaRepository<ElectricHistoryOfPassedCourses, Long> {

    List<ElectricHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<ElectricHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);

}
