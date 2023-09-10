package com.recruitment.task.userreposinfo.domain.port;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposDetailsOutputDto;

public interface UserReposService {
    UserReposDetailsOutputDto getRepoDetailsOfUserWithGivenLogin(String login);
}
