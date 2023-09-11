package com.recruitment.task.userreposinfo.domain.boundary;

import java.time.LocalDateTime;

public record UserReposRawDetailsDto(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        LocalDateTime createdAt,
        int numberOfFollowers,
        int numberOfPublicRepos
) {
}
