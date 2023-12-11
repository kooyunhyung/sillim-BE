package com.example.sillim.service.elasticsearch;

import com.example.sillim.entity.elasticsearch.BoardElasticSearch;
import com.example.sillim.repository.elasticsearch.BoardElasticSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardElasticSearchService {

    @Autowired
    private BoardElasticSearchRepo boardElasticSearchRepo;

    public BoardElasticSearch insertBoards(BoardElasticSearch board){
        return boardElasticSearchRepo.save(board);
    }

    public Iterable<BoardElasticSearch> getBoards() {
        return boardElasticSearchRepo.findAll();
    }

    public void deleteBoards(int id){
        boardElasticSearchRepo.deleteById(id);
    }
}
