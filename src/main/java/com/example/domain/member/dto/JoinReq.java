package com.example.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record JoinReq(
        @NotBlank(message = "아이디는 필수 항복입니다.")
        @Size(min = 4, max = 20, message = "아이디는 4자이상20자 이하로 입력해주세요.")
        String username,
        @NotBlank(message = "이메일은 필수항목입니다.")
        @Email(message = "올바른 이메일 형식이 아닙니다.")
        String email,
        @NotBlank(message = "비밀번호는 필수항목입니다.")
        @Size(min = 8, max = 30, message = "비밀번호는 8자 이상 30자 이하로 입력해주세요.")
        String password
) {
}
