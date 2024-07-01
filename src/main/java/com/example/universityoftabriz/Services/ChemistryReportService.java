package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.ChemistryReport;
import com.example.universityoftabriz.Objects.CivilReport;
import com.example.universityoftabriz.Repository.ChemistryReportRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemistryReportService {
    @Autowired
    private ChemistryReportRepository chemistryReportRepository;

    public void updateChemistryReport(ChemistryReport chemistryReport, Logger logger) {
        chemistryReportRepository.save(chemistryReport);
        logger.info("Chemistry Report with id: {} updated successfully.",chemistryReport.getId());
    }
}
