package com.example.domain.member.controller;

import com.example.domain.member.dto.JoinReq;
import com.example.domain.member.dto.MemberListRes;
import com.example.domain.member.dto.MemberRes;
import com.example.domain.member.service.MemberService;
import com.example.global.RS.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    /**
     *
     * @param req:username, password,email을 받은 req
     * @return id,email을 받은 Rs데이터 리턴
     */
    @PostMapping
    public ResponseEntity<RsData<MemberRes>> join(
            @RequestBody @Valid JoinReq req
    ) {
        //Todo Validation 에러 예외처리
        MemberRes rst = memberService.join(req.username(), req.email(), req.password());
        return ResponseEntity.ok(
                new RsData<>(
                        "200",
                        "회원가입이 성공적으로 완료되었습니다."
                        , rst
                )
        );
    }
    @GetMapping
    public ResponseEntity<RsData<MemberListRes>> getMemberList(){
        MemberListRes rst= memberService.getMemberList();
        return ResponseEntity.ok(
                new RsData<>(
                        "200",
                        "회원조회가 완료되었습니다.",
                        rst
                )
        );
    }
}
