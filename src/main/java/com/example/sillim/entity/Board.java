package com.example.sillim.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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
}
