package com.Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Model extends ModelAtom {
    private static final long serialVersionUID = 1L;
    @Column(name="Creator")
    private String creator = "sys";
    @Column(name="DateOfCreate")
    private Date dateOfCreate = new Date();
    @Column(name="Updater")
    private String updater = "sys";
    @Column(name="DateOfUpdate")
    private Date dateOfUpdate = new Date();
    @Column(name="Memo")
    private String memo = "";

    public Model() {}

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }


    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }



}
