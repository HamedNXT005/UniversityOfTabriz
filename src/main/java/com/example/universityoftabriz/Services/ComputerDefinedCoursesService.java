package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerDefinedCourses;
import com.example.universityoftabriz.Repository.ComputerDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerDefinedCoursesService implements DefinedCourses<ComputerDefinedCourses> {
    @Autowired
    private ComputerDefinedCoursesRepository computerDefinedCoursesRepository;

    public void updateComputerDefinedCourses(ComputerDefinedCourses computerDefinedCourses, Logger logger) {
        computerDefinedCoursesRepository.save(computerDefinedCourses);
        logger.info("Computer Defined Courses with id: {} updated successfully.",computerDefinedCourses.getId());
    }

    @Override
    public List<ComputerDefinedCourses> getDCByTeacherId(Long teacherId){
        return computerDefinedCoursesRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<ComputerDefinedCourses> getDCByCourseId(Long courseId){
        return computerDefinedCoursesRepository.findByCourseId(courseId);
    }
    @Override
    public Optional<ComputerDefinedCourses> getDCByTeacherIdAndCourseId(Long teacherId, Long courseId){
        return computerDefinedCoursesRepository.findByTeacherIdAndCourseId(teacherId, courseId);
    }
}
