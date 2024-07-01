package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ElectricReport;
import com.example.universityoftabriz.Objects.MechanicReport;
import com.example.universityoftabriz.Repository.ElectricReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricReportService {
    @Autowired
    private ElectricReportRepository electricReportRepository;

    public void updateElectricReport(ElectricReport electricReport, Logger logger) {
        electricReportRepository.save(electricReport);
        logger.info("Electric Report with id: {} updated successfully.",electricReport.getId());
    }
}
