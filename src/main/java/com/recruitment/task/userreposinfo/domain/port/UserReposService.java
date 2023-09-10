package com.recruitment.task.userreposinfo.domain.port;

import com.recruitment.task.userreposinfo.domain.dto.UserReposDetailsOutputDto;

public interface UserReposService {
    UserReposDetailsOutputDto getRepoDetailsOfUserWithGivenLogin(String login);
}
