package com.example.domain.member.repository;

import com.example.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
