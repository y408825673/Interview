package com.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ModelAtom implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer validflag = 1;

    public ModelAtom(){
        validflag = 1;
    }

    @Column(name="ValidFlag")
    public Integer getValidflag() {
        return validflag;
    }

    public void setValidflag(Integer validflag) {
        this.validflag = validflag;
    }


}
