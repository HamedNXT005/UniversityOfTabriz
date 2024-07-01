package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Repository.MechanicStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicStudentsPlanService {
    @Autowired
    private MechanicStudentsPlanRepository mechanicStudentsPlanRepository;

    public void updateMechanicStudentsPlan(MechanicStudentsPlan mechanicStudentsPlan, Logger logger) {
        mechanicStudentsPlanRepository.save(mechanicStudentsPlan);
        logger.info("Mechanic Students plan with id: {} updated successfully.",mechanicStudentsPlan.getId());
    }
}
