//package com.example.sillim.service;
//
//import com.example.sillim.entity.BoardComment;
//import com.example.sillim.entity.Likes;
//import com.example.sillim.repository.BoardCommentRepository;
//import com.example.sillim.repository.LikesRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class LikesService {
//    private final LikesRepository likesRepository;
//
//    @Transactional
//    public Likes save(Likes likes) {
//        // Set the association on the comment side
//        if (likes.getBoard() != null) {
//            likes.getBoard().getLikesList().add(likes);
//        }
//
//        if (likes.getUser() != null) {
//            likes.getUser().getLikesList().add(likes);
//        }
//
//        return likesRepository.save(likes);
//    }
//
//    @Transactional
//    public Optional<List<Likes>> findAll() {
//        List<Likes> likesList = likesRepository.findAll();
//        return Optional.of(likesList);
//    }
//
//    public Optional<Likes> findOne(int id) {
//        Optional<Likes> likes = likesRepository.findById(id);
//        return likes;
//    }
//
////    @Transactional
////    public BoardComment update(Likes updatedComment) {
////        // Update the comment, no need to handle associations here
////        return boardCommentRepository.save(updatedComment);
////    }
//
//    @Transactional
//    public void delete(Integer likesId) {
//        Likes likes = likesRepository.findById(likesId)
//                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + likesId));
//
//        // Remove the association on the notice side
//        if (likes.getBoard() != null) {
//            likes.getBoard().getLikesList().remove(likes);
//        }
//        if (likes.getUser() !=null) {
//            likes.getUser().getLikesList().remove(likes);
//        }
//
//        likesRepository.deleteById(likesId);
//    }
//}
