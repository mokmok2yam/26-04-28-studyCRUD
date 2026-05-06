package com.example.domain.member.service;

import com.example.domain.member.dto.MemberRes;
import com.example.domain.member.entity.Member;
import com.example.domain.member.repository.MemberRepository;
import com.example.global.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberRes join(String username, String email, String password) {
        checkJoin(username,email);
        Member member = new Member(username,email,password);
        Member savedmember = memberRepository.save(member);
        return MemberRes.of(savedmember);
    }


    public void checkJoin(String username,String email){
        if(memberRepository.existsByUserName(username)){
            throw new ServiceException("이미 사용중인 아이디입니다.");
        }
        if(memberRepository.existsByEmail(email)){
            throw new ServiceException("이미 사용중인 이메일입니다.");
        }
    }
}
