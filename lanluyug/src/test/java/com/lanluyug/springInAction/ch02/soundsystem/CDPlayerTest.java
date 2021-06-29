package com.lanluyug.springInAction.ch02.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class) // 自动创建spring应用上下文
@ContextConfiguration(classes = CDPlayerConfig.class) //加载配置
public class CDPlayerTest {

    @Autowired // 将bean注入
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);
    }
    @Test
    public void play(){
//        assertEquals("Playing Sgt. Pepper's Lonely hearts Club Band by The Beatles",);
        player.play();
    }
}
