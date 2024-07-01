package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilDefinedCourses;
import com.example.universityoftabriz.Objects.ComputerDefinedCourses;
import com.example.universityoftabriz.Repository.CivilDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilDefinedCoursesService {
    @Autowired
    private CivilDefinedCoursesRepository civilDefinedCoursesRepository;

    public void updateCivilDefinedCourses(CivilDefinedCourses civilDefinedCourses, Logger logger) {
        civilDefinedCoursesRepository.save(civilDefinedCourses);
        logger.info("Civil Defined Courses with id: {} updated successfully.",civilDefinedCourses.getId());
    }
}
