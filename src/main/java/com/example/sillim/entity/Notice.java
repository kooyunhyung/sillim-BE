package com.example.sillim.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notice", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("sn_comment_list")
    @JsonManagedReference
    private List<NoticeComment> commentList;

    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonProperty("sn_date")
    private ZonedDateTime noticeCreatedAt;

    @PrePersist
    protected void onCreate() {
        noticeCreatedAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    // 연관관계 메서드

    public void addComment(NoticeComment comment) {
        commentList.add(comment);
        comment.setNotice(this);
    }

    public void removeComment(NoticeComment comment) {
        commentList.remove(comment);
        comment.setNotice(null);
    }

}
