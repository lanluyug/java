package com.lanluyug.springInAction.ch02.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // 自动扫描本包（soundsystem）中的bean
/*
    其他几种引入形式
    @ComponentScan("soundsystem") //自动扫描soundsystem
    @ComponentScan(basePackages = "soundsystem")
    @ComponentScan(basePackages = {"soundsystem", "video"})
    @ComponentScan(basePackageClasses = {SgtPeppers.class}
 */

public class CDPlayerConfig {
}
