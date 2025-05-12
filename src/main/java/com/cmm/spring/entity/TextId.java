package com.cmm.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
public class TextId implements Serializable {
    private String node;
    private Integer pid;
    private Integer tid;

    // 기본 생성자 (필수)
    public TextId() {}

    public TextId(String node, Integer pid, Integer tid) {
        this.node = node;
        this.pid = pid;
        this.tid = tid;
    }

    // equals, hashCode (필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextId)) return false;
        TextId that = (TextId) o;
        return Objects.equals(node, that.node) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, pid, tid);
    }
}
