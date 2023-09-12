package com.recruitment.task.userreposinfo.domain.port;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposDetailsOutputDto;

public interface UserReposFacade {
    UserReposDetailsOutputDto getRepoDetailsOfUserWithGivenLogin(String login);
}
