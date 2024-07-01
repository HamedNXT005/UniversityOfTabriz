package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricPreCoursesPlan;
import com.example.universityoftabriz.Objects.MechanicPreCoursesPlan;
import com.example.universityoftabriz.Repository.ElectricPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricPreCoursesPlanService {
    @Autowired
    private ElectricPreCoursesPlanRepository electricPreCoursesPlanRepository;

    public void updateElectricPreCoursesPlan(ElectricPreCoursesPlan electricPreCoursesPlan, Logger logger) {
        electricPreCoursesPlanRepository.save(electricPreCoursesPlan);
        logger.info("Electric Pre-Courses Plan with id: {} updated successfully.",electricPreCoursesPlan.getId());
    }
}
