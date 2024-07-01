package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ComputerReport;
import com.example.universityoftabriz.Objects.ElectricReport;
import com.example.universityoftabriz.Repository.ComputerReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerReportService {
    @Autowired
    private ComputerReportRepository computerReportRepository;

    public void updateComputerReport(ComputerReport computerReport, Logger logger) {
        computerReportRepository.save(computerReport);
        logger.info("Computer Report with id: {} updated successfully.",computerReport.getId());
    }
}
