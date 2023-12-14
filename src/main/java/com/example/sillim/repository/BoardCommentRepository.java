package com.example.sillim.repository;

import com.example.sillim.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Integer> {

    @Query(value = "SELECT bc FROM BoardComment bc WHERE bc.board.boardId=:id")
    List<BoardComment> findAllByBoardId(@Param("id") Integer id);

    Optional<BoardComment> findById(Integer id);
    void deleteById(Integer id);
}
