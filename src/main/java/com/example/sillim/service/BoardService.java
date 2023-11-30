package com.example.sillim.service;

import com.example.sillim.entity.Board;
import com.example.sillim.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(Board boardParam) {
        boardRepository.save(boardParam);
    }

    public Optional<List<Board>> findAll() {
        List<Board> boards = boardRepository.findAll();
        return Optional.of(boards);
    }

    public Optional<Board> findOne(int id) {
        Optional<Board> board = boardRepository.findById(id);
        return board;
    }

    public void update(int id, Board boardParam) {
        boardRepository.updateBoard(id, boardParam);
    }

    public void delete(int id) {
        boardRepository.deleteById(id);
    }

}
