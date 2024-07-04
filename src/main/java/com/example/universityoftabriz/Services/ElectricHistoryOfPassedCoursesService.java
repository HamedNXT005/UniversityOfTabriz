package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.ElectricHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricHistoryOfPassedCoursesService implements HistoryOfPassedCourses<ElectricHistoryOfPassedCourses>{
    @Autowired
    private ElectricHistoryOfPassedCoursesRepository electricHistoryOfPassedCoursesRepository;

    public void updateElectricHistoryOfPassedCourses(ElectricHistoryOfPassedCourses electricHistoryOfPassedCourses ) {
        electricHistoryOfPassedCoursesRepository.save(electricHistoryOfPassedCourses);
    }

    @Override
    public List<ElectricHistoryOfPassedCourses> getHistoryOfPCByStudentId(Long studentId){
        return electricHistoryOfPassedCoursesRepository.findByStudentId(studentId);
    }
    @Override
    public List<ElectricHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId){
        return electricHistoryOfPassedCoursesRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
    public ElectricHistoryOfPassedCourses findLastRecord() {
        return electricHistoryOfPassedCoursesRepository.findLastRecord();
    }
}
