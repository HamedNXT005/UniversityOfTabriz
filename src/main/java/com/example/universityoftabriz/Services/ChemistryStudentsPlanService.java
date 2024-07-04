package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryStudentsPlan;
import com.example.universityoftabriz.Objects.CivilStudentsPlan;
import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Repository.ChemistryStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChemistryStudentsPlanService implements StudentsPlanService<ChemistryStudentsPlan>{
    @Autowired
    private ChemistryStudentsPlanRepository chemistryStudentsPlanRepository;

    public void updateChemistryStudentsPlan(ChemistryStudentsPlan chemistryStudentsPlan ) {
        chemistryStudentsPlanRepository.save(chemistryStudentsPlan);
    }

    @Override
    public List<ChemistryStudentsPlan> getPlanByStudentId(Long student_id) {
        return chemistryStudentsPlanRepository.findByStudentId(student_id);
    }

    @Override
    public List<ChemistryStudentsPlan> getPlanByCourseId(Long course_id) {
        return chemistryStudentsPlanRepository.findByCourseId(course_id);
    }

    @Override
    public ChemistryStudentsPlan findLastRecord() {
        return chemistryStudentsPlanRepository.findLastRecord();
    }

    public Optional<ChemistryStudentsPlan> getPlanByStudentIdAndCourseId(Long studentId, Long courseId){
        return chemistryStudentsPlanRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
}
