package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryReport;
import com.example.universityoftabriz.Repository.ChemistryReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ChemistryReportService implements ReportService<ChemistryReport>{
    @Autowired
    private ChemistryReportRepository chemistryReportRepository;

    public void updateChemistryReport(ChemistryReport chemistryReport, Logger logger) {
        chemistryReportRepository.save(chemistryReport);
        logger.info("Chemistry Report with id: {} updated successfully.",chemistryReport.getId());
    }

    @Override
    public List<ChemistryReport> getReportsByTeacherId(Long teacher_id) {
        return chemistryReportRepository.findByTeacherId(teacher_id);
    }

    @Override
    public List<ChemistryReport> getReportsByCourseId(Long course_id) {
        return chemistryReportRepository.findByCourseId(course_id);
    }

    @Override
    public List<ChemistryReport> getReportsByTeacherIdAndCourseId(Long teacher_id, Long course_id) {
        return chemistryReportRepository.findByTeacherIdAndCourseId(teacher_id, course_id);
    }

    @Override
    public Optional<ChemistryReport> getReportSpecific(Date date, Long teacher_id, Long course_id) {
        return chemistryReportRepository.findByDateOfSubmitionAndTeacherIdAndCourseId(date, teacher_id, course_id);
    }
}
