package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicHistoryOfPassedCourses;
import com.example.universityoftabriz.Repository.MechanicHistoryOfPassedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicHistoryOfPassedCoursesService implements HistoryOfPassedCourses<MechanicHistoryOfPassedCourses>{
    @Autowired
    private MechanicHistoryOfPassedCoursesRepository mechanicHistoryOfPassedCoursesRepository;

    public void updateMechanicHistoryOfPassedCourses(MechanicHistoryOfPassedCourses mechanicHistoryOfPassedCourses) {
        mechanicHistoryOfPassedCoursesRepository.save(mechanicHistoryOfPassedCourses);
    }
    @Override
    public List<MechanicHistoryOfPassedCourses> getHistoryOfPCByStudentId(Long studentId){
        return mechanicHistoryOfPassedCoursesRepository.findByStudentId(studentId);
    }
    @Override
    public List<MechanicHistoryOfPassedCourses> findByStudentIdAndCourseId(Long studentId, Long courseId){
        return mechanicHistoryOfPassedCoursesRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
    public MechanicHistoryOfPassedCourses findLastRecord() {
        return mechanicHistoryOfPassedCoursesRepository.findLastRecord();
    }
}
