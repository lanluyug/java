package com.lanluyug.springInAction.ch02.soundsystem;

import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub") //括号内可自定义组件ID
public class SgtPeppers implements CompactDisc{

    String title = "Sgt. Pepper's Lonely hearts Club Band";
    String artist = "The Beatles";

    @Override
    public String play(){
        String action = "Playing " + title + " by " + artist;
        System.out.println(action);
        return action;
    }
}
