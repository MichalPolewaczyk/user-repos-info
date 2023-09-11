package com.recruitment.task.userreposinfo.infrastructure.config;

import com.recruitment.task.userreposinfo.domain.port.CalculationsStrategy;
import com.recruitment.task.userreposinfo.domain.port.UserReposDetailsProvider;
import com.recruitment.task.userreposinfo.domain.port.UserReposRepository;
import com.recruitment.task.userreposinfo.domain.port.UserReposService;
import com.recruitment.task.userreposinfo.domain.service.DefaultUserReposDetailsFactoryImpl;
import com.recruitment.task.userreposinfo.domain.service.UserReposApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;

@Configuration
public class UserReposDetailsConfig {
    @Bean
    public UserReposService userReposService(
            UserReposDetailsProvider detailsProvider,
            CalculationsStrategy calculationsStrategy,
            UserReposRepository reposRepository

    ) {
        return new UserReposApplicationService(
                detailsProvider,
                new DefaultUserReposDetailsFactoryImpl(),
                calculationsStrategy,
                reposRepository,
                outputDateFormatter()
        );
    }

    @Bean
    public DateTimeFormatter outputDateFormatter() {
        return DateTimeFormatter.ISO_ORDINAL_DATE;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
