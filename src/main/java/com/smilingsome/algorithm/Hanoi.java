package com.smilingsome.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 递归算法解决Hanoi问题
public class Hanoi {
    public static void main(String args[]) throws Exception {
        int n;
        BufferedReader buf = 
                new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入盘数：");
        n = Integer.parseInt(buf.readLine());
        Hanoi hanoi = new Hanoi();
        hanoi.move(n, 'A', 'B', 'C');
    }

    /**
     *  问题描述：将n个盘子从a盘，借助b盘，移到c盘
     * @param n 代表n个盘子
     * @param a 盘a
     * @param b 盘b
     * @param c 盘c
     */
    public void move(int n, char a, char b, char c) {// 递归函数，无实际可操作性，容易导致栈溢出，同时时间复杂度极大
        if (n == 1)
            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
        else {
            move(n - 1, a, c, b);
            System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
            move(n - 1, b, a, c);
        }
    }
}