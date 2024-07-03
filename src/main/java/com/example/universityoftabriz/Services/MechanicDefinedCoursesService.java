package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicDefinedCourses;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.MechanicDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicDefinedCoursesService implements DefinedCourses<MechanicDefinedCourses> {
    @Autowired
    private MechanicDefinedCoursesRepository mechanicDefinedCoursesRepository;

    public void updateMechanicDefinedCourses(MechanicDefinedCourses mechanicDefinedCourses, Logger logger) {
        mechanicDefinedCoursesRepository.save(mechanicDefinedCourses);
        logger.info("Mechanic Defined Courses with id: {} updated successfully.",mechanicDefinedCourses.getId());
    }
    @Override
    public List<MechanicDefinedCourses> getDCByTeacherId(Long teacherId){
        return mechanicDefinedCoursesRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<MechanicDefinedCourses> getDCByCourseId(Long courseId){
        return mechanicDefinedCoursesRepository.findByCourseId(courseId);
    }
    @Override
    public Optional<MechanicDefinedCourses> getDCByTeacherIdAndCourseId(Long teacherId, Long courseId){
        return mechanicDefinedCoursesRepository.findByTeacherIdAndCourseId(teacherId, courseId);
    }
}
