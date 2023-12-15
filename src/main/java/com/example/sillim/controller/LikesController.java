//package com.example.sillim.controller;
//
//import com.example.sillim.dto.ResponseDto;
//import com.example.sillim.entity.Likes;
//import com.example.sillim.service.LikesService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/sillim")
//public class LikesController {
//
//    private final LikesService likesService;
//
//    // Create (likes)
//    @PostMapping("/likes")
//    public ResponseDto createLikes(@RequestBody Likes likes){
//        try{
//            if (likes != null) {
//                Likes result = likesService.save(likes);
//                return new ResponseDto<>(200, Optional.of(result));
//            } else {
//                return new ResponseDto<>(400);
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            return new ResponseDto<>(500);
//        }
//    }
//
//
//    // Read All (likes)
//    @GetMapping("/likes")
//    public Optional<List<Likes>> getLikes() {
//        try {
//            Optional<List<Likes>> likesList = likesService.findAll();
//            return likesList;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // Read One (likes)
//    @GetMapping("/likes/{id}")
//    public ResponseEntity<ResponseDto> getLikes(@PathVariable int id) {
//        try {
//            Optional<Likes> likes = likesService.findOne(id);
//            if (likes!=null) {
//                return new ResponseEntity<>(new ResponseDto<>(200, likes), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(new ResponseDto<>(404), HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    // Delete (likes)
//    @DeleteMapping("/likes/{id}")
//    public ResponseEntity<ResponseDto> deleteLikes(@PathVariable int id) {
//        try {
//            Optional<Likes> existingLikes = likesService.findOne(id);
//            if (existingLikes!=null) {
//                likesService.delete(id);
//                return new ResponseEntity<>(new ResponseDto<>(200), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(new ResponseDto<>(404), HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new ResponseDto<>(500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
