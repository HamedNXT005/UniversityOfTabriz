package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilDefinedCourses;
import com.example.universityoftabriz.Repository.CivilDefinedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CivilDefinedCoursesService implements DefinedCourses<CivilDefinedCourses> {
    @Autowired
    private CivilDefinedCoursesRepository civilDefinedCoursesRepository;

    public void updateCivilDefinedCourses(CivilDefinedCourses civilDefinedCourses) {
        civilDefinedCoursesRepository.save(civilDefinedCourses);
    }

    public List<CivilDefinedCourses> getAvailableCourses(){
        return civilDefinedCoursesRepository.findByCapacityGreaterThan(0);
    }
    @Override
    public List<CivilDefinedCourses> getDCByTeacherId(Long teacherId){
        return civilDefinedCoursesRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<CivilDefinedCourses> getDCByCourseId(Long courseId){
        return civilDefinedCoursesRepository.findByCourseId(courseId);
    }
    @Override
    public Optional<CivilDefinedCourses> getDCByTeacherIdAndCourseId(Long teacherId, Long courseId){
        return civilDefinedCoursesRepository.findByTeacherIdAndCourseId(teacherId, courseId);
    }

    public CivilDefinedCourses findLastRecord() {
        return civilDefinedCoursesRepository.findLastRecord();
    }

    public Optional<CivilDefinedCourses> getDCourse(Long id){
        return civilDefinedCoursesRepository.findById(id);
    }
}
