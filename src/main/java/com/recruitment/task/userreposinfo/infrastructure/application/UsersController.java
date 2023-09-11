package com.recruitment.task.userreposinfo.infrastructure.application;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposDetailsOutputDto;
import com.recruitment.task.userreposinfo.domain.port.UserReposService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsersController {
    private final UserReposService userReposService;

    @GetMapping("/users/{login}")
    public UserReposDetailsOutputDto get(
            @PathVariable  String login
    ) {
        return userReposService.getRepoDetailsOfUserWithGivenLogin(login);
    }
}
