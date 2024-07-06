package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicPreCoursesPlan;
import com.example.universityoftabriz.Repository.MechanicPreCoursesPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicPreCoursesPlanService implements PreCoursesPlan<MechanicPreCoursesPlan>{
    @Autowired
    private MechanicPreCoursesPlanRepository mechanicPreCoursesPlanRepository;

    public void updateMechanicPreCoursesPlan(MechanicPreCoursesPlan mechanicPreCoursesPlan) {
        mechanicPreCoursesPlanRepository.save(mechanicPreCoursesPlan);
    }
    @Override
    public List<MechanicPreCoursesPlan> getPrePlanByCourseId(Long course_id){
        return mechanicPreCoursesPlanRepository.findByCourseId(course_id);
    }
    @Override
    public List<MechanicPreCoursesPlan> getPrePlanByTeacherId(Long teacherId){
        return mechanicPreCoursesPlanRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<MechanicPreCoursesPlan> getPrePlanByCourseIdAndTeacherId(Long courseId, Long teacherId){
        return mechanicPreCoursesPlanRepository.findByCourseIdAndTeacherId(courseId,teacherId);
    }
    public List<MechanicPreCoursesPlan> getPrePlanByTeacherIdAndStatus(Long teacherId, boolean status){
        return mechanicPreCoursesPlanRepository.findByTeacherIdAndStatus(teacherId, status);
    }

    public List<MechanicPreCoursesPlan> getAll(){
        return mechanicPreCoursesPlanRepository.findAll();
    }

    public Optional<MechanicPreCoursesPlan> getCourse(long id){
        return mechanicPreCoursesPlanRepository.findById(id);
    }
}
