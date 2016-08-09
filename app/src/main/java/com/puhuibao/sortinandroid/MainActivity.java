package com.puhuibao.sortinandroid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtProductNum, txtResultNum, txtTime;
    private int[] mAa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtProductNum = (TextView) this.findViewById(R.id.txt_number);
        txtResultNum = (TextView) this.findViewById(R.id.txt_result);
        txtTime = (TextView) this.findViewById(R.id.txt_time);

    }

    public void click(View view) {

        int id = view.getId();
        switch (id){

            case R.id.btn_product:
                mAa = productNumber();
                int[] bb = mAa;
                txtProductNum.setText(Arrays.toString(bb));
                break;
            case R.id.btn_result:
                break;
            case R.id.btn_sort_maopao:
                int[] cc = mAa;
               txtResultNum.setText(maoPaoSort(cc));
                break;
            case R.id.btn_sort_choice:
                int[] dd = mAa;
                txtResultNum.setText(choiceSort(dd));
                break;
            case R.id.btn_sort_quick:
                int[] ff = mAa;
                quickSort(mAa,0,mAa.length-1);
                txtResultNum.setText(Arrays.toString(ff));
                break;
        }
    }

    /**
     *  返回一个10个数的字符串
     * @return
     */
    private int[] productNumber(){

        Random random = new Random();
        int[]  arr = new int[10];
        for(int index = 0; index < arr.length; index++){
            arr[index] = random.nextInt(100)+1;
        }
        return arr;
    }

    /**
     *    冒泡排序  第一个和第二个, 第二个和三个比较, 最值在最上面;
     * @param arr
     * @return
     */
    private String maoPaoSort(int[] arr){

        for(int i = 0 ; i < arr.length-1 ; i++){

            for(int j = 0; j < arr.length-i-1 ; j++){

                if(arr[j]  > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return Arrays.toString(arr);
    }

    /**
     *    选择排序   第一个和第二个比较,和第三个比较,和第四个比较;  最值在最低位;
     * @param arr
     * @return
     */
    private String choiceSort(int[] arr){

        for(int i = 0;  i < arr.length-1 ; i ++){

            for(int j = i+1; j < arr.length ; j++){

                if(arr[i] > arr[j]){

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                 }
            }
        }
        return Arrays.toString(arr);
    }

    /**
     *    快速排序  :  选择基准元素, 右边大于基准元素,左边小于基准元素
     * @param arr
     * @param low
     * @param height
     * @return
     */
    private void quickSort(int[] arr,int left , int right){

        if(left < right){

            int low = left;    // 必须让left和right的值不能改变;
            int high = right;
            int a = arr[low];

            while(low < high){

                while (low < high && arr[high] >= a){

                   high--;
                }
                if(low < high){
                    arr[low] = arr[high];
                    low++;    //比较基准元素后,向左移动一位;
                }

                while (low < high && arr[low] <= a){

                    low++;    //比较基准元素后,向右移动一位;
                }
                if(low < high){
                    arr[high] = arr[low];
                    high--;
                }
            }

            arr[low]  = a;    // 一次排序完成后, 必须将基准元素赋值给低位;

            quickSort(arr,left,high-1);
            quickSort(arr,high+1,right);
        }

    }

}
