package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MechanicStudentsPlanRepository extends JpaRepository<MechanicStudentsPlan, Long> {


    List<MechanicStudentsPlan> findByStudentId(Long student_id);

    List<MechanicStudentsPlan> findByCourseId(Long course_id);
}
