package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilStudentsPlan;
import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Repository.CivilStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilStudentsPlanService {
    @Autowired
    private CivilStudentsPlanRepository civilStudentsPlanRepository;

    public void updateCivilStudentsPlan(CivilStudentsPlan civilStudentsPlan, Logger logger) {
        civilStudentsPlanRepository.save(civilStudentsPlan);
        logger.info("Civil Students plan with id: {} updated successfully.",civilStudentsPlan.getId());
    }
}
