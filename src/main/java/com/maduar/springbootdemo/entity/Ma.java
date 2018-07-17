package com.maduar.springbootdemo.entity;

/*
 *
 * @author maduar
 * @date 17/07/2018 8:01 PM
 * @email maduar@163.com
 *
 * */
public class Ma {

    private Integer tId;
    private String kemail;

    public Integer gettId() {
        return tId;
    }

    public Ma() {
    }

    public void settId(Integer tId) {

        this.tId = tId;
    }

    public String getKemail() {
        return kemail;
    }

    public void setKemail(String kemail) {
        this.kemail = kemail;
    }

    public Ma(Integer tId, String kemail) {

        this.tId = tId;
        this.kemail = kemail;
    }
}
