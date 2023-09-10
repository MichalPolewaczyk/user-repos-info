package com.recruitment.task.userreposinfo.domain.dto;

public record UserReposRawDetailsDto(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        String numberOfFollowers,
        String numberOfPublicRepos
) {
}
