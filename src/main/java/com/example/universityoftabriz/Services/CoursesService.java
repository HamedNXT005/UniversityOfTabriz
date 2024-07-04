package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.Courses;
import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import com.example.universityoftabriz.Repository.CoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    public void updateCourses(Courses course ) {
        coursesRepository.save(course);
    }

    public Optional<Courses> getById(long id){
        return coursesRepository.findById(id);
    }

    public Optional<Courses> getCourseByName(String name){
        return coursesRepository.findByName(name);
    }

    public List<Courses> getCoursesByFaculty(String faculty){
        return coursesRepository.findByFaculty(faculty);
    }

    public List<Courses> getCoursesByMajor(String major){
        return coursesRepository.findByMajor(major);
    }
}
