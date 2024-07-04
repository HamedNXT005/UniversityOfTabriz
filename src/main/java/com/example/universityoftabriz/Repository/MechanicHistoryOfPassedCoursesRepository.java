package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryDefinedCourses;
import com.example.universityoftabriz.Objects.MechanicHistoryOfPassedCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MechanicHistoryOfPassedCoursesRepository extends JpaRepository<MechanicHistoryOfPassedCourses, Long> {


    List<MechanicHistoryOfPassedCourses> findByStudentId(Long studentId);

    List<MechanicHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    MechanicHistoryOfPassedCourses findLastRecord();
}
