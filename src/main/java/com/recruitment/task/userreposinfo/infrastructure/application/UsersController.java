package com.recruitment.task.userreposinfo.infrastructure.application;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposDetailsOutputDto;
import com.recruitment.task.userreposinfo.domain.port.UserReposService;
import com.recruitment.task.userreposinfo.infrastructure.exception.NotAllowedCalculationsDataException;
import com.recruitment.task.userreposinfo.infrastructure.exception.UserReposDetailsProviderException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsersController {
    private static final String USERS_LOGIN_URL = "/users/{login}";
    private static final String PROVIDER_EXCEPTION_MESSAGE = "Error occurred while trying to fetch users data";
    private static final String CALCULATIONS_EXCEPTION_MESSAGE = "Calculations couldn't be performed on received users data";

    private final UserReposService userReposService;

    @GetMapping(USERS_LOGIN_URL)
    public UserReposDetailsOutputDto get(
            @PathVariable  String login
    ) {
        return userReposService.getRepoDetailsOfUserWithGivenLogin(login);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserReposDetailsProviderException.class)
    public String handleUserReposDetailsProviderException() {
        return PROVIDER_EXCEPTION_MESSAGE;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotAllowedCalculationsDataException.class)
    public String handleNotAllowedCalculationsDataException() {
        return CALCULATIONS_EXCEPTION_MESSAGE;
    }
}
