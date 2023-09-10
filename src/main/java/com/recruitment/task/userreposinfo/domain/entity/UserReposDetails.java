package com.recruitment.task.userreposinfo.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReposDetails {
    private final UserId id;
    private final UserLogin login;
    private final UserName name;
    private final UserType type;
    private final UserAvatarUrl avatarUrl;
    private final UserCreatedAt createdAt;
    private final UserFollowers followers;
    private final UserPublicRepos publicRepos;
}
