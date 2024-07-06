package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricPreCoursesPlan;
import com.example.universityoftabriz.Repository.ElectricPreCoursesPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectricPreCoursesPlanService implements PreCoursesPlan<ElectricPreCoursesPlan>{
    @Autowired
    private ElectricPreCoursesPlanRepository electricPreCoursesPlanRepository;

    public void updateElectricPreCoursesPlan(ElectricPreCoursesPlan electricPreCoursesPlan ) {
        electricPreCoursesPlanRepository.save(electricPreCoursesPlan);
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
    public List<ElectricPreCoursesPlan> getPrePlanByTeacherIdAndStatus(Long teacherId, boolean status){
        return electricPreCoursesPlanRepository.findByTeacherIdAndStatus(teacherId, status);
    }

    public List<ElectricPreCoursesPlan> getAll(){
        return electricPreCoursesPlanRepository.findAll();
    }

    public Optional<ElectricPreCoursesPlan> getCourse(long id){
        return electricPreCoursesPlanRepository.findById(id);
    }
}
