package com.lanluyug.springInAction.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource("classpath:/com/lanluyug/springInAction/ch03/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment environment;

//    @Bean
//    public String getTitleAndArtist(){
//        return "title: " + environment.getProperty("disc.title")
//                +"\nartist: " + environment.getProperty("disc.artist");
//    }
}
