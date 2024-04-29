package com.pluq.exercise.api;

import com.pluq.exercise.service.IReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/report")
public class ChargeReportController {
    private final IReportService reportService;

    public ChargeReportController(IReportService reportService){
        this.reportService = reportService;
    }


}
