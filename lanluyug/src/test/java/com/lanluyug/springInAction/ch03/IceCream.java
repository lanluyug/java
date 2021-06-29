package com.lanluyug.springInAction.ch03;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("iceCream")
@Primary//处理二义性，当DI出现两个实现类时，优先选择@Primary实现类
public class IceCream implements Dessert{

    String name = "IceCream";
}
