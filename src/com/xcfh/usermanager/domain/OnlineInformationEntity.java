package com.xcfh.usermanager.domain;

import javax.persistence.*;

/**
 * Created by xcfh on 2014/9/28.
 */
@Entity
@Table(name = "online_information", schema = "", catalog = "xcfh")
public class OnlineInformationEntity {
    private int onlineIncrementId;
    private String onlineUserId;
    private String onlineMacAddress;
    private String onlineImei;
    private String onlineTime;
    private String onlineIp;
    private String onlineSystemType;
    private String softerwareVersion;
    private String configVersion;
    private String onlineDeviceMode;
    private String onlineVersionRelease;

    @Id
    @Column(name = "online_increment_id", nullable = false, insertable = true, updatable = true)
    public int getOnlineIncrementId() {
        return onlineIncrementId;
    }

    public void setOnlineIncrementId(int onlineIncrementId) {
        this.onlineIncrementId = onlineIncrementId;
    }

    @Basic
    @Column(name = "online_user_id", nullable = true, insertable = true, updatable = true, length = 33)
    public String getOnlineUserId() {
        return onlineUserId;
    }

    public void setOnlineUserId(String onlineUserId) {
        this.onlineUserId = onlineUserId;
    }

    @Basic
    @Column(name = "online_mac_address", nullable = true, insertable = true, updatable = true, length = 17)
    public String getOnlineMacAddress() {
        return onlineMacAddress;
    }

    public void setOnlineMacAddress(String onlineMacAddress) {
        this.onlineMacAddress = onlineMacAddress;
    }

    @Basic
    @Column(name = "online_imei", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOnlineImei() {
        return onlineImei;
    }

    public void setOnlineImei(String onlineImei) {
        this.onlineImei = onlineImei;
    }

    @Basic
    @Column(name = "online_time", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Basic
    @Column(name = "online_ip", nullable = true, insertable = true, updatable = true, length = 50)
    public String getOnlineIp() {
        return onlineIp;
    }

    public void setOnlineIp(String onlineIp) {
        this.onlineIp = onlineIp;
    }

    @Basic
    @Column(name = "online_system_type", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOnlineSystemType() {
        return onlineSystemType;
    }

    public void setOnlineSystemType(String onlineSystemType) {
        this.onlineSystemType = onlineSystemType;
    }

    @Basic
    @Column(name = "softerware_version", nullable = true, insertable = true, updatable = true, length = 20)
    public String getSofterwareVersion() {
        return softerwareVersion;
    }

    public void setSofterwareVersion(String softerwareVersion) {
        this.softerwareVersion = softerwareVersion;
    }

    @Basic
    @Column(name = "config_version", nullable = true, insertable = true, updatable = true, length = 20)
    public String getConfigVersion() {
        return configVersion;
    }

    public void setConfigVersion(String configVersion) {
        this.configVersion = configVersion;
    }

    @Basic
    @Column(name = "online_device_mode", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOnlineDeviceMode() {
        return onlineDeviceMode;
    }

    public void setOnlineDeviceMode(String onlineDeviceMode) {
        this.onlineDeviceMode = onlineDeviceMode;
    }

    @Basic
    @Column(name = "online_version_release", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOnlineVersionRelease() {
        return onlineVersionRelease;
    }

    public void setOnlineVersionRelease(String onlineVersionRelease) {
        this.onlineVersionRelease = onlineVersionRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OnlineInformationEntity that = (OnlineInformationEntity) o;

        if (onlineIncrementId != that.onlineIncrementId) return false;
        if (configVersion != null ? !configVersion.equals(that.configVersion) : that.configVersion != null)
            return false;
        if (onlineDeviceMode != null ? !onlineDeviceMode.equals(that.onlineDeviceMode) : that.onlineDeviceMode != null)
            return false;
        if (onlineImei != null ? !onlineImei.equals(that.onlineImei) : that.onlineImei != null) return false;
        if (onlineIp != null ? !onlineIp.equals(that.onlineIp) : that.onlineIp != null) return false;
        if (onlineMacAddress != null ? !onlineMacAddress.equals(that.onlineMacAddress) : that.onlineMacAddress != null)
            return false;
        if (onlineSystemType != null ? !onlineSystemType.equals(that.onlineSystemType) : that.onlineSystemType != null)
            return false;
        if (onlineTime != null ? !onlineTime.equals(that.onlineTime) : that.onlineTime != null) return false;
        if (onlineUserId != null ? !onlineUserId.equals(that.onlineUserId) : that.onlineUserId != null) return false;
        if (onlineVersionRelease != null ? !onlineVersionRelease.equals(that.onlineVersionRelease) : that.onlineVersionRelease != null)
            return false;
        if (softerwareVersion != null ? !softerwareVersion.equals(that.softerwareVersion) : that.softerwareVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = onlineIncrementId;
        result = 31 * result + (onlineUserId != null ? onlineUserId.hashCode() : 0);
        result = 31 * result + (onlineMacAddress != null ? onlineMacAddress.hashCode() : 0);
        result = 31 * result + (onlineImei != null ? onlineImei.hashCode() : 0);
        result = 31 * result + (onlineTime != null ? onlineTime.hashCode() : 0);
        result = 31 * result + (onlineIp != null ? onlineIp.hashCode() : 0);
        result = 31 * result + (onlineSystemType != null ? onlineSystemType.hashCode() : 0);
        result = 31 * result + (softerwareVersion != null ? softerwareVersion.hashCode() : 0);
        result = 31 * result + (configVersion != null ? configVersion.hashCode() : 0);
        result = 31 * result + (onlineDeviceMode != null ? onlineDeviceMode.hashCode() : 0);
        result = 31 * result + (onlineVersionRelease != null ? onlineVersionRelease.hashCode() : 0);
        return result;
    }
}
