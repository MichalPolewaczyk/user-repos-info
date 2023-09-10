package com.recruitment.task.userreposinfo.domain.service;

import com.recruitment.task.userreposinfo.domain.dto.UserReposRawDetailsDto;
import com.recruitment.task.userreposinfo.domain.entity.UserReposDetails;

public interface UserReposDetailsFactory {
    UserReposDetails createFromRawDto(
            UserReposRawDetailsDto githubDto
    );
}
