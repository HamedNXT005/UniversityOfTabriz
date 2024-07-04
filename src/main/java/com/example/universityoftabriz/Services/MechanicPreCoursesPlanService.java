package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicPreCoursesPlan;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.MechanicPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
