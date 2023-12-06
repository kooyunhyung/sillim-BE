package com.example.sillim.service;

import com.example.sillim.entity.Notice;
import com.example.sillim.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public Notice save(Notice noticeParam){
        return noticeRepository.save(noticeParam);
    }

    public Optional<List<Notice>> findAll() {
        List<Notice> notices = noticeRepository.findAll();
        return Optional.of(notices);
    }

    public Optional<Notice> findOne(int id) {
        Optional<Notice> notice = noticeRepository.findById(id);
        return notice;
    }

    public void update(int id, Notice noticeParam) {
        noticeRepository.updateNotice(id, noticeParam);
    }

    public void delete(int id){
        noticeRepository.deleteById(id);
    }


}
