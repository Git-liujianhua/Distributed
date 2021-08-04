package com.atguigu.zookeeper;

import org.junit.Test;

import java.util.Arrays;

public class TestArr {

    public static int[][]  binaryMiun(int[] Arrint){
        //遍历数组求元素的总和sum
        int sum = sumArr(Arrint);
        //mid 为元素总和的一半
        int mid = sum/2;
        int suml = 0;//第一个小数组元素总和
        int sumr = 0;//第二个小数组元素的总和
        int[] l = new int[Arrint.length] ;//第一个小数组
        int[] r = new int[Arrint.length] ;//第二个小数组

        int lcount = 0;
        int rcount = 0;
        int n = Arrint.length;
        for(int h= 0; h < n;) {
            int min = mid - Arrint[0];
            int j = 0;
            //找出离mid最近的元素
            for(int i=0;i<n;i++){
                int temp = mid - Arrint[i];
                if(temp<=mid){
                    min = temp;
                    //距离mid最近的元素的下标
                    j = i;
                }
            }
            //将取出的元素放在元素总和较小的数组
            if(suml <= sumr){
                l[lcount++] = Arrint[j];
                suml += Arrint[j];

            }else{
                r[rcount++]  = Arrint[j];
                sumr += Arrint[j];
            }
        }
        n = n-1;
        int[][] lr = {Arrays.copyOf(l,lcount),Arrays.copyOf(r,rcount)};
        return lr;
    }
    /**
     * 数组求和
     * @param arr
     * @return
     */
    public static int sumArr(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

    @Test
    public void test2(){
         int[] i = {11,7,2,5,9,2,1};
        // System.out.println(sumArr(i));
        int[][] ints = binaryMiun(i);
        for (int[] is :ints){
            System.out.println(Arrays.toString(is));
        }

    }
    @Test
    public void test1(){
        // int[] aa={11,7,2,5,9,21};
        int[] aa={11,7,2,5,9,2,1};
        int[] bb = new int[0];
        int[] cc = new int[0];
        int c = 0;
        int b = 0;
        Arrays.sort(aa);

        for(int i = 0;i<aa.length ; i++){
            if(b >= c){
                c = c+aa[aa.length -1-i];
                cc =java.util.Arrays.copyOf(cc,cc.length+1);
                cc[cc.length-1] = aa[aa.length -1-i];
            }else {
                b = b+aa[aa.length -1-i];
                bb =java.util.Arrays.copyOf(bb,bb.length+1);
                bb[bb.length-1] = aa[aa.length -1-i];
            }
        }
        for (int i : bb){
            System.out.print("BB["+i+"]="+i+",");
        }
        System.out.println("================");
        for (int i : cc){
            System.out.print("CC["+i+"]="+i+",");
        }
    }
}
