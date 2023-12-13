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
        // cascade 옵션이 없기 때문에 게시글이 삭제되면 연관된 댓글들 삭제하도록 로직 작성...
        boardElasticSearchRepo.deleteById(id);
    }
}
