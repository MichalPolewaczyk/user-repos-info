package com.recruitment.task.userreposinfo.infrastructure.config;

import com.recruitment.task.userreposinfo.domain.port.UserReposDetailsProvider;
import com.recruitment.task.userreposinfo.domain.port.UserReposRepository;
import com.recruitment.task.userreposinfo.domain.port.UserReposFacade;
import com.recruitment.task.userreposinfo.domain.service.DefaultUserReposDetailsFactoryImpl;
import com.recruitment.task.userreposinfo.domain.service.UserReposFacadeImpl;
import com.recruitment.task.userreposinfo.domain.service.TaskCalculationsStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

@Configuration
public class UserReposDetailsConfig {
    @Bean
    public UserReposFacade userReposService(
            UserReposDetailsProvider detailsProvider,
            UserReposRepository reposRepository
    ) {
        return new UserReposFacadeImpl(
                detailsProvider,
                new DefaultUserReposDetailsFactoryImpl(),
                new TaskCalculationsStrategy(),
                reposRepository,
                outputDateFormatter(),
                decimalFormat()
        );
    }

    @Bean
    public DateTimeFormatter outputDateFormatter() {
        return DateTimeFormatter.ISO_ORDINAL_DATE;
    }

    @Bean
    public DecimalFormat decimalFormat() {
        return new DecimalFormat("#.####");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
