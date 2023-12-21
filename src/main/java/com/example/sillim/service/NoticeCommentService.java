package com.example.sillim.service;

import com.example.sillim.entity.NoticeComment;
import com.example.sillim.repository.NoticeCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeCommentService {
    private final NoticeCommentRepository noticeCommentRepository;

    @Transactional
    public NoticeComment save(NoticeComment noticeComment) {
        // Set the association on the comment side
        if (noticeComment.getNotice() != null) {
            noticeComment.getNotice().getCommentList().add(noticeComment);
        }
        return noticeCommentRepository.save(noticeComment);
    }

    @Transactional
    public Optional<List<NoticeComment>> findAll(int notice_id) {
        List<NoticeComment> noticeComments = noticeCommentRepository.findAllByNoticeId(notice_id);
        return Optional.of(noticeComments);
    }

    public Optional<NoticeComment> findOne(int id) {
        Optional<NoticeComment> noticeComment = noticeCommentRepository.findById(id);
        return noticeComment;
    }

    @Transactional
    public NoticeComment update(NoticeComment updatedComment) {
        // Update the comment, no need to handle associations here
        return noticeCommentRepository.save(updatedComment);
    }

    @Transactional
    public void delete(Integer commentId) {
        NoticeComment noticeComment = noticeCommentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));

        // Remove the association on the notice side
        if (noticeComment.getNotice() != null) {
            noticeComment.getNotice().getCommentList().remove(noticeComment);
        }
        noticeCommentRepository.deleteById(commentId);
    }

}
