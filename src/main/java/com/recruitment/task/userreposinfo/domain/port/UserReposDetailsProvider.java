package com.recruitment.task.userreposinfo.domain.port;

import com.recruitment.task.userreposinfo.domain.dto.UserReposRawDetailsDto;

public interface UserReposDetailsProvider {
    UserReposRawDetailsDto getDetailsOfUserWithGivenLogin(String login);
}
