package com.recruitment.task.userreposinfo.infrastructure.adapter;

import com.recruitment.task.userreposinfo.domain.boundary.CalculationsRequiredData;
import com.recruitment.task.userreposinfo.domain.entity.CalculationsStrategy;
import org.springframework.stereotype.Component;

@Component
public class TaskCalculationsStrategy implements CalculationsStrategy {
    private static final int NOMINATOR = 6;
    private static final int NUMBER_TO_BE_ADDED_TO_NUMBER_OF_PUBLIC_REPOS = 6;

    @Override
    public int calculate(CalculationsRequiredData requiredData) {
        return NOMINATOR /
                requiredData.numberOfFollowers() *
                (NUMBER_TO_BE_ADDED_TO_NUMBER_OF_PUBLIC_REPOS + requiredData.numberOfPublicRepos());
    }
}
