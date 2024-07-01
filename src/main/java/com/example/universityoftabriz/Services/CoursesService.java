package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Courses;
import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import com.example.universityoftabriz.Repository.CoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    public void updateCourses(Courses course, Logger logger) {
        coursesRepository.save(course);
        logger.info("Course with id: {} updated successfully.",course.getId());
    }
}
