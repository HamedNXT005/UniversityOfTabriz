package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Repository.ComputerStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerStudentsPlanService {
    @Autowired
    private ComputerStudentsPlanRepository computerStudentsPlanRepository;

    public void updateComputerStudentsPlan(ComputerStudentsPlan computerStudentsPlan, Logger logger) {
        computerStudentsPlanRepository.save(computerStudentsPlan);
        logger.info("Computer Students plan with id: {} updated successfully.",computerStudentsPlan.getId());
    }
}
