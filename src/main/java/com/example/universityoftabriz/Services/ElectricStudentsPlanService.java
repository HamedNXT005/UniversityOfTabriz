package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.ElectricStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricStudentsPlanService implements StudentsPlanService<ElectricStudentsPlan>{
    @Autowired
    private ElectricStudentsPlanRepository electricStudentsPlanRepository;

    public void updateElectricStudentsPlan(ElectricStudentsPlan electricStudentsPlan, Logger logger) {
        electricStudentsPlanRepository.save(electricStudentsPlan);
        logger.info("Electric Students plan with id: {} updated successfully.",electricStudentsPlan.getId());
    }

    @Override
    public List<ElectricStudentsPlan> getPlanByStudentId(Long student_id) {
        return electricStudentsPlanRepository.findByStudentId(student_id);
    }

    @Override
    public List<ElectricStudentsPlan> getPlanByCourseId(Long course_id) {
        return electricStudentsPlanRepository.findByCourseId(course_id);
    }
}
