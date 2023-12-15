//package com.example.sillim.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//public class Likes {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonProperty("sl_id")
//    private Long likeId;
//
//    @Column(name = "user_id")
//    @JsonProperty("sl_su_id")
//    private Long userId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    @JsonBackReference
//    private User user;
//
//    @Column(name = "board_id")
//    @JsonProperty("sl_sb_id")
//    private Long boardId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "board_id", insertable = false, updatable = false)
//    @JsonBackReference
//    private Board board;
//
//}
