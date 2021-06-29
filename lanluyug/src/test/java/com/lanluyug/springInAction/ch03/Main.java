package com.lanluyug.springInAction.ch03;

import com.lanluyug.springInAction.ch02.soundsystem.CDPlayerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 自动创建spring应用上下文
@Configuration
@ComponentScan(basePackageClasses = {Main.class})
@ContextConfiguration(classes = Main.class) //加载配置
public class Main {

    private Dessert dessert;

    @Autowired
//    @Qualifier("iceCream") // 处理二义性，当DI出现两个实现类时，指定选择ID，此时ID为首字母小写的类名
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }

    @Test
    public void test(){
        System.out.println("\n" + (null== dessert));
    }


    // SpEL: Spring Expression Language
    @Value("#{3.14}")
    double pi;

    // 逻辑运算：not, and, or , |
    @Value("#{not ((false and true) or false)}")
    boolean flag;

    // 比较运算：< > == <= >=    lt gt eq le ge
    @Value("#{1 eq 2}")
    boolean compareFlag;

    @Value("#{T(System).currentTimeMillis()}")
    long now;

    @Value("#{T(java.lang.Math).PI}")
    double PI;

    @Value("#{disc1 ?: 'title为空'}")
    String title;

    @Test
    public void testDouble(){
        System.out.println("\n\n" + pi + "\n\n");
    }
    @Test
    public void testBoolean(){
        System.out.println("\n\n" + flag + "\n\n");
    }
    @Test
    public void testCompareBoolean(){
        System.out.println("\n\n" + compareFlag + "\n\n");
    }

    @Test
    public void testFunction(){
        System.out.println("\n\n" + now + "\n\n");
    }

    @Test
    public void testBeanProperties(){
        System.out.println("\n\n" + PI + "\n\n");
    }

    @Test
    public void testWhetherNull(){
        System.out.println("\n\n" + title + "\n\n");
    }
}
