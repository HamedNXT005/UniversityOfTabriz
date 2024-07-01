package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerPreCoursesPlan;
import com.example.universityoftabriz.Objects.ElectricPreCoursesPlan;
import com.example.universityoftabriz.Repository.ComputerPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerPreCoursesPlanService {
    @Autowired
    private ComputerPreCoursesPlanRepository computerPreCoursesPlanRepository;

    public void updateComputerPreCoursesPlan(ComputerPreCoursesPlan computerPreCoursesPlan, Logger logger) {
        computerPreCoursesPlanRepository.save(computerPreCoursesPlan);
        logger.info("Computer Pre-Courses Plan with id: {} updated successfully.",computerPreCoursesPlan.getId());
    }
}
