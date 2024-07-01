package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.ElectricStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricStudentsPlanService {
    @Autowired
    private ElectricStudentsPlanRepository electricStudentsPlanRepository;

    public void updateElectricStudentsPlan(ElectricStudentsPlan electricStudentsPlan, Logger logger) {
        electricStudentsPlanRepository.save(electricStudentsPlan);
        logger.info("Electric Students plan with id: {} updated successfully.",electricStudentsPlan.getId());
    }
}
