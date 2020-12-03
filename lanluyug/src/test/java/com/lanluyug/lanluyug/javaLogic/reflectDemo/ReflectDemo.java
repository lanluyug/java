package com.lanluyug.lanluyug.javaLogic.reflectDemo;

import net.minidev.json.annotate.JsonIgnore;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.*;

/**
 * 反射机制会消耗一些性能去查找相应的成员，
 * 若接口能实现相应功能，优先使用接口
 */
public class ReflectDemo {

    @Test
    @JsonIgnore
    public void testClass(){
        /**
         * 反射：运行时，动态获取类型的信息：比如接口信息、成员信息、方法信息，构造方法信息等；
         * 可通过上述信息获取信息的创建对象、访问/修改成员、调用方法；
         * 反射的入口是Class类
         */


        // To get Class object is not necessary to new a instance

        Class<Date> cls = Date.class;

        // interface has .class

        Class<Comparable> clsI = Comparable.class;

        // primitive type can use .class
        // but generic should be box Object to obtain Class
        Class<Integer> intCls = int.class;

        // void has .class
        Class<Void> voidClass = void.class;

        // Object with generic
        // array getName start with [
        // and count of [ is dimension of array
        String[][] strArr = new String[10][10];
        Class<? extends String[][]> strClass = strArr.getClass();
        System.out.println("String[][]'s getName = "+strClass.getName());


        // static forName,load Class refer to className
        try {
            Class<?> clsForName = Class.forName("java.util.HashMap");
            System.out.println("getName: "+clsForName.getName());
            System.out.println("getSimpleName: "+clsForName.getSimpleName());
            System.out.println("getCanonicalName: "+clsForName.getCanonicalName());
            System.out.println("getPackage: "+clsForName.getPackage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testField(){

        //get Fields
        List<String> obj = Arrays.asList(new String[]{"lanluyu","coding"});
        Class<?> clsObj = obj.getClass();
        for(Field f: clsObj.getDeclaredFields()){
            f.setAccessible(true);
            try {
                System.out.println(f.getName()+ " - "+ f.get(obj));
                System.out.println("getModifiers - "+ Modifier.toString(f.getModifiers()));
                System.out.println("getModifiers isFinal- "+ Modifier.isFinal(f.getModifiers()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testMethod(){
        Class<?> cls = Integer.class;
        try {
            Method method = cls.getMethod("parseInt", new Class[]{String.class});
            // 当method为静态方法时，invoke第一个参数可以为null
            System.out.println(method.invoke(null, "123"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConstruct(){

        //获取默认实例
        try {
            Map<String, Integer> map = HashMap.class.newInstance();
            map.put("hello", 123);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 获取指定构造函数
        try {
            Constructor<StringBuilder> constructor = StringBuilder.class
                    .getConstructor(new Class[]{int.class});
            StringBuilder sb = constructor.newInstance(100);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testValidate(){

        try {
            Class cls = Class.forName("java.util.ArrayList");
            List<String> list = new ArrayList();
            list.add("array list");
            if(cls.isInstance(list)){
                ArrayList arrayList = (ArrayList)list;
                System.out.println(arrayList.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //检查当前能否赋值给Class类型
        System.out.println(" Object.class.isAssignableFrom(String.class) ---" +
                Object.class.isAssignableFrom(String.class));
        System.out.println("String.class.isAssignableFrom(String.class)-----"+
                String.class.isAssignableFrom(String.class));
        System.out.println("List.class.isAssignableFrom(ArrayList.class)----"+
                List.class.isAssignableFrom(ArrayList.class));
    }

    @Test
    public void testType(){

        Class cls = List.class;

        System.out.println("是否是数组："+cls.isArray());
        System.out.println("是否是基本类型："+cls.isPrimitive());// 基本类型
        System.out.println("是否是接口："+cls.isInterface());
        System.out.println("是否是枚举："+cls.isEnum());
        System.out.println("是否是注解："+cls.isAnnotation());
        System.out.println("是否是匿名内部类："+cls.isAnonymousClass());
        System.out.println("是否是成员类（定义在方法外）："+cls.isMemberClass());
        System.out.println("是否是本地类（定义在方法内）："+cls.isLocalClass());
    }

    @Test
    public void testGeneric(){
        Class<?> cls = GenericTest.class;
        //类的参数类型
        for (TypeVariable t : cls.getTypeParameters()){
            System.out.println(t.getName() + " extends "
            + Arrays.toString(t.getBounds()));
        }

        try {
            // 字段：泛型类型
            Field fu = cls.getDeclaredField("u");
            System.out.println(fu.getGenericType());

            //字段：参数化类型
            Field flist = cls.getDeclaredField("list");
            Type listType = flist.getGenericType();
            if(listType instanceof ParameterizedType){
                ParameterizedType pType = (ParameterizedType)listType;
                System.out.println("raw type: " + pType.getRawType() +
                        ",type arguments: " +
                        Arrays.toString(pType.getActualTypeArguments()));
            }
            // 方法的泛型参数
            Method m = cls.getMethod("test", new Class[]{List.class});
            for (Type t : m.getGenericParameterTypes()){
                System.out.println(t);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    class GenericTest<U extends Comparable<U>, V>{
        U u;
        V v;
        List<String> list;
        public U test(List<? extends Number> numbers){
            return null;
        }
    }
}
