package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.MechanicHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MechanicHistoryOfPassedCoursesRepository extends JpaRepository<MechanicHistoryOfPassedCourses, Long> {


    List<MechanicHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<MechanicHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
