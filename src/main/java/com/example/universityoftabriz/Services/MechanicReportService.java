package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicReport;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.MechanicReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MechanicReportService implements ReportService<MechanicReport> {
    @Autowired
    private MechanicReportRepository mechanicReportRepository;

    public void updateMechanicReport(MechanicReport mechanicReport) {
        mechanicReportRepository.save(mechanicReport);
    }
    @Override
    public List<MechanicReport> getReportsByTeacherId(Long teacher_id){
        return mechanicReportRepository.findByTeacherId(teacher_id);
    }
    @Override
    public List<MechanicReport> getReportsByCourseId(Long course_id){
        return mechanicReportRepository.findByCourseId(course_id);
    }
    @Override
    public List<MechanicReport> getReportsByTeacherIdAndCourseId(Long teacher_id, Long course_id){
        return mechanicReportRepository.findByTeacherIdAndCourseId(teacher_id,course_id);
    }
    @Override
    public Optional<MechanicReport> getReportSpecific(Date date,Long teacher_id,Long course_id){
        return mechanicReportRepository.findByDateOfSubmitionAndTeacherIdAndCourseId(date,teacher_id,course_id);
    }
}
