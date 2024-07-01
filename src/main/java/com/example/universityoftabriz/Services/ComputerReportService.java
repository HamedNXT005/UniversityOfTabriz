package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Repository.ComputerReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerReportService {
    @Autowired
    private ComputerReportRepository computerReportRepository;
}
