package com.myApp.backendLigue.controller;


import com.myApp.backendLigue.entity.Report;
import com.myApp.backendLigue.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/save")
    public void addReport(@RequestBody Report report){
        this.reportService.addReport(report.getRefereeId(), report.getPlayerId(),
                report.getGameId(), report.getReportTxt());
    }


}
