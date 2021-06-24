package com.myApp.backendLigue.controller;


import com.myApp.backendLigue.dto.PlayerWithReport;
import com.myApp.backendLigue.entity.Report;
import com.myApp.backendLigue.repository.PlayerPlaningRepository;
import com.myApp.backendLigue.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private PlayerPlaningRepository playerPlaningRepository;

    @PostMapping("/save")
    public void addReport(@RequestBody Report report){
        this.reportService.addReport(report.getRefereeId(), report.getPlayerId(),
                report.getGameId(), report.getReportTxt());
    }

    @PostMapping("/delete")
    public void removeReport(@RequestBody PlayerWithReport playerWithReport){
        Long gameId = playerWithReport.getGameId();
        Long playerId = playerWithReport.getPlayerId();
        this.reportService.removeReport(gameId, playerId);
    }

    @PostMapping("/update")
    public void updateReport(@RequestBody Report report){
        Long reportId = report.getId();
        String reportText = report.getReportTxt();
        this.reportService.updateReport(reportId, reportText);
    }

    @GetMapping("/find-by-game/{gameId}")
    public List<PlayerWithReport> getPlayerWithReportForGame(@PathVariable("gameId") Long gameId){
        return this.playerPlaningRepository.getPlayerWithReportForGame(gameId);
    }


}
