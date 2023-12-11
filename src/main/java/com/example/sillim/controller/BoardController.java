package com.example.sillim.controller;

import com.example.sillim.dto.ResponseDto;
import com.example.sillim.entity.Board;
import com.example.sillim.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sillim")
public class BoardController {
    private final BoardService boardService;

    // Create (board)
    @PostMapping("/board")
    public ResponseDto createBoard(@RequestBody Board boardParam){
        try{
            if (boardParam != null) {
                boardService.save(boardParam);
                return new ResponseDto<>(200, Optional.of(boardParam));
            } else {
                return new ResponseDto<>(400);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseDto<>(500);
        }
    }


    // Read All (board)
    @GetMapping("/board")
    public Optional<List<Board>> getBoards() {
        try {
            Optional<List<Board>> boards = boardService.findAll();
            return boards;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/board/popular")
    public Optional<List<Board>> getPopularBoards() {
        try {
            Optional<List<Board>> boards = boardService.findPopularBoard();
            return boards;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/board/bookmark")
    public Optional<List<Board>> getBookmarkedBoards() {
        try {
            Optional<List<Board>> boards = boardService.findBookmarkedBoard();
            return boards;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Read One (board)
    @GetMapping("/board/{id}")
    public ResponseEntity<ResponseDto> getBoard(@PathVariable int id) {
        try {
            Optional<Board> board = boardService.findOne(id);
            if (board!=null) {
                return new ResponseEntity<>(new ResponseDto<>(200, board), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseDto<>(404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update (board)
    @PostMapping("/board/{id}")
    public ResponseEntity<ResponseDto> updateBoard(@PathVariable int id, @RequestBody Board updatedBoard) {
        try {
            boardService.update(id,updatedBoard);

            return new ResponseEntity<>(new ResponseDto<>(200, Optional.of(updatedBoard)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete (board)
    @DeleteMapping("/board/{id}")
    public ResponseEntity<ResponseDto> deleteBoard(@PathVariable int id) {
        try {
            Optional<Board> existingBoard = boardService.findOne(id);
            if (existingBoard!=null) {
                boardService.delete(id);
                return new ResponseEntity<>(new ResponseDto<>(200), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseDto<>(404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
