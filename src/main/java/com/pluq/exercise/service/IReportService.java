package com.pluq.exercise.service;

import com.pluq.exercise.domain.pojo.ChargeLocation;
import com.pluq.exercise.domain.report.ChargeReport;
import org.springframework.stereotype.Service;

@Service
public interface IReportService {
    ChargeReport generateReport(ChargeLocation location);
}
