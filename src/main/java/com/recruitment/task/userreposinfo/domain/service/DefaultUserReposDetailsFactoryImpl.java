package com.recruitment.task.userreposinfo.domain.service;

import com.recruitment.task.userreposinfo.domain.entity.UserAvatarUrl;
import com.recruitment.task.userreposinfo.domain.entity.UserCreatedAt;
import com.recruitment.task.userreposinfo.domain.entity.UserFollowers;
import com.recruitment.task.userreposinfo.domain.entity.UserId;
import com.recruitment.task.userreposinfo.domain.entity.UserLogin;
import com.recruitment.task.userreposinfo.domain.entity.UserName;
import com.recruitment.task.userreposinfo.domain.entity.UserPublicRepos;
import com.recruitment.task.userreposinfo.domain.entity.UserReposDetails;
import com.recruitment.task.userreposinfo.domain.entity.UserType;

import java.time.LocalDateTime;

public class DefaultUserReposDetailsFactoryImpl implements UserReposDetailsFactory {

    @Override
    public UserReposDetails create(
            long id,
            String login,
            String name,
            String type,
            String avatarUrl,
            LocalDateTime createdAt,
            int numberOfFollowers,
            int numberOfPublicRepos
    ) {
        return new UserReposDetails(
                new UserId(id),
                new UserLogin(login),
                new UserName(name),
                new UserType(type),
                new UserAvatarUrl(avatarUrl),
                new UserCreatedAt(createdAt),
                new UserFollowers(numberOfFollowers),
                new UserPublicRepos(numberOfPublicRepos)
        );
    }
}
