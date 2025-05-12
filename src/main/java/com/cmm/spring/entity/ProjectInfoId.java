package com.cmm.spring.entity;

import java.util.Objects;

public class ProjectInfoId {
    private String node;
    private Integer pid;
    private Integer tid;

    // 기본 생성자 (필수)
    public ProjectInfoId() {}

    public ProjectInfoId(String node, Integer pid, Integer tid) {
        this.node = node;
        this.pid = pid;
        this.tid = tid;
    }

    // equals, hashCode (필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectInfoId)) return false;
        ProjectInfoId that = (ProjectInfoId) o;
        return Objects.equals(node, that.node) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(tid, that.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, pid, tid);
    }
}
