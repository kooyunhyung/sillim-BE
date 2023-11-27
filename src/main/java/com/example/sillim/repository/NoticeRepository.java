package com.example.sillim.repository;

import com.example.sillim.entity.Notice;
import com.example.sillim.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    Optional<Notice> findById(Integer id);
}
