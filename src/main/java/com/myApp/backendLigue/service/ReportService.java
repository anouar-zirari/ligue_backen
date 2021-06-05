package com.myApp.backendLigue.service;

import com.myApp.backendLigue.entity.Report;
import com.myApp.backendLigue.repository.ReportRepository;
import com.myApp.backendLigue.repository.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public void addReport(Long refereeId, Long playerId, Long gameId, String reportTxt) {
        List<Report> reports = this.reportRepository.findByRefereeIdAndPlayerIdAndGameId(refereeId, playerId, gameId);
        Report report;
        if (!reports.isEmpty()) {
            report = reports.get(0);
        }else {
            report = new Report(refereeId, playerId, gameId);
        }
        report.setReportTxt(reportTxt);
        reportRepository.save(report);
    }
}
