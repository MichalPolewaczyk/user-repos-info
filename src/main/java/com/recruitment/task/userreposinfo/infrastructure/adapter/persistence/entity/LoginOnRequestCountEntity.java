package com.recruitment.task.userreposinfo.infrastructure.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "login_request_count")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class LoginOnRequestCountEntity {
    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "request_count")
    @Getter
    private Integer requestCount;
}
