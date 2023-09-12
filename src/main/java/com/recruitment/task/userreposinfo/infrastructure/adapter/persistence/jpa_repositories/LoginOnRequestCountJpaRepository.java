package com.recruitment.task.userreposinfo.infrastructure.adapter.persistence.jpa_repositories;

import com.recruitment.task.userreposinfo.infrastructure.adapter.persistence.entity.LoginOnRequestCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginOnRequestCountJpaRepository extends JpaRepository<LoginOnRequestCountEntity, String> {
}
