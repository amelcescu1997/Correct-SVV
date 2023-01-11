package org.loose.vvs.seleniumtest.controllers;

import org.loose.vvs.seleniumtest.data.MeanGrade;
import org.loose.vvs.seleniumtest.data.MeanGradeRequest;
import org.loose.vvs.seleniumtest.services.GradesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeController {

    private final GradesService gradesService;

    public GradeController(GradesService gradesService) {
        this.gradesService = gradesService;
    }

    @PostMapping("/calculate")
    public MeanGrade calculateMean(@RequestBody MeanGradeRequest request) {
        double mean = gradesService.calculateMean(request.getGrades());
        return new MeanGrade(mean);
    }
}
