package com.example.sillim.entity.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "board_comment_index")
public class BoardCommentElasticSearch {

    @Id
    private Integer boardCommentId;

    private String boardCommentCreator;

    private String boardCommentContent;

    @Field(type = FieldType.Keyword)
    private Integer boardId;
}
