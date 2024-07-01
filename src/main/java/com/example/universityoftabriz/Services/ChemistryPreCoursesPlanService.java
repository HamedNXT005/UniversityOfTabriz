package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryPreCoursesPlan;
import com.example.universityoftabriz.Objects.CivilPreCoursesPlan;
import com.example.universityoftabriz.Repository.ChemistryPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryPreCoursesPlanService {
    @Autowired
    private ChemistryPreCoursesPlanRepository chemistryPreCoursesPlanRepository;

    public void updateChemistryPreCoursesPlan(ChemistryPreCoursesPlan chemistryPreCoursesPlan, Logger logger) {
        chemistryPreCoursesPlanRepository.save(chemistryPreCoursesPlan);
        logger.info("Chemistry Pre-Courses Plan with id: {} updated successfully.",chemistryPreCoursesPlan.getId());
    }
}
