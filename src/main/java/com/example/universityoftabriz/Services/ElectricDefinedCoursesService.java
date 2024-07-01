package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricDefinedCourses;
import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import com.example.universityoftabriz.Repository.ElectricDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricDefinedCoursesService {
    @Autowired
    private ElectricDefinedCoursesRepository electricDefinedCoursesRepository;

    public void updateElectricDefinedCourses(ElectricDefinedCourses electricDefinedCourses, Logger logger) {
        electricDefinedCoursesRepository.save(electricDefinedCourses);
        logger.info("Electric Defined Courses with id: {} updated successfully.",electricDefinedCourses.getId());
    }
}
