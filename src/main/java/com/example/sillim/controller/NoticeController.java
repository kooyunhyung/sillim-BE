package com.example.sillim.controller;

import com.example.sillim.dto.ResponseDto;
import com.example.sillim.entity.Notice;
import com.example.sillim.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/sillim")
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/test/{str}")
    public ResponseDto test(@PathVariable String str) {
        return new ResponseDto(200);
    }

    // Create (notice)
    @PostMapping("/notice")
    public ResponseDto createNotice(@RequestBody Notice noticeParam){
        try{
            if (noticeParam != null) {
                noticeService.save(noticeParam);
                return new ResponseDto(200, Optional.of(noticeParam));
            } else {
                return new ResponseDto(400);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseDto(500);
        }
    }


    // Read All (notice)
    @GetMapping("/notice")
    public Optional<List<Notice>> getNotices() {
        try {
            Optional<List<Notice>> notices = noticeService.findAll();
            return notices;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Read One (notice)
    @GetMapping("/notice/{id}")
    public ResponseEntity<ResponseDto> getNotice(@PathVariable int id) {
        try {
            Optional<Notice> notice = noticeService.findOne(id);
            if (notice!=null) {
                return new ResponseEntity<>(new ResponseDto(200, notice), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseDto(404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update (notice)
    @PostMapping("/notice/{id}")
    public ResponseEntity<ResponseDto> updateNotice(@PathVariable int id, @RequestBody Notice updatedNotice) {
        try {
            noticeService.update(id,updatedNotice);

            return new ResponseEntity<>(new ResponseDto(200, Optional.of(updatedNotice)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete (notice)
    @DeleteMapping("/notice/{id}")
    public ResponseEntity<ResponseDto> deleteNotice(@PathVariable int id) {
        try {
            Optional<Notice> existingNotice = noticeService.findOne(id);
            if (existingNotice!=null) {
                noticeService.delete(id);
                return new ResponseEntity<>(new ResponseDto(200), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseDto(404), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseDto(500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
