package com.recruitment.task.userreposinfo.domain.service;

import com.recruitment.task.userreposinfo.domain.dto.UserReposDetailsGithubDto;
import com.recruitment.task.userreposinfo.domain.entity.UserReposDetails;

public interface UserReposDetailsFactory {
    UserReposDetails createFromGithubDto(
            UserReposDetailsGithubDto githubDto
    );
}
