# SortInAndroid
三种排序算法:2016-8-9-24:46

算法技巧：

冒泡排序：第一次： 第一个和第二个比较，第二个和第三个比较。
          第二次： 比较到n-1次；
         
选择排序 ：第一次: 第一个和第二个比较，第一个和第三个比较，第一个和第四个比较.
          第二次 ： 从第二个开始比较；
          
  
快速排序： 第一步：  取低位为基准元素，分别从两边和基准元素比较，高位数字大于基准元素，低位元素小于基准元素，如果不成立，则交换位置。
            第二步:  在第一次停止后低位元素的左边进行快速排序。
            第三部： 在第一次停止后高位元素的右边进行快速排序。
            

稳定排序概念： 2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同。


冒泡和选择是稳定的，，快速排序是不稳定的。