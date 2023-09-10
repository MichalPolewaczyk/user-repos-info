package com.recruitment.task.userreposinfo.domain.service;

import com.recruitment.task.userreposinfo.domain.dto.UserReposRawDetailsDto;
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
import java.time.format.DateTimeFormatter;

public class DefaultUserReposDetailsFactoryImpl implements UserReposDetailsFactory {
    private final DateTimeFormatter formatter;

    public DefaultUserReposDetailsFactoryImpl(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public UserReposDetails createFromRawDto(UserReposRawDetailsDto githubDto) {
        return new UserReposDetails(
                new UserId(Long.parseLong(githubDto.id())),
                new UserLogin(githubDto.login()),
                new UserName(githubDto.name()),
                new UserType(githubDto.type()),
                new UserAvatarUrl(githubDto.avatarUrl()),
                new UserCreatedAt(LocalDateTime.parse(githubDto.createdAt(), formatter)),
                new UserFollowers(Integer.parseInt(githubDto.numberOfFollowers())),
                new UserPublicRepos(Integer.parseInt(githubDto.numberOfPublicRepos()))
        );
    }
}
