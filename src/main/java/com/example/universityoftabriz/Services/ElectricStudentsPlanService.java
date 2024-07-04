package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerStudentsPlan;
import com.example.universityoftabriz.Objects.ElectricStudentsPlan;
import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.ElectricStudentsPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectricStudentsPlanService implements StudentsPlanService<ElectricStudentsPlan>{
    @Autowired
    private ElectricStudentsPlanRepository electricStudentsPlanRepository;

    public void updateElectricStudentsPlan(ElectricStudentsPlan electricStudentsPlan ) {
        electricStudentsPlanRepository.save(electricStudentsPlan);
    }

    @Override
    public List<ElectricStudentsPlan> getPlanByStudentId(Long student_id) {
        return electricStudentsPlanRepository.findByStudentId(student_id);
    }

    @Override
    public List<ElectricStudentsPlan> getPlanByCourseId(Long course_id) {
        return electricStudentsPlanRepository.findByCourseId(course_id);
    }

    public Optional<ElectricStudentsPlan> getPlanByStudentIdAndCourseId(Long studentId, Long courseId){
        return electricStudentsPlanRepository.findByStudentIdAndCourseId(studentId,courseId);
    }
}
