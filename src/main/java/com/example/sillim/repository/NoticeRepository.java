package com.example.sillim.repository;

import com.example.sillim.entity.Notice;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    Optional<Notice> findById(Integer id);
    void deleteById(Integer id);

    @Transactional
    default void updateNotice(int id, Notice noticeParam) {
        findById(id).ifPresent(findNotice -> {
            findNotice.setNoticeTitle(noticeParam.getNoticeTitle());
            findNotice.setNoticeCreator(noticeParam.getNoticeCreator());
            findNotice.setNoticeContent(noticeParam.getNoticeContent());
        });

    }
}
