//package com.example.sillim.entity;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//public class Bookmark {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long bookmarkId;
//
//    @Column(name = "user_id")
//    @JsonProperty("sbk_su_id")
//    private Long userId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id",insertable = false,updatable = false)
//    private User user;
//
//    @Column(name = "board_id")
//    @JsonProperty("sbk_sb_id")
//    private Long boardId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "board_id",insertable = false,updatable = false)
//    private Board board;
//}
