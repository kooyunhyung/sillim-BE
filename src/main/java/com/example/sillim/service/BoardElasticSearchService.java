package com.example.sillim.service;

import com.example.sillim.entity.BoardElasticSearch;
import com.example.sillim.repository.BoardElasticSearchRepo;
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

    public BoardElasticSearch updateBoards(BoardElasticSearch board, int id) {
        BoardElasticSearch board1= boardElasticSearchRepo.findById(id).get();
        board1.setBoardLike(board.getBoardLike());
        return board1;
    }

    public void deleteBoards(int id){
        boardElasticSearchRepo.deleteById(id);
    }
}
