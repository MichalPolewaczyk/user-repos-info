package com.recruitment.task.userreposinfo.infrastructure.adapter.persistence;

import com.recruitment.task.userreposinfo.domain.port.UserReposRepository;
import com.recruitment.task.userreposinfo.infrastructure.adapter.persistence.entity.LoginOnRequestCountEntity;
import com.recruitment.task.userreposinfo.infrastructure.adapter.persistence.jpa_repositories.LoginOnRequestCountJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DefaultUserReposDetailsRepository implements UserReposRepository {
    private static final int ZERO = 0;

    private final LoginOnRequestCountJpaRepository loginOnRequestCountJpaRepository;

    @Override
    @Transactional
    public void incrementRequestCountForUserWithGivenLogin(String login) {
        LoginOnRequestCountEntity entity = getEntityForGivenLoginOrCreateIfDoesNotExist(login);
        entity.setRequestCount(
                entity.getRequestCount() + 1
        );
    }

    private LoginOnRequestCountEntity getEntityForGivenLoginOrCreateIfDoesNotExist(String login) {
        Optional<LoginOnRequestCountEntity> potentialEntity = loginOnRequestCountJpaRepository.findById(login);
        return potentialEntity.orElseGet(() -> loginOnRequestCountJpaRepository.save(
                createEntityForGivenLogin(login)
        ));
    }

    private LoginOnRequestCountEntity createEntityForGivenLogin(String login) {
        return new LoginOnRequestCountEntity(
                login,
                ZERO
        );
    }
}
