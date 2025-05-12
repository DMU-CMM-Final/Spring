package com.cmm.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class TeamMemId implements Serializable {
    private Integer tid;
    private String uid;

    // 기본 생성자 (필수)
    public TeamMemId() {}

    public TeamMemId(Integer tid, String uid) {
        this.tid = tid;
        this.uid = uid;
    }

    // equals, hashCode (필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamMemId)) return false;
        TeamMemId that = (TeamMemId) o;
        return Objects.equals(tid, that.tid) &&
                Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, uid);
    }
}
