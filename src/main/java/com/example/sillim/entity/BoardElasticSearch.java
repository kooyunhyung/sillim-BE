package com.example.sillim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "boards_index")
public class BoardElasticSearch {

    @Id
    private Integer boardId;

    private String boardTitle;

    private String boardCreator;

    private String boardContent;

    private Integer boardLike;

    private Boolean boardBookmark;
}
