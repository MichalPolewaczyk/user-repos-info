package com.recruitment.task.userreposinfo.domain.dto;

public record UserReposDetailsOutputDto(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        String calculations
) {
}
