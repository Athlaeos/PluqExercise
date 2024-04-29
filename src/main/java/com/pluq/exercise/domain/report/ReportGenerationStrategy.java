package com.pluq.exercise.domain.report;

import com.pluq.exercise.domain.pojo.ChargeLocation;

public interface ReportGenerationStrategy {
    ChargeReport generate(ChargeLocation location);
}
