package com.example.sillim.service.elasticsearch;

import com.example.sillim.entity.elasticsearch.BoardCommentElasticSearch;
import com.example.sillim.entity.elasticsearch.BoardElasticSearch;
import com.example.sillim.repository.elasticsearch.BoardCommentElasticSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentElasticSearchService {

    @Autowired
    private BoardCommentElasticSearchRepo boardCommentElasticSearchRepo;

    public BoardCommentElasticSearch insertBoardComments(BoardCommentElasticSearch boardComment){
        return boardCommentElasticSearchRepo.save(boardComment);
    }

    public Iterable<BoardCommentElasticSearch> getBoardComments() {
        return boardCommentElasticSearchRepo.findAll();
    }

    public void deleteBoardComments(int id){
        boardCommentElasticSearchRepo.deleteById(id);
    }
}
