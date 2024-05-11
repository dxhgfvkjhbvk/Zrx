package com.exer2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName: PrivateTest
 * Package: com.exer2
 * Description:
 *1.定义PrivateTest类，有私有name属性，并且属性值为hellokitty
 * 2.提供getName的公有方法
 * 3.创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name的属性值
 * @Author 李佳豪
 * @Create 2024/5/11 19:39
 * @Version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) throws Exception {
        //1.得到 PrivateTest类对应的Class对象
        Class<PraivateTest> praivateTestClass = PraivateTest.class;
        //2.创建对象实例
        PraivateTest praivateTest = praivateTestClass.newInstance();
        //3.得到name属性对象
        Field name = praivateTestClass.getDeclaredField("name");
        //4.爆破name
        name.setAccessible(true);
        name.set(praivateTest,"天龙八部");
        //5.得到getName方法对象
        Method getName = praivateTestClass.getMethod("getName");
        Object invoke = getName.invoke(praivateTest);
        System.out.println("name属性值 " + invoke);//天龙八部

    }
}

class PraivateTest{
    private String name = "hellokitty";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}