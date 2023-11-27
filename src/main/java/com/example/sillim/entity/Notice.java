package com.example.sillim.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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

    @Builder
    public Notice(Integer noticeId, String noticeTitle, String noticeCreator, String noticeContent) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeCreator = noticeCreator;
        this.noticeContent = noticeContent;
    }
}
