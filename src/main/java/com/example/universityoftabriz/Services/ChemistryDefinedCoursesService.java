package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryDefinedCourses;
import com.example.universityoftabriz.Repository.ChemistryDefinedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChemistryDefinedCoursesService implements DefinedCourses<ChemistryDefinedCourses> {
    @Autowired
    private ChemistryDefinedCoursesRepository chemistryDefinedCoursesRepository;

    public void updateChemistryDefinedCourses(ChemistryDefinedCourses chemistryDefinedCourses) {
        chemistryDefinedCoursesRepository.save(chemistryDefinedCourses);
    }

    public List<ChemistryDefinedCourses> getAvailableCourses(){
        return chemistryDefinedCoursesRepository.findByCapacityGreaterThan(0);
    }

    @Override
    public List<ChemistryDefinedCourses> getDCByTeacherId(Long teacherId){
        return chemistryDefinedCoursesRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<ChemistryDefinedCourses> getDCByCourseId(Long courseId){
        return chemistryDefinedCoursesRepository.findByCourseId(courseId);
    }
    @Override
    public Optional<ChemistryDefinedCourses> getDCByTeacherIdAndCourseId(Long teacherId, Long courseId){
        return chemistryDefinedCoursesRepository.findByTeacherIdAndCourseId(teacherId, courseId);
    }

    public ChemistryDefinedCourses findLastRecord() {
        return chemistryDefinedCoursesRepository.findLastRecord();
    }

    public Optional<ChemistryDefinedCourses> getDCourse(Long id){
        return chemistryDefinedCoursesRepository.findById(id);
    }
}
