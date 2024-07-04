package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerReport;
import com.example.universityoftabriz.Repository.ComputerReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComputerReportService implements ReportService<ComputerReport>{
    @Autowired
    private ComputerReportRepository computerReportRepository;

    public void updateComputerReport(ComputerReport computerReport ) {
        computerReportRepository.save(computerReport);
    }

    @Override
    public List<ComputerReport> getReportsByTeacherId(Long teacher_id) {
        return computerReportRepository.findByTeacherId(teacher_id);
    }

    @Override
    public List<ComputerReport> getReportsByCourseId(Long course_id) {
        return computerReportRepository.findByCourseId(course_id);
    }

    @Override
    public List<ComputerReport> getReportsByTeacherIdAndCourseId(Long teacher_id, Long course_id) {
        return computerReportRepository.findByTeacherIdAndCourseId(teacher_id, course_id);
    }

    @Override
    public Optional<ComputerReport> getReportSpecific(Date date, Long teacher_id, Long course_id) {
        return computerReportRepository.findByDateOfSubmitionAndTeacherIdAndCourseId(date, teacher_id, course_id);
    }

    public ComputerReport findLastRecord() {
        return computerReportRepository.findLastRecord();
    }
}
