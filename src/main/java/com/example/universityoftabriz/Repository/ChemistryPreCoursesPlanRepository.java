package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryPreCoursesPlan;
import com.example.universityoftabriz.Objects.CivilPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChemistryPreCoursesPlanRepository extends JpaRepository<ChemistryPreCoursesPlan, Long> {

    List<ChemistryPreCoursesPlan> findByCourseId(Long course_id);

    List<ChemistryPreCoursesPlan> findByTeacherId(Long teacherId);

    List<ChemistryPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);

}
