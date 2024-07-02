package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilPreCoursesPlan;
import com.example.universityoftabriz.Repository.CivilPreCoursesPlanRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilPreCoursesPlanService implements PreCoursesPlan<CivilPreCoursesPlan> {
    @Autowired
    private CivilPreCoursesPlanRepository civilPreCoursesPlanRepository;

    public void updateCivilPreCoursesPlan(CivilPreCoursesPlan civilPreCoursesPlan, Logger logger) {
        civilPreCoursesPlanRepository.save(civilPreCoursesPlan);
        logger.info("Civil Pre-Courses Plan with id: {} updated successfully.",civilPreCoursesPlan.getId());
    }

    @Override
    public List<CivilPreCoursesPlan> getPrePlanByCourseId(Long course_id){
        return civilPreCoursesPlanRepository.findByCourseId(course_id);
    }
    @Override
    public List<CivilPreCoursesPlan> getPrePlanByTeacherId(Long teacherId){
        return civilPreCoursesPlanRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<CivilPreCoursesPlan> getPrePlanByCourseIdAndTeacherId(Long courseId, Long teacherId){
        return civilPreCoursesPlanRepository.findByCourseIdAndTeacherId(courseId,teacherId);
    }
}
