package com.cmm.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class TeamProjectId implements Serializable {
    private Integer pid;
    private Integer tid;

    // 기본 생성자 (필수)
    public TeamProjectId() {}

    public TeamProjectId(Integer pid, Integer tid) {
        this.pid = pid;
        this.tid = tid;
    }

    // equals, hashCode (필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamProjectId)) return false;
        TeamProjectId that = (TeamProjectId) o;
        return Objects.equals(pid, that.pid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, tid);
    }
}
