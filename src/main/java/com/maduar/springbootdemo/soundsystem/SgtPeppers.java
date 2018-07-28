package com.maduar.springbootdemo.soundsystem;

import org.springframework.stereotype.Component;

/*
 *
 * @author maduar
 * @date 21/07/2018 5:50 PM
 * @email maduar@163.com
 *
 * */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt, Pepper's Lonely Hearts club band";
    private String artist = "the beatles";

    @Override
    public void play() {
        System.out.println("palying " + title + " by " + artist);
    }
}
