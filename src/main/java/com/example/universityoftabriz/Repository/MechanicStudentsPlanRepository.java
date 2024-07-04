package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MechanicStudentsPlanRepository extends JpaRepository<MechanicStudentsPlan, Long> {


    List<MechanicStudentsPlan> findByStudentId(Long student_id);

    List<MechanicStudentsPlan> findByCourseId(Long course_id);
    Optional<MechanicStudentsPlan> findByStudentIdAndCourseId(Long studentId, Long courseId);
    @Query(value = "SELECT * FROM resources ORDER BY id DESC LIMIT 1", nativeQuery = true)
    MechanicStudentsPlan findLastRecord();
}
