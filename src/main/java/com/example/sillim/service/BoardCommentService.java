package com.example.sillim.service;

import com.example.sillim.entity.BoardComment;
import com.example.sillim.repository.BoardCommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardCommentService {
    private final BoardCommentRepository boardCommentRepository;

    @Transactional
    public BoardComment save(BoardComment boardComment) {
        // Set the association on the comment side
        if (boardComment.getBoard() != null) {
            boardComment.getBoard().getCommentList().add(boardComment);
        }
        return boardCommentRepository.save(boardComment);
    }

    @Transactional
    public Optional<List<BoardComment>> findAll(int board_id) {
        List<BoardComment> boardComments = boardCommentRepository.findAllByBoardId(board_id);
        return Optional.of(boardComments);
    }

    public Optional<BoardComment> findOne(int id) {
        Optional<BoardComment> boardComment = boardCommentRepository.findById(id);
        return boardComment;
    }

    @Transactional
    public BoardComment update(BoardComment updatedComment) {
        // Update the comment, no need to handle associations here
        return boardCommentRepository.save(updatedComment);
    }

    @Transactional
    public void delete(Integer commentId) {
        BoardComment boardComment = boardCommentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));

        // Remove the association on the notice side
        if (boardComment.getBoard() != null) {
            boardComment.getBoard().getCommentList().remove(boardComment);
        }

        boardCommentRepository.deleteById(commentId);
    }
}
