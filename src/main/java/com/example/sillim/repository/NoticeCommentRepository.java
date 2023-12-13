package com.example.sillim.repository;

import com.example.sillim.entity.Board;
import com.example.sillim.entity.Notice;
import com.example.sillim.entity.NoticeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NoticeCommentRepository extends JpaRepository<NoticeComment, Integer> {

    @Query(value = "SELECT nc FROM NoticeComment nc WHERE nc.notice.noticeId=:id")
    List<NoticeComment> findAllByNoticeId(Integer id);

    Optional<NoticeComment> findById(Integer id);
    void deleteById(Integer id);
}
