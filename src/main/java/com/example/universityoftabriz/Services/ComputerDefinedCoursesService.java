package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerDefinedCourses;
import com.example.universityoftabriz.Objects.ElectricDefinedCourses;
import com.example.universityoftabriz.Repository.ComputerDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerDefinedCoursesService {
    @Autowired
    private ComputerDefinedCoursesRepository computerDefinedCoursesRepository;

    public void updateComputerDefinedCourses(ComputerDefinedCourses computerDefinedCourses, Logger logger) {
        computerDefinedCoursesRepository.save(computerDefinedCourses);
        logger.info("Computer Defined Courses with id: {} updated successfully.",computerDefinedCourses.getId());
    }
}
