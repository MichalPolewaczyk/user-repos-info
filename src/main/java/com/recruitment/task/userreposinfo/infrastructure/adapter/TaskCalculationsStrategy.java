package com.recruitment.task.userreposinfo.infrastructure.adapter;

import com.recruitment.task.userreposinfo.domain.boundary.CalculationsRequiredData;
import com.recruitment.task.userreposinfo.domain.port.CalculationsStrategy;
import com.recruitment.task.userreposinfo.infrastructure.exception.NotAllowedCalculationsDataException;
import org.springframework.stereotype.Component;

@Component
public class TaskCalculationsStrategy implements CalculationsStrategy {
    private static final double NOMINATOR = 6;
    private static final double NUMBER_TO_BE_ADDED_TO_NUMBER_OF_PUBLIC_REPOS = 2;

    @Override
    public double calculate(CalculationsRequiredData requiredData) {
        throwIfProvidedSourceDataAreInvalid(requiredData);

        return NOMINATOR /
                requiredData.numberOfFollowers() *
                (NUMBER_TO_BE_ADDED_TO_NUMBER_OF_PUBLIC_REPOS + requiredData.numberOfPublicRepos());
    }

    private void throwIfProvidedSourceDataAreInvalid(CalculationsRequiredData requiredData) {
        if(requiredData.numberOfPublicRepos() == 0 | requiredData.numberOfFollowers() == 0) {
            throw new NotAllowedCalculationsDataException();
        }
    }
}
