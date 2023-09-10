package com.recruitment.task.userreposinfo.domain.entity;

import com.recruitment.task.userreposinfo.domain.boundary.CalculationsRequiredData;

public interface CalculationsStrategy {
    int calculate(CalculationsRequiredData calculationsRequiredData);
}
