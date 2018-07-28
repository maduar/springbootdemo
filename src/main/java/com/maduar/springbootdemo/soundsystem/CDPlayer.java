package com.maduar.springbootdemo.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 21/07/2018 6:04 PM
 * @email maduar@163.com
 *
 * */
@Component
public class CDPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
