package org.loose.vvs.seleniumtest.data;

import java.util.List;

public class MeanGradeRequest {
    private List<Double> grades;

    public MeanGradeRequest() {
    }

    public MeanGradeRequest(List<Double> grades) {
        this.grades = grades;
    }

    public List<Double> getGrades() {
        return grades;
    }
}
