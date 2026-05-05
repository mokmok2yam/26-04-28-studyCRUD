package com.example.domain.member.entity;

import com.example.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Member extends BaseEntity {
    @Column(nullable = false)
    String userName;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String password;

}
