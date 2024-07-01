package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilPreCoursesPlan;
import com.example.universityoftabriz.Objects.ComputerPreCoursesPlan;
import com.example.universityoftabriz.Objects.Salary;
import com.example.universityoftabriz.Repository.CivilPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilPreCoursesPlanService {
    @Autowired
    private CivilPreCoursesPlanRepository civilPreCoursesPlanRepository;

    public void updateCivilPreCoursesPlan(CivilPreCoursesPlan civilPreCoursesPlan, Logger logger) {
        civilPreCoursesPlanRepository.save(civilPreCoursesPlan);
        logger.info("Civil Pre-Courses Plan with id: {} updated successfully.",civilPreCoursesPlan.getId());
    }
}
