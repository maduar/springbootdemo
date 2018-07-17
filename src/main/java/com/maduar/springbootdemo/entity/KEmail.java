package com.maduar.springbootdemo.entity;

import javax.persistence.*;

/*
 *
 * @author maduar
 * @date 17/07/2018 7:20 PM
 * @email maduar@163.com
 *
 * */
@Entity
@Table(name = "k_email", schema = "test", catalog = "")
public class KEmail {

    private Integer kid;
    private String kemail;
    private Integer tId;


    @Id
    @Column(name = "k_id", nullable = false)
    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    @Basic
    @Column(name = "k_email", nullable = true, length = 255)
    public String getKemail() {
        return kemail;
    }

    public void setKemail(String kemail) {
        this.kemail = kemail;
    }

    @Basic
    @Column(name = "t_id", nullable = true)
    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }


}
