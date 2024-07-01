package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryStudentsPlan;
import com.example.universityoftabriz.Objects.CivilStudentsPlan;
import com.example.universityoftabriz.Repository.ChemistryStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryStudentsPlanService {
    @Autowired
    private ChemistryStudentsPlanRepository chemistryStudentsPlanRepository;

    public void updateChemistryStudentsPlan(ChemistryStudentsPlan chemistryStudentsPlan, Logger logger) {
        chemistryStudentsPlanRepository.save(chemistryStudentsPlan);
        logger.info("Chemistry Students plan with id: {} updated successfully.",chemistryStudentsPlan.getId());
    }
}
