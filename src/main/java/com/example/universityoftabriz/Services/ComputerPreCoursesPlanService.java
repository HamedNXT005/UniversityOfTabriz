package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerPreCoursesPlan;
import com.example.universityoftabriz.Repository.ComputerPreCoursesPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerPreCoursesPlanService implements PreCoursesPlan<ComputerPreCoursesPlan>{
    @Autowired
    private ComputerPreCoursesPlanRepository computerPreCoursesPlanRepository;

    public void updateComputerPreCoursesPlan(ComputerPreCoursesPlan computerPreCoursesPlan ) {
        computerPreCoursesPlanRepository.save(computerPreCoursesPlan);
    }

    @Override
    public List<ComputerPreCoursesPlan> getPrePlanByCourseId(Long course_id){
        return computerPreCoursesPlanRepository.findByCourseId(course_id);
    }
    @Override
    public List<ComputerPreCoursesPlan> getPrePlanByTeacherId(Long teacherId){
        return computerPreCoursesPlanRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<ComputerPreCoursesPlan> getPrePlanByCourseIdAndTeacherId(Long courseId, Long teacherId){
        return computerPreCoursesPlanRepository.findByCourseIdAndTeacherId(courseId,teacherId);
    }

    public List<ComputerPreCoursesPlan> getPrePlanByTeacherIdAndStatus(Long teacherId, boolean status){
        return computerPreCoursesPlanRepository.findByTeacherIdAndStatus(teacherId, status);
    }

    public List<ComputerPreCoursesPlan> getAll(){
        return computerPreCoursesPlanRepository.findAll();
    }

    public Optional<ComputerPreCoursesPlan> getPreCourse(long id){
        return computerPreCoursesPlanRepository.findById(id);
    }
}
