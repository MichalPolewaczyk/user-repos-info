package com.recruitment.task.userreposinfo.domain.service;

import com.recruitment.task.userreposinfo.domain.entity.UserReposDetails;

import java.time.LocalDateTime;

public interface UserReposDetailsFactory {
    UserReposDetails create(
            long id,
            String login,
            String name,
            String type,
            String avatarUrl,
            LocalDateTime createdAt,
            int numberOfFollowers,
            int numberOfPublicRepos
    );
}
