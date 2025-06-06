package com.cmm.spring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class KakaoInfoDto {
    private String id;
    private KakaoAccountDto kakao_account;
}
