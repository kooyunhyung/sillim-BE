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
    @JoinColumn(name = "notice_id")
    @JsonProperty("snc_board")
    @JsonBackReference
    private Notice notice;

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
