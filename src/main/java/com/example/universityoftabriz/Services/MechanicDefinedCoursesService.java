package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.MechanicDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicDefinedCoursesService {
    @Autowired
    private MechanicDefinedCoursesRepository mechanicDefinedCoursesRepository;

    public void updateMechanicDefinedCourses(MechanicDefinedCourses mechanicDefinedCourses, Logger logger) {
        mechanicDefinedCoursesRepository.save(mechanicDefinedCourses);
        logger.info("Mechanic Defined Courses with id: {} updated successfully.",mechanicDefinedCourses.getId());
    }
}
