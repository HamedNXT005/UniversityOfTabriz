package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ComputerHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.CivilHistoryOfPassedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilHistoryOfPassedCoursesService {
    @Autowired
    private CivilHistoryOfPassedCoursesRepository civilHistoryOfPassedCoursesRepository;

    public void updateCivilHistoryOfPassedCourses(CivilHistoryOfPassedCourses civilHistoryOfPassedCourses, Logger logger) {
        civilHistoryOfPassedCoursesRepository.save(civilHistoryOfPassedCourses);
        logger.info("Civil History of passed courses with id: {} updated successfully.",civilHistoryOfPassedCourses.getId());
    }
}
