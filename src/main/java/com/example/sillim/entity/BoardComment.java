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
public class BoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @JsonProperty("sbc_id")
    private Integer boardCommentId;

    @Column(length = 100)
    @JsonProperty("sbc_creator")
    private String boardCommentCreator;

    @Column(length = 200)
    @JsonProperty("sbc_content")
    private String boardCommentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    @JsonProperty("sbc_sb_id")
    private Board board;

    // 연관관계 메서드

    public void setBoard(Board board) {
        this.board = board;
        if (board != null) {
            board.getCommentList().add(this);
        }
    }

    public void removeBoard() {
        if (board != null) {
            board.getCommentList().remove(this);
            board = null;
        }
    }


}