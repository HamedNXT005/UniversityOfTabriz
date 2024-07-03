package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.HistorySalary;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.HistorySalaryRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistorySalaryService {
    @Autowired
    private HistorySalaryRepository historySalaryRepository;

    public void updateHistorySalary(HistorySalary historySalary, Logger logger) {
        historySalaryRepository.save(historySalary);
        logger.info("History of Salary with id: {} updated successfully.",historySalary.getId());
    }

    public List<HistorySalary> getHistorySByUserId(Long userId){
        return historySalaryRepository.findByUserId(userId);
    }

    public List<HistorySalary> getHistorySByYearEdAndSemester(Date yearEd, int semester){
        return historySalaryRepository.findByYearEdAndSemester(yearEd,semester);
    }
}
