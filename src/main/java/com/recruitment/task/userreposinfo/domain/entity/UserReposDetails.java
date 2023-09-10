package com.recruitment.task.userreposinfo.domain.entity;


public class UserReposDetails {
    private final UserId id;
    private final UserLogin login;
    private final UserName name;
    private final UserType type;
    private final UserAvatarUrl avatarUrl;
    private final UserCreatedAt createdAt;
    private final UserFollowers followers;
    private final UserPublicRepos publicRepos;

    public UserReposDetails(
            UserId id,
            UserLogin login,
            UserName name,
            UserType type,
            UserAvatarUrl avatarUrl,
            UserCreatedAt createdAt,
            UserFollowers followers,
            UserPublicRepos publicRepos
    ) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.followers = followers;
        this.publicRepos = publicRepos;
    }
}
