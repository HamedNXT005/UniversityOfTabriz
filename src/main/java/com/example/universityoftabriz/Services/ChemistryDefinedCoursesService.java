package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryDefinedCourses;
import com.example.universityoftabriz.Objects.CivilDefinedCourses;
import com.example.universityoftabriz.Repository.ChemistryDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryDefinedCoursesService {
    @Autowired
    private ChemistryDefinedCoursesRepository chemistryDefinedCoursesRepository;

    public void updateChemistryDefinedCourses(ChemistryDefinedCourses chemistryDefinedCourses, Logger logger) {
        chemistryDefinedCoursesRepository.save(chemistryDefinedCourses);
        logger.info("Chemistry Defined Courses with id: {} updated successfully.",chemistryDefinedCourses.getId());
    }
}
