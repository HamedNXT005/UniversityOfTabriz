package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilReport;
import com.example.universityoftabriz.Repository.CivilReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CivilReportService implements ReportService<CivilReport>{
    @Autowired
    private CivilReportRepository civilReportRepository;

    public void updateCivilReport(CivilReport civilReport, Logger logger) {
        civilReportRepository.save(civilReport);
        logger.info("Civil Report with id: {} updated successfully.",civilReport.getId());
    }

    @Override
    public List<CivilReport> getReportsByTeacherId(Long teacher_id) {
        return civilReportRepository.findByTeacherId(teacher_id);
    }

    @Override
    public List<CivilReport> getReportsByCourseId(Long course_id) {
        return civilReportRepository.findByCourseId(course_id);
    }

    @Override
    public List<CivilReport> getReportsByTeacherIdAndCourseId(Long teacher_id, Long course_id) {
        return civilReportRepository.findByTeacherIdAndCourseId(teacher_id, course_id);
    }

    @Override
    public Optional<CivilReport> getReportSpecific(Date date, Long teacher_id, Long course_id) {
        return civilReportRepository.findByDateOfSubmitionAndTeacherIdAndCourseId(date, teacher_id, course_id);
    }
}
