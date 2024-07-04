package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Objects.Student;
import com.example.universityoftabriz.Repository.MechanicStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicStudentsPlanService implements StudentsPlanService<MechanicStudentsPlan> {
    @Autowired
    private MechanicStudentsPlanRepository mechanicStudentsPlanRepository;

    public void updateMechanicStudentsPlan(MechanicStudentsPlan mechanicStudentsPlan) {
        mechanicStudentsPlanRepository.save(mechanicStudentsPlan);
    }
    @Override
    public List<MechanicStudentsPlan> getPlanByStudentId(Long student_id){
        return mechanicStudentsPlanRepository.findByStudentId(student_id);
    }
    @Override
    public List<MechanicStudentsPlan> getPlanByCourseId(Long course_id){
        return mechanicStudentsPlanRepository.findByCourseId(course_id);
    }

    @Override
    public MechanicStudentsPlan findLastRecord() {
        return mechanicStudentsPlanRepository.findLastRecord();
    }

    public Optional<MechanicStudentsPlan> getPlanByStudentIdAndCourseId(Long studentId, Long courseId){
        return mechanicStudentsPlanRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
}
