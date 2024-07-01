package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerHistoryOfPassedCourses;
import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.ComputerHistoryOfPassedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerHistoryOfPassedCoursesService {
    @Autowired
    private ComputerHistoryOfPassedCoursesRepository computerHistoryOfPassedCoursesRepository;

    public void updateComputerHistoryOfPassedCourses(ComputerHistoryOfPassedCourses computerHistoryOfPassedCourses, Logger logger) {
        computerHistoryOfPassedCoursesRepository.save(computerHistoryOfPassedCourses);
        logger.info("Computer History of passed courses with id: {} updated successfully.",computerHistoryOfPassedCourses.getId());
    }
}
