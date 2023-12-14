package com.example.sillim.controller;

import com.example.sillim.dto.ResponseDto;
import com.example.sillim.entity.BoardComment;
import com.example.sillim.entity.NoticeComment;
import com.example.sillim.service.BoardCommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/sillim")
public class BoardCommentController {
    private final BoardCommentService boardCommentService;

    // Create (board comment)
    @PostMapping("/board/comment")
    public ResponseDto createBoardComment(@RequestBody BoardComment boardCommentParam){
        try{
            if (boardCommentParam != null) {
                BoardComment result = boardCommentService.save(boardCommentParam);
                return new ResponseDto<>(200, Optional.of(result));
            } else {
                return new ResponseDto<>(400);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseDto<>(500);
        }
    }


    // Read All (board comment)
    @GetMapping("/board/comment/{board_id}")
    public Optional<List<BoardComment>> getBoardComments(@PathVariable int board_id) {
        try {
            Optional<List<BoardComment>> boardComments = boardCommentService.findAll(board_id);
            return boardComments;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update (notice)
//    @PostMapping("/notice/comment/{notice_id}")
//    public ResponseEntity<ResponseDto> updateNotice(@PathVariable int notice_id, @RequestBody NoticeComment updatedNoticeComment) {
//        try {
//            noticeCommentService.update(notice_id,updatedNoticeComment);
//
//            return new ResponseEntity<>(new ResponseDto<>(200, Optional.of(updatedNoticeComment)), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // Delete (board comment)
    @DeleteMapping("/board/comment/{id}")
    public ResponseEntity<ResponseDto> deleteBoardComment(@PathVariable int id) {
        try {
            Optional<BoardComment> existingBoardComment = boardCommentService.findOne(id);
            if (existingBoardComment!=null) {
                boardCommentService.delete(id);
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
