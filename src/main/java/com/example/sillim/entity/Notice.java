package com.example.sillim.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonProperty("sn_id")
    private Integer noticeId;

    @Column(length = 100)
    @JsonProperty("sn_title")
    private String noticeTitle;

    @Column(length = 100)
    @JsonProperty("sn_creator")
    private String noticeCreator;

    @Column(length = 500)
    @JsonProperty("sn_content")
    private String noticeContent;

}
