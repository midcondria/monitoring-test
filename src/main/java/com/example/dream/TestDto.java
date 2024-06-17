package com.example.dream;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TestDto {

    private String email;
    private String password;

    @Builder
    public TestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
