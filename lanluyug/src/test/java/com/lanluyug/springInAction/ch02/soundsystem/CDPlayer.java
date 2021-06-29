package com.lanluyug.springInAction.ch02.soundsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CDPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Autowired //构造器注入
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }
    @Autowired(required = false) //set注入,
    // 当设置required为false时，未找到bean会处于未装配状态，但是后续使用该属性可能会NPE
    public void setCd(CompactDisc cd){
        this.cd = cd;
    }
    @Override
    public void play(){
        cd.play();
    }
}
