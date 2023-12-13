package com.example.sillim.controller;

import com.example.sillim.dto.ResponseDto;
import com.example.sillim.entity.Notice;
import com.example.sillim.entity.NoticeComment;
import com.example.sillim.service.NoticeCommentService;
import com.example.sillim.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/sillim")
public class NoticeCommentController {
    private final NoticeCommentService noticeCommentService;

    // Create (notice)
    @PostMapping("/notice/comment")
    public ResponseDto createNoticeComment(@RequestBody NoticeComment noticeCommentParam){
        try{
            if (noticeCommentParam != null) {
                NoticeComment result = noticeCommentService.save(noticeCommentParam);
                return new ResponseDto<>(200, Optional.of(result));
            } else {
                return new ResponseDto<>(400);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseDto<>(500);
        }
    }


    // Read All (notice)
    @GetMapping("/notice/comment/{notice_id}")
    public Optional<List<NoticeComment>> getNoticeComments(@PathVariable int notice_id) {
        try {
            Optional<List<NoticeComment>> noticeComments = noticeCommentService.findAll(notice_id);
            return noticeComments;
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

    // Delete (notice)
    @DeleteMapping("/notice/comment/{id}")
    public ResponseEntity<ResponseDto> deleteNoticeComment(@PathVariable int id) {
        try {
            Optional<NoticeComment> existingNoticeComment = noticeCommentService.findOne(id);
            if (existingNoticeComment!=null) {
                noticeCommentService.delete(id);
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
