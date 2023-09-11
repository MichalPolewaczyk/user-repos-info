package com.recruitment.task.userreposinfo.domain.port;

import com.recruitment.task.userreposinfo.domain.boundary.CalculationsRequiredData;

public interface CalculationsStrategy {
    double calculate(CalculationsRequiredData calculationsRequiredData);
}
