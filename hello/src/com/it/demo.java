package com.it;

import javax.lang.model.util.Elements;
import java.lang.annotation.Target;
import java.util.Random;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1,2,3,4,6,7,8,9};
        System.out.println("请输入数字：");
        int target = sc.nextInt();
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                System.out.println("找到了" + i);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("没有找到");
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > target){
                    System.out.println(i);
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}