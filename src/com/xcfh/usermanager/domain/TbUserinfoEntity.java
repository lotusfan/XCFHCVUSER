package com.xcfh.usermanager.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by zhangfan on 2014/10/13.
 */
@Entity
@Table(name = "tb_userinfo", schema = "", catalog = "xcfh")
public class TbUserinfoEntity {
    private String uId;
    private String etPersionName;
    private String etWorkCompany;
    private String etWorkStation;
    private String etWorkPartment;
    private String etWorkNumber;
    private String etBank;
    private String etBankNumber;
    private String etEmail;
    private String etSpTm;
    private String companyId;
    private String etPersionIphone;
    private Timestamp etTimstep;

    @Id
    @Column(name = "u_id", nullable = false, insertable = true, updatable = true, length = 32)
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "et_persion_name", nullable = true, insertable = true, updatable = true, length = 350)
    public String getEtPersionName() {
        return etPersionName;
    }

    public void setEtPersionName(String etPersionName) {
        this.etPersionName = etPersionName;
    }

    @Basic
    @Column(name = "et_work_company", nullable = true, insertable = true, updatable = true, length = 700)
    public String getEtWorkCompany() {
        return etWorkCompany;
    }

    public void setEtWorkCompany(String etWorkCompany) {
        this.etWorkCompany = etWorkCompany;
    }

    @Basic
    @Column(name = "et_work_station", nullable = true, insertable = true, updatable = true, length = 350)
    public String getEtWorkStation() {
        return etWorkStation;
    }

    public void setEtWorkStation(String etWorkStation) {
        this.etWorkStation = etWorkStation;
    }

    @Basic
    @Column(name = "et_work_partment", nullable = true, insertable = true, updatable = true, length = 350)
    public String getEtWorkPartment() {
        return etWorkPartment;
    }

    public void setEtWorkPartment(String etWorkPartment) {
        this.etWorkPartment = etWorkPartment;
    }

    @Basic
    @Column(name = "et_work_number", nullable = true, insertable = true, updatable = true, length = 350)
    public String getEtWorkNumber() {
        return etWorkNumber;
    }

    public void setEtWorkNumber(String etWorkNumber) {
        this.etWorkNumber = etWorkNumber;
    }

    @Basic
    @Column(name = "et_bank", nullable = true, insertable = true, updatable = true, length = 700)
    public String getEtBank() {
        return etBank;
    }

    public void setEtBank(String etBank) {
        this.etBank = etBank;
    }

    @Basic
    @Column(name = "et_bank_number", nullable = true, insertable = true, updatable = true, length = 350)
    public String getEtBankNumber() {
        return etBankNumber;
    }

    public void setEtBankNumber(String etBankNumber) {
        this.etBankNumber = etBankNumber;
    }

    @Basic
    @Column(name = "et_email", nullable = true, insertable = true, updatable = true, length = 350)
    public String getEtEmail() {
        return etEmail;
    }

    public void setEtEmail(String etEmail) {
        this.etEmail = etEmail;
    }

    @Basic
    @Column(name = "et_sp_tm", nullable = true, insertable = true, updatable = true, length = 30)
    public String getEtSpTm() {
        return etSpTm;
    }

    public void setEtSpTm(String etSpTm) {
        this.etSpTm = etSpTm;
    }

    @Basic
    @Column(name = "companyId", nullable = true, insertable = true, updatable = true, length = 50)
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "et_persion_iphone", nullable = true, insertable = true, updatable = true, length = 15)
    public String getEtPersionIphone() {
        return etPersionIphone;
    }

    public void setEtPersionIphone(String etPersionIphone) {
        this.etPersionIphone = etPersionIphone;
    }

    @Basic
    @Column(name = "et_timstep", nullable = true, insertable = true, updatable = true)
    public Timestamp getEtTimstep() {
        return etTimstep;
    }

    public void setEtTimstep(Timestamp etTimstep) {
        this.etTimstep = etTimstep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbUserinfoEntity that = (TbUserinfoEntity) o;

        if (companyId != null ? !companyId.equals(that.companyId) : that.companyId != null) return false;
        if (etBank != null ? !etBank.equals(that.etBank) : that.etBank != null) return false;
        if (etBankNumber != null ? !etBankNumber.equals(that.etBankNumber) : that.etBankNumber != null) return false;
        if (etEmail != null ? !etEmail.equals(that.etEmail) : that.etEmail != null) return false;
        if (etPersionIphone != null ? !etPersionIphone.equals(that.etPersionIphone) : that.etPersionIphone != null)
            return false;
        if (etPersionName != null ? !etPersionName.equals(that.etPersionName) : that.etPersionName != null)
            return false;
        if (etSpTm != null ? !etSpTm.equals(that.etSpTm) : that.etSpTm != null) return false;
        if (etTimstep != null ? !etTimstep.equals(that.etTimstep) : that.etTimstep != null) return false;
        if (etWorkCompany != null ? !etWorkCompany.equals(that.etWorkCompany) : that.etWorkCompany != null)
            return false;
        if (etWorkNumber != null ? !etWorkNumber.equals(that.etWorkNumber) : that.etWorkNumber != null) return false;
        if (etWorkPartment != null ? !etWorkPartment.equals(that.etWorkPartment) : that.etWorkPartment != null)
            return false;
        if (etWorkStation != null ? !etWorkStation.equals(that.etWorkStation) : that.etWorkStation != null)
            return false;
        if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId != null ? uId.hashCode() : 0;
        result = 31 * result + (etPersionName != null ? etPersionName.hashCode() : 0);
        result = 31 * result + (etWorkCompany != null ? etWorkCompany.hashCode() : 0);
        result = 31 * result + (etWorkStation != null ? etWorkStation.hashCode() : 0);
        result = 31 * result + (etWorkPartment != null ? etWorkPartment.hashCode() : 0);
        result = 31 * result + (etWorkNumber != null ? etWorkNumber.hashCode() : 0);
        result = 31 * result + (etBank != null ? etBank.hashCode() : 0);
        result = 31 * result + (etBankNumber != null ? etBankNumber.hashCode() : 0);
        result = 31 * result + (etEmail != null ? etEmail.hashCode() : 0);
        result = 31 * result + (etSpTm != null ? etSpTm.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (etPersionIphone != null ? etPersionIphone.hashCode() : 0);
        result = 31 * result + (etTimstep != null ? etTimstep.hashCode() : 0);
        return result;
    }
}
