package org.loose.vvs.seleniumtest.services;

import org.loose.vvs.seleniumtest.exceptions.InvalidGradeCountException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesService {

    private final GradeCalculator gradeCalculator;
    private GradesProvider gradesProvider;

    public void setGradesProvider(GradesProvider gradesProvider) {
        this.gradesProvider = gradesProvider;
    }

    public GradesService(GradeCalculator gradeCalculator) {
        this.gradeCalculator = gradeCalculator;
    }

    public double calculateMean(List<Double> grades) {
        if (grades == null) {
            throw new InvalidGradeCountException();
        }

        if (grades.size() < 3) {
            throw new InvalidGradeCountException();
        }

        return gradeCalculator.calculateMeanFromThreeMaxGrades(grades);
    }

    //using the provider
    public double calculateMean() {
        if (gradesProvider == null) {
            throw new InvalidGradeCountException();
        }

        if (gradesProvider.getGrades() == null) {
            throw new InvalidGradeCountException();
        }

        if (gradesProvider.getGrades().size() < 3) {
            throw new InvalidGradeCountException();
        }

        return gradeCalculator.calculateMeanFromThreeMaxGrades(gradesProvider.getGrades());
    }
}
