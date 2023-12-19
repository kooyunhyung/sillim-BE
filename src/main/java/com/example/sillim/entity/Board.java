package com.example.sillim.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonProperty("sb_id")
    private Integer boardId;

    @Column(length = 100)
    @JsonProperty("sb_title")
    private String boardTitle;

    @Column(length = 100)
    @JsonProperty("sb_creator")
    private String boardCreator;

    @Column(length = 500)
    @JsonProperty("sb_content")
    private String boardContent;

    @JsonProperty("sb_like")
    private Integer boardLike;

    @JsonProperty("sb_bookmark")
    private Boolean boardBookmark;

    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonProperty("sb_date")
    private ZonedDateTime boardCreatedAt;

    @PrePersist
    protected void onCreate() {
        boardCreatedAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("sb_comment_list")
    @JsonManagedReference
    private List<BoardComment> commentList;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonProperty("sb_likes_list")
//    @JsonManagedReference
//    private List<Likes> likesList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonProperty("sb_bookmark_list")
//    @JsonManagedReference
//    private List<Bookmark> bookmarkList;

    // 연관관계 메서드

    public void addComment(BoardComment comment) {
        commentList.add(comment);
        comment.setBoard(this);
    }

    public void removeComment(BoardComment comment) {
        commentList.remove(comment);
        comment.setBoard(null);
    }
}
