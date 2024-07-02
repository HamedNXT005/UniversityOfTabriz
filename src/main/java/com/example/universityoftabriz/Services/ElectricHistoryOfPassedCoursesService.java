package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.ElectricHistoryOfPassedCoursesRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricHistoryOfPassedCoursesService implements HistoryOfPassedCourses<ElectricHistoryOfPassedCourses>{
    @Autowired
    private ElectricHistoryOfPassedCoursesRepository electricHistoryOfPassedCoursesRepository;

    public void updateElectricHistoryOfPassedCourses(ElectricHistoryOfPassedCourses electricHistoryOfPassedCourses, Logger logger) {
        electricHistoryOfPassedCoursesRepository.save(electricHistoryOfPassedCourses);
        logger.info("Electric History of passed courses with id: {} updated successfully.",electricHistoryOfPassedCourses.getId());
    }

    @Override
    public List<ElectricHistoryOfPassedCourses> getHistoryOfPCByStudentId(Long studentId){
        return electricHistoryOfPassedCoursesRepository.findByStudentId(studentId);
    }
    @Override
    public List<ElectricHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId){
        return electricHistoryOfPassedCoursesRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
}
