package com.kn.test;

public class N的阶剩 {

    public static void main(String[] args) {
        int x = 0; //假设一层有x环
        while(true){
            ++x;
            if (等差数列求和(x + 1, 2 * x) -等差数列求和(1, x) == 729) {
                break;
            }
        }
        Integer sum = 等差数列求和(1,3 * x);//3402
        System.out.println(sum);
    }

    //求n的阶剩
    public static Integer 等差数列求和(Integer start, Integer stop) {
        Integer sum = 0;
        /*for (int i = 1; i <= n; i++) {
            n的阶和 += i;
        }*/
        //和=(首项+末项)×项数÷2
        sum = (start + stop) * (stop - start + 1) / 2 * 9;
        return sum;
    }

}
