package com.example.sillim.repository;

import com.example.sillim.entity.Board;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Optional<Board> findById(Integer id);

    void deleteById(Integer id);

    @Transactional
    default void updateBoard(int id, Board boardParam) {
        findById(id).ifPresent(findBoard -> {
            findBoard.setBoardTitle(boardParam.getBoardTitle());
            findBoard.setBoardCreator(boardParam.getBoardCreator());
            findBoard.setBoardContent(boardParam.getBoardContent());
            findBoard.setBoardLike(boardParam.getBoardLike());
        });
    }

    @Query(value = "SELECT b FROM Board b WHERE b.boardLike>=5")
    List<Board> findPopularBoard();

    @Query(value = "SELECT b FROM Board b WHERE b.boardBookmark=true")
    List<Board> findBookmarkedBoard();
}
