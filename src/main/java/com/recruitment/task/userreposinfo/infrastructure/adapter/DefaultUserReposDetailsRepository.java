package com.recruitment.task.userreposinfo.infrastructure.adapter;

import com.recruitment.task.userreposinfo.domain.port.UserReposRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserReposDetailsRepository implements UserReposRepository {

    @Override
    public void incrementRequestCountForUserWithGivenLogin(String login) {

    }
}
