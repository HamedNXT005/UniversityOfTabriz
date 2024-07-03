package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilStudentsPlan;
import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Repository.CivilStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilStudentsPlanService implements StudentsPlanService<CivilStudentsPlan>{
    @Autowired
    private CivilStudentsPlanRepository civilStudentsPlanRepository;

    public void updateCivilStudentsPlan(CivilStudentsPlan civilStudentsPlan, Logger logger) {
        civilStudentsPlanRepository.save(civilStudentsPlan);
        logger.info("Civil Students plan with id: {} updated successfully.",civilStudentsPlan.getId());
    }

    @Override
    public List<CivilStudentsPlan> getPlanByStudentId(Long student_id) {
        return civilStudentsPlanRepository.findByStudentId(student_id);
    }

    @Override
    public List<CivilStudentsPlan> getPlanByCourseId(Long course_id) {
        return civilStudentsPlanRepository.findByCourseId(course_id);
    }
}
