package com.xcfh.usermanager.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by zhangfan on 2014/10/24.
 */
@Entity
@Table(name = "tb_urlsess", schema = "", catalog = "xcfh")
public class TbUrlsessEntity {
    private String sid;
    private String uid;
    private String uidMd5;
    private String state;
    private String timeMs;
    private Timestamp timestamp;

    @Id
    @Column(name = "sid", nullable = false, insertable = true, updatable = true, length = 32)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "uid", nullable = true, insertable = true, updatable = true, length = 32)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "uid_md5", nullable = true, insertable = true, updatable = true, length = 32)
    public String getUidMd5() {
        return uidMd5;
    }

    public void setUidMd5(String uidMd5) {
        this.uidMd5 = uidMd5;
    }

    @Basic
    @Column(name = "state", nullable = true, insertable = true, updatable = true, length = 1)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "time_ms", nullable = true, insertable = true, updatable = true, length = 13)
    public String getTimeMs() {
        return timeMs;
    }

    public void setTimeMs(String timeMs) {
        this.timeMs = timeMs;
    }

    @Basic
    @Column(name = "timestamp", nullable = false, insertable = true, updatable = true)
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbUrlsessEntity that = (TbUrlsessEntity) o;

        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (timeMs != null ? !timeMs.equals(that.timeMs) : that.timeMs != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (uidMd5 != null ? !uidMd5.equals(that.uidMd5) : that.uidMd5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (uidMd5 != null ? uidMd5.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (timeMs != null ? timeMs.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
