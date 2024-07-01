package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.MechanicHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.ElectricHistoryOfPassedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricHistoryOfPassedCoursesService {
    @Autowired
    private ElectricHistoryOfPassedCoursesRepository electricHistoryOfPassedCoursesRepository;

    public void updateElectricHistoryOfPassedCourses(ElectricHistoryOfPassedCourses electricHistoryOfPassedCourses, Logger logger) {
        electricHistoryOfPassedCoursesRepository.save(electricHistoryOfPassedCourses);
        logger.info("Electric History of passed courses with id: {} updated successfully.",electricHistoryOfPassedCourses.getId());
    }
}
