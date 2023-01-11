package org.loose.vvs.seleniumtest.services;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeCalculator {
    public double calculateMeanFromThreeMaxGrades(List<Double> grades) {
        double max1 = getMax(grades);

        grades.remove(max1);
        double max2 = getMax(grades);

        grades.remove(max2);
        double max3 = getMax(grades);

        return (max1 + max2 + max3) / 3;
    }

    private double getMax(List<Double> grades) {
        double max = 0;
        for (Double grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }

        return max;
    }
}
