package com.recruitment.task.userreposinfo.infrastructure.adapter.application;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposDetailsOutputDto;
import com.recruitment.task.userreposinfo.domain.port.UserReposFacade;
import com.recruitment.task.userreposinfo.infrastructure.adapter.application.response.UsersReposInfoErrorResponse;
import com.recruitment.task.userreposinfo.domain.exception.NotAllowedCalculationsDataException;
import com.recruitment.task.userreposinfo.domain.exception.UserReposDetailsProviderException;
import lombok.AllArgsConstructor;
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
    private static final String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected error has occurred";

    private final UserReposFacade userReposFacade;

    @GetMapping(USERS_LOGIN_URL)
    public UserReposDetailsOutputDto get(
            @PathVariable  String login
    ) {
        return userReposFacade.getRepoDetailsOfUserWithGivenLogin(login);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserReposDetailsProviderException.class)
    public UsersReposInfoErrorResponse handleUserReposDetailsProviderException() {
        return new UsersReposInfoErrorResponse(PROVIDER_EXCEPTION_MESSAGE);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotAllowedCalculationsDataException.class)
    public UsersReposInfoErrorResponse handleNotAllowedCalculationsDataException() {
        return new UsersReposInfoErrorResponse(CALCULATIONS_EXCEPTION_MESSAGE);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public UsersReposInfoErrorResponse handleUnexpectedExceptions() {
        return new UsersReposInfoErrorResponse(UNEXPECTED_EXCEPTION_MESSAGE);
    }
}
