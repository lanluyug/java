package com.lanluyug.lanluyug.javaLogic.enumDemo;

import org.junit.jupiter.api.Test;

public class TestMain {
    @Test
    void testBase(){
        SpecialTables specialTables = SpecialTables.tb_special_app;
        System.out.printf("specialTables.toString() = %s\n",specialTables.toString());
        System.out.printf("specialTables.name() = %s\n",specialTables.name());
        // 枚举类的声明顺序
        System.out.printf("tb_special_app枚举类的声明(ordinal() )顺序: %d\n",specialTables.ordinal());

        //枚举类compareTo比较的是ordinal的大小，既是枚举类声明的顺序
        System.out.println("枚举类compareTo比较的是ordinal的大小，既是枚举类声明的顺序...........");
        System.out.printf("specialTables.compareTo(SpecialTables.tb_special_app) = %d\n",
                specialTables.compareTo(SpecialTables.SMALL));

        // 遍历枚举类
        System.out.println("遍历枚举类..................");
        for (SpecialTables sp: SpecialTables.values()
             ) {
            System.out.printf("Values = %s\n", sp);
        }

        // 实体枚举类
        System.out.println("实体枚举类...............");
        RealTables app = RealTables.APP;
        System.out.printf("appName: %s\n",app.getName());
        System.out.printf("appLabel: %s\n",app.getLabel());

    }
}
