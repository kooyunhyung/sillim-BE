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
@Document(indexName = "notice_comment_index")
public class NoticeCommentElasticSearch {

    @Id
    private Integer noticeCommentId;

    private String noticeCommentCreator;

    private String noticeCommentContent;

    @Field(type = FieldType.Keyword)
    private Integer noticeId;
}
