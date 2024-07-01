package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.MechanicHistoryOfPassedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicHistoryOfPassedCoursesService {
    @Autowired
    private MechanicHistoryOfPassedCoursesRepository mechanicHistoryOfPassedCoursesRepository;

    public void updateMechanicHistoryOfPassedCourses(MechanicHistoryOfPassedCourses mechanicHistoryOfPassedCourses, Logger logger) {
        mechanicHistoryOfPassedCoursesRepository.save(mechanicHistoryOfPassedCourses);
        logger.info("Mechanic History of passed courses with id: {} updated successfully.",mechanicHistoryOfPassedCourses.getId());
    }
}
