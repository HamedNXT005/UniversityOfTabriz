package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.ComputerHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerHistoryOfPassedCoursesService implements HistoryOfPassedCourses<ComputerHistoryOfPassedCourses>{
    @Autowired
    private ComputerHistoryOfPassedCoursesRepository computerHistoryOfPassedCoursesRepository;

    public void updateComputerHistoryOfPassedCourses(ComputerHistoryOfPassedCourses computerHistoryOfPassedCourses ) {
        computerHistoryOfPassedCoursesRepository.save(computerHistoryOfPassedCourses);
    }
    @Override
    public List<ComputerHistoryOfPassedCourses> getHistoryOfPCByStudentId(Long studentId){
        return computerHistoryOfPassedCoursesRepository.findByStudentId(studentId);
    }
    @Override
    public List<ComputerHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId){
        return computerHistoryOfPassedCoursesRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
    public ComputerHistoryOfPassedCourses findLastRecord() {
        return computerHistoryOfPassedCoursesRepository.findLastRecord();
    }
}
