package com.cmm.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class MessageId implements Serializable {
    private String uid;
    private Integer tid;

    // 기본 생성자 (필수)
    public MessageId() {}

    public MessageId(String uid, Integer tid) {
        this.uid = uid;
        this.tid = tid;
    }

    // equals, hashCode (필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageId)) return false;
        MessageId that = (MessageId) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, tid);
    }
}
