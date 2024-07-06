package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryPreCoursesPlan;
import com.example.universityoftabriz.Repository.ChemistryPreCoursesPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemistryPreCoursesPlanService implements PreCoursesPlan<ChemistryPreCoursesPlan>{
    @Autowired
    private ChemistryPreCoursesPlanRepository chemistryPreCoursesPlanRepository;

    public void updateChemistryPreCoursesPlan(ChemistryPreCoursesPlan chemistryPreCoursesPlan ) {
        chemistryPreCoursesPlanRepository.save(chemistryPreCoursesPlan);
    }
    @Override
    public List<ChemistryPreCoursesPlan> getPrePlanByCourseId(Long course_id){
        return chemistryPreCoursesPlanRepository.findByCourseId(course_id);
    }
    @Override
    public List<ChemistryPreCoursesPlan> getPrePlanByTeacherId(Long teacherId){
        return chemistryPreCoursesPlanRepository.findByTeacherId(teacherId);
    }
    @Override
    public List<ChemistryPreCoursesPlan> getPrePlanByCourseIdAndTeacherId(Long courseId, Long teacherId){
        return chemistryPreCoursesPlanRepository.findByCourseIdAndTeacherId(courseId,teacherId);
    }
    public List<ChemistryPreCoursesPlan> getPrePlanByTeacherIdAndStatus(Long teacherId,boolean status){
        return chemistryPreCoursesPlanRepository.findByTeacherIdAndStatus(teacherId, status);
    }

    public List<ChemistryPreCoursesPlan> getAll(){
        return chemistryPreCoursesPlanRepository.findAll();
    }

    public ChemistryPreCoursesPlan getCourse(long id){
        return chemistryPreCoursesPlanRepository.findById(id);
    }
}
