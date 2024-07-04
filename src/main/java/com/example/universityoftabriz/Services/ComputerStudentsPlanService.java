package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Repository.ComputerStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerStudentsPlanService implements StudentsPlanService<ComputerStudentsPlan>{
    @Autowired
    private ComputerStudentsPlanRepository computerStudentsPlanRepository;

    public void updateComputerStudentsPlan(ComputerStudentsPlan computerStudentsPlan ) {
        computerStudentsPlanRepository.save(computerStudentsPlan);
    }

    @Override
    public List<ComputerStudentsPlan> getPlanByStudentId(Long student_id) {
        return computerStudentsPlanRepository.findByStudentId(student_id);
    }

    @Override
    public List<ComputerStudentsPlan> getPlanByCourseId(Long course_id) {
        return computerStudentsPlanRepository.findByCourseId(course_id);
    }

    public Optional<ComputerStudentsPlan> getPlanByStudentIdAndCourseId(Long studentId, Long courseId){
        return computerStudentsPlanRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
}
