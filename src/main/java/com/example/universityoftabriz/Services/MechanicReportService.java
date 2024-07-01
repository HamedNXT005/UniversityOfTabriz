package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicReport;
import com.example.universityoftabriz.Objects.MechanicStudentsPlan;
import com.example.universityoftabriz.Repository.MechanicReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicReportService {
    @Autowired
    private MechanicReportRepository mechanicReportRepository;

    public void updateMechanicReport(MechanicReport mechanicReport, Logger logger) {
        mechanicReportRepository.save(mechanicReport);
        logger.info("Mechanic Report with id: {} updated successfully.",mechanicReport.getId());
    }
}
