package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicPreCoursesPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.MechanicPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicPreCoursesPlanService {
    @Autowired
    private MechanicPreCoursesPlanRepository mechanicPreCoursesPlanRepository;

    public void updateMechanicPreCoursesPlan(MechanicPreCoursesPlan mechanicPreCoursesPlan, Logger logger) {
        mechanicPreCoursesPlanRepository.save(mechanicPreCoursesPlan);
        logger.info("Mechanic Pre-Courses Plan with id: {} updated successfully.",mechanicPreCoursesPlan.getId());
    }
}
