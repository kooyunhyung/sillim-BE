package com.example.sillim.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class NoticeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonProperty("snc_id")
    private Integer noticeCommentId;

    @Column(length = 100)
    @JsonProperty("snc_creator")
    private String noticeCommentCreator;

    @Column(length = 200)
    @JsonProperty("snc_content")
    private String noticeCommentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id",insertable = false, updatable = false)
    @JsonBackReference
    @JsonProperty("snc_notice")
    private Notice notice;

    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonProperty("snc_date")
    private ZonedDateTime noticeCommentCreatedAt;

    @PrePersist
    protected void onCreate() {
        noticeCommentCreatedAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    // 연관관계 메서드

    public void setNotice(Notice notice) {
        this.notice = notice;
        if (notice != null) {
            notice.getCommentList().add(this);
        }
    }

    public void removeNotice() {
        if (notice != null) {
            notice.getCommentList().remove(this);
            notice = null;
        }
    }


}
