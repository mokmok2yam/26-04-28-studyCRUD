package com.example.domain.member.dto;

import com.example.domain.member.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MemberRes(
        Long id,
        String username,
        String email,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {
    public static MemberRes of(Member member){
        return new MemberRes(
                member.getId(),
                member.getUserName(),
                member.getEmail(),
                member.getCreatedAt(),
                member.getUpdatedAt()
                );
    }
}
