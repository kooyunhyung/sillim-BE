package com.example.sillim.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonProperty("su_id")
    private Integer userId;

    @Column(length = 50, nullable = false)
    @JsonProperty("su_email")
    private String userEmail;

    @Column(length = 200, nullable = false)
    @JsonProperty("su_password")
    private String userPassword;

    @Column(length = 10, nullable = false)
    @JsonProperty("su_name")
    private String userName;

    @Column(length = 10, nullable = false)
    @JsonProperty("su_sex")
    private String userSex;

    @Column(length = 12, nullable = false)
    @JsonProperty("su_phone")
    private String userPhone;
}
