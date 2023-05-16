package com.neoflex.vacationpaycalculator.mapper;

public class VocationPayMapper {
    private VocationPayMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Double mapMeaningDouble(Double meaning) {
        long roundedInt = Math.round(meaning * 100);
        meaning = (double) roundedInt / 100;
        return meaning;
    }
}
