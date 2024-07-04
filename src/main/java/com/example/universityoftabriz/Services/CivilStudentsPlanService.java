package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilStudentsPlan;
import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Repository.CivilStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CivilStudentsPlanService implements StudentsPlanService<CivilStudentsPlan>{
    @Autowired
    private CivilStudentsPlanRepository civilStudentsPlanRepository;

    public void updateCivilStudentsPlan(CivilStudentsPlan civilStudentsPlan ) {
        civilStudentsPlanRepository.save(civilStudentsPlan);
    }

    @Override
    public List<CivilStudentsPlan> getPlanByStudentId(Long student_id) {
        return civilStudentsPlanRepository.findByStudentId(student_id);
    }

    @Override
    public List<CivilStudentsPlan> getPlanByCourseId(Long course_id) {
        return civilStudentsPlanRepository.findByCourseId(course_id);
    }
    public Optional<CivilStudentsPlan> getPlanByStudentIdAndCourseId(Long studentId, Long courseId){
        return civilStudentsPlanRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
}
