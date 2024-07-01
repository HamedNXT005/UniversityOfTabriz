package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ElectricReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricReportService {
    @Autowired
    private ElectricReportRepository electricReportRepository;

}
