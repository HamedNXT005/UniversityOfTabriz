package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricDefinedCourses;
import com.example.universityoftabriz.Repository.ElectricDefinedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectricDefinedCoursesService implements DefinedCourses<ElectricDefinedCourses>{
    @Autowired
    private ElectricDefinedCoursesRepository electricDefinedCoursesRepository;

    public void updateElectricDefinedCourses(ElectricDefinedCourses electricDefinedCourses ) {
        electricDefinedCoursesRepository.save(electricDefinedCourses);
    }

    public List<ElectricDefinedCourses> getAvailableCourses(){
        return electricDefinedCoursesRepository.findByCapacityGreaterThan(0);
    }

    @Override
    public List<ElectricDefinedCourses> getDCByTeacherId(Long teacherId){
        return electricDefinedCoursesRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<ElectricDefinedCourses> getDCByCourseId(Long courseId){
        return electricDefinedCoursesRepository.findByCourseId(courseId);
    }
    @Override
    public Optional<ElectricDefinedCourses> getDCByTeacherIdAndCourseId(Long teacherId, Long courseId){
        return electricDefinedCoursesRepository.findByTeacherIdAndCourseId(teacherId, courseId);
    }
}
