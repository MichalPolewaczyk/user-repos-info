package com.recruitment.task.userreposinfo.infrastructure.config;

import com.recruitment.task.userreposinfo.domain.entity.CalculationsStrategy;
import com.recruitment.task.userreposinfo.domain.port.UserReposDetailsProvider;
import com.recruitment.task.userreposinfo.domain.port.UserReposRepository;
import com.recruitment.task.userreposinfo.domain.port.UserReposService;
import com.recruitment.task.userreposinfo.domain.service.DefaultUserReposDetailsFactoryImpl;
import com.recruitment.task.userreposinfo.domain.service.UserReposApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                new DefaultUserReposDetailsFactoryImpl(formatter()),
                calculationsStrategy,
                reposRepository,
                formatter()
        );
    }

    @Bean
    public DateTimeFormatter formatter() {
        return DateTimeFormatter.BASIC_ISO_DATE;
    }
}
