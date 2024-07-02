package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricPreCoursesPlan;
import com.example.universityoftabriz.Repository.ElectricPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricPreCoursesPlanService implements PreCoursesPlan<ElectricPreCoursesPlan>{
    @Autowired
    private ElectricPreCoursesPlanRepository electricPreCoursesPlanRepository;

    public void updateElectricPreCoursesPlan(ElectricPreCoursesPlan electricPreCoursesPlan, Logger logger) {
        electricPreCoursesPlanRepository.save(electricPreCoursesPlan);
        logger.info("Electric Pre-Courses Plan with id: {} updated successfully.",electricPreCoursesPlan.getId());
    }

    @Override
    public List<ElectricPreCoursesPlan> getPrePlanByCourseId(Long course_id){
        return electricPreCoursesPlanRepository.findByCourseId(course_id);
    }
    @Override
    public List<ElectricPreCoursesPlan> getPrePlanByTeacherId(Long teacherId){
        return electricPreCoursesPlanRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<ElectricPreCoursesPlan> getPrePlanByCourseIdAndTeacherId(Long courseId, Long teacherId){
        return electricPreCoursesPlanRepository.findByCourseIdAndTeacherId(courseId,teacherId);
    }
}
