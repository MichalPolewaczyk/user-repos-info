package com.recruitment.task.userreposinfo.domain.service;

import com.recruitment.task.userreposinfo.domain.boundary.CalculationsRequiredData;
import com.recruitment.task.userreposinfo.domain.boundary.UserReposDetailsOutputDto;
import com.recruitment.task.userreposinfo.domain.entity.UserReposDetails;
import com.recruitment.task.userreposinfo.domain.port.UserReposDetailsProvider;
import com.recruitment.task.userreposinfo.domain.port.UserReposRepository;
import com.recruitment.task.userreposinfo.domain.port.UserReposFacade;
import lombok.AllArgsConstructor;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class UserReposFacadeImpl implements UserReposFacade {
    private final UserReposDetailsProvider userReposDetailsProvider;
    private final UserReposDetailsFactory userReposDetailsFactory;
    private final CalculationsStrategy calculationsStrategy;
    private final UserReposRepository userReposRepository;
    private final DateTimeFormatter dateTimeFormatter;
    private final DecimalFormat decimalFormatter;

    @Override
    public UserReposDetailsOutputDto getRepoDetailsOfUserWithGivenLogin(String login) {
        UserReposDetails userReposDetails = userReposDetailsFactory.createFromRawDto(
                userReposDetailsProvider.getDetailsOfUserWithGivenLogin(login)
        );

        userReposRepository.incrementRequestCountForUserWithGivenLogin(login);
        double resultOfCalculations = performCalculations(userReposDetails);

        return userReposDetailsAsOutputDto(userReposDetails, resultOfCalculations);
    }

    private double performCalculations(UserReposDetails userReposDetails) {
        return calculationsStrategy.calculate(
                prepareDataRequiredForCalculationsFromUserReposDetails(userReposDetails)
        );
    }

    private CalculationsRequiredData prepareDataRequiredForCalculationsFromUserReposDetails(UserReposDetails userReposDetails) {
        return new CalculationsRequiredData(
                userReposDetails.getFollowers().numberOfFollowers(),
                userReposDetails.getPublicRepos().numberOfPublicRepos()
        );
    }

    private UserReposDetailsOutputDto userReposDetailsAsOutputDto(
            UserReposDetails userReposDetails,
            double resultOfCalculations
    ) {
        return new UserReposDetailsOutputDto(
                String.valueOf(userReposDetails.getId().id()),
                userReposDetails.getLogin().login(),
                userReposDetails.getName().name(),
                userReposDetails.getType().type(),
                userReposDetails.getAvatarUrl().avatarUrl(),
                dateTimeFormatter.format(userReposDetails.getCreatedAt().createdAt()),
                decimalFormatter.format(resultOfCalculations)
        );
    }
}
