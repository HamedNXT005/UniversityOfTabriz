package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.CivilHistoryOfPassedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilHistoryOfPassedCoursesService implements HistoryOfPassedCourses<CivilHistoryOfPassedCourses>{
    @Autowired
    private CivilHistoryOfPassedCoursesRepository civilHistoryOfPassedCoursesRepository;

    public void updateCivilHistoryOfPassedCourses(CivilHistoryOfPassedCourses civilHistoryOfPassedCourses ) {
        civilHistoryOfPassedCoursesRepository.save(civilHistoryOfPassedCourses);
    }

    @Override
    public List<CivilHistoryOfPassedCourses> getHistoryOfPCByStudentId(Long studentId){
        return civilHistoryOfPassedCoursesRepository.findByStudentId(studentId);
    }
    @Override
    public List<CivilHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId){
        return civilHistoryOfPassedCoursesRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
}
