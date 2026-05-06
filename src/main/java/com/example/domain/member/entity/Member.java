package com.example.domain.member.entity;

import com.example.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Column(nullable = false,unique = true)
    String userName;
    @Column(nullable = false,unique = true)
    String email;
    @Column(nullable = false)
    String password;
    public Member (String userName, String email, String password){
        this.userName=userName;
        this.email=email;
        this.password=password;
    }
}
