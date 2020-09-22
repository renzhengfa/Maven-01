package com.kn.test;

import com.kn.bean.Act_id_user;

import java.util.HashSet;
import java.util.Set;

public class JavaBaseTest {

    public static void main(String[] args) {
//        System.out.println(3<<3);
        Act_id_user act_id_user = new Act_id_user();
        act_id_user.setID_("1111");
        act_id_user.setFIRST_("zg");
        Act_id_user act_id_user1 = new Act_id_user();
        act_id_user1.setID_("1111");
        act_id_user1.setFIRST_("zg");
        System.out.println("act_id_user: " + act_id_user);
        System.out.println("act_id_user1: " + act_id_user1);
        System.out.println("act_id_user == act_id_user1: " + (act_id_user == act_id_user1));
        System.out.println("act_id_user equals act_id_user1: " + (act_id_user.equals(act_id_user1)));

        System.out.println("------------------------------------------------------------------------------------------");
        String a = "abcde123";
        String b = "abcde123";
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a == b: " + (a == b));
        System.out.println("a.equals(b):" + (a.equals(b)));

        System.out.println("------------------------------------------------------------------------------------------");
        Integer i;
//        i = 0;
//        System.out.println(i);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Math.ceil(11.3) = " + Math.ceil(11.3));
        System.out.println("Math.ceil(-11.3) = " + Math.ceil(-11.3));
//        Math.ceil():表示向上取整; Math.ceil(11.3) = 12
//        Math.floor():表示向下取整;Math.floor(11.6)=11;Math.floor(-11.6)=-12。
//        Math.round():表示四舍五入;Math.round(11.5)=12;Math.round(-11.5)=-11;Math.round(11.3)=11;Math.round(-11.3)=-11;
        System.out.println(Math.round(11.5) + " " + Math.round(-11.5) + " " + Math.round(11.3) + " " + Math.round(-11.3));

        System.out.println("------------------------------------------------------------------------------------------");
        //子类重写父类方法:方法名和参数及返回类型完全一致
        //同一个类重载方法:方法名相同,参数或返回类型不同

        System.out.println("------------------------------------------------------------------------------------------");
        String str = "abc";
        str = str + "def";
        System.out.println("str: " + str);

        System.out.println("------------------------------------------------------------------------------------------");
        Set set = new HashSet();
        Act_id_user actIdUser = new Act_id_user();
        actIdUser.setID_("1");
        actIdUser.setFIRST_("aa");
        actIdUser.setPWD_("aa123");
        Act_id_user actIdUser1 = new Act_id_user();
        actIdUser1.setID_("1");
        actIdUser1.setFIRST_("aa");
        actIdUser1.setPWD_("aa123");
        //重写hashCode()方法后两个对象虽然值一样，但是hashCode值不一样，这样两个值一样的对象都会添加到set集合
        //不重写hashCode方法时，默认用Object对象的hashCode方法比较是否一致（Object不是根据值是否一致比较的）
        //equals方法也一样,‘覆盖后使用覆盖后的方法进行比较’
        set.add(actIdUser);
        set.add(actIdUser1);
        for (Object aaa: set) {
            System.out.println(aaa);
        }
        System.out.println(set.size());
    }

}
