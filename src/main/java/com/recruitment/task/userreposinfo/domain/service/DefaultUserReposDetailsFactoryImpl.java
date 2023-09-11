package com.recruitment.task.userreposinfo.domain.service;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposRawDetailsDto;
import com.recruitment.task.userreposinfo.domain.entity.UserAvatarUrl;
import com.recruitment.task.userreposinfo.domain.entity.UserCreatedAt;
import com.recruitment.task.userreposinfo.domain.entity.UserFollowers;
import com.recruitment.task.userreposinfo.domain.entity.UserId;
import com.recruitment.task.userreposinfo.domain.entity.UserLogin;
import com.recruitment.task.userreposinfo.domain.entity.UserName;
import com.recruitment.task.userreposinfo.domain.entity.UserPublicRepos;
import com.recruitment.task.userreposinfo.domain.entity.UserReposDetails;
import com.recruitment.task.userreposinfo.domain.entity.UserType;

public class DefaultUserReposDetailsFactoryImpl implements UserReposDetailsFactory {

    @Override
    public UserReposDetails createFromRawDto(UserReposRawDetailsDto githubDto) {
        return new UserReposDetails(
                new UserId(Long.parseLong(githubDto.id())),
                new UserLogin(githubDto.login()),
                new UserName(githubDto.name()),
                new UserType(githubDto.type()),
                new UserAvatarUrl(githubDto.avatarUrl()),
                new UserCreatedAt(githubDto.createdAt()),
                new UserFollowers(githubDto.numberOfFollowers()),
                new UserPublicRepos(githubDto.numberOfPublicRepos())
        );
    }
}
