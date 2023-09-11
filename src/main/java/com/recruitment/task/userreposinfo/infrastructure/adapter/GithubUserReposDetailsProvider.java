package com.recruitment.task.userreposinfo.infrastructure.adapter;

import com.recruitment.task.userreposinfo.domain.boundary.UserReposRawDetailsDto;
import com.recruitment.task.userreposinfo.domain.port.UserReposDetailsProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor
public class GithubUserReposDetailsProvider implements UserReposDetailsProvider {
    private static final String GITHUB_API_URL_TEMPLATE = "https://api.github.com/users/%s";
    private static final DateTimeFormatter githubResponseDateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;


    private final RestTemplate restTemplate;

    @Override
    public UserReposRawDetailsDto getDetailsOfUserWithGivenLogin(String login) {
        GithubResponseDto responseDto = restTemplate.getForObject(
                getUrlBasedOnLogin(login),
                GithubResponseDto.class
        );

        return githubDtoToUserReposRawDetailsDto(responseDto);
    }

    private String getUrlBasedOnLogin(String login) {
        return String.format(GITHUB_API_URL_TEMPLATE, login);
    }

    private UserReposRawDetailsDto githubDtoToUserReposRawDetailsDto(GithubResponseDto githubDto) {
        return new UserReposRawDetailsDto(
                githubDto.id,
                githubDto.login,
                githubDto.name,
                githubDto.type,
                githubDto.avatar_url,
                LocalDateTime.parse(githubDto.created_at, githubResponseDateTimeFormatter),
                Integer.parseInt(githubDto.followers),
                Integer.parseInt(githubDto.public_repos)
        );
    }

    private static record GithubResponseDto(
        String id,
        String login,
        String avatar_url,
        String public_repos,
        String followers,
        String created_at,
        String type,
        String name
    ) {}
}
