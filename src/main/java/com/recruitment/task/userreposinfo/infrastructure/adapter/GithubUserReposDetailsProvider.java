package com.recruitment.task.userreposinfo.infrastructure.adapter;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposRawDetailsDto;
import com.recruitment.task.userreposinfo.domain.port.UserReposDetailsProvider;
import org.springframework.stereotype.Component;

@Component
public class GithubUserReposDetailsProvider implements UserReposDetailsProvider {
    @Override
    public UserReposRawDetailsDto getDetailsOfUserWithGivenLogin(String login) {
        return null;
    }
}
