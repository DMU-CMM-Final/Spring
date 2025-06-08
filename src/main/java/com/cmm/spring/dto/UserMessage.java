package com.cmm.spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMessage {
    private Integer tid;
    private String tname;
    private String uid;
    private Integer content;
}
