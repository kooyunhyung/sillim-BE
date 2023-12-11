package com.example.sillim.entity.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "notices_index")
public class NoticeElasticSearch {

    @Id
    private Integer noticeId;

    private String noticeTitle;

    private String noticeCreator;

    private String noticeContent;
}
