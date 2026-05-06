package com.example.domain.member.dto;

import com.example.domain.member.entity.Member;

import java.util.List;

public record MemberListRes(
        List<MemberRes> members
) {
    public static MemberListRes from (List<Member> members){
        return new MemberListRes(
                members.stream()
                        .map(MemberRes::of)
                        .toList()
        );
    }
}
