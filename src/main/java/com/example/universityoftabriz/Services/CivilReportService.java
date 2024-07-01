package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.CivilReport;
import com.example.universityoftabriz.Objects.ComputerReport;
import com.example.universityoftabriz.Repository.CivilReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CivilReportService {
    @Autowired
    private CivilReportRepository civilReportRepository;

    public void updateCivilReport(CivilReport civilReport, Logger logger) {
        civilReportRepository.save(civilReport);
        logger.info("Civil Report with id: {} updated successfully.",civilReport.getId());
    }
}
