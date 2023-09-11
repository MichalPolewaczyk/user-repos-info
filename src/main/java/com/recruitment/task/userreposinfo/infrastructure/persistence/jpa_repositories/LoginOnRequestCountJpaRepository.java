package com.recruitment.task.userreposinfo.infrastructure.persistence.jpa_repositories;

import com.recruitment.task.userreposinfo.infrastructure.persistence.entity.LoginOnRequestCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginOnRequestCountJpaRepository extends JpaRepository<LoginOnRequestCountEntity, String> {
}
