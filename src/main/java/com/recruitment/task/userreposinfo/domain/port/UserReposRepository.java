package com.recruitment.task.userreposinfo.domain.port;

public interface UserReposRepository {
    void incrementRequestCountForUserWithGivenLogin(String login);
}
