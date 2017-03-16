package com.codyy.data.test;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        
         
         
//         String xids  = Joiner.on("'").on(",").on("'").join(new Integer[] {1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31});
         StringBuffer sb2 = new StringBuffer("");
         for(int i = 0;i<25 ;i++){
             sb2.append("'").append(i).append("',");
         }
         System.out.println(sb2.toString());
         
         StringBuffer sb = new StringBuffer("");
//         double d = 0.10;
//         for(int i = 0 ;i<25 ;i++){
//             d = (d + 0.20) * 102000;
//             if(d > 0.80){
//                 d = d - 0.21 * 102000;
//             }
//             sb.append(d + ",");
//         }
//         System.out.println(sb.toString());
         
         Random rand =new Random(102);
         for(int i = 0 ;i<25 ;i++){
             int k = rand.nextInt(10200 );
             if(k < 0 ){
                 k = k * (-1);
             }
             System.out.print(k + ","); 
         }
         
         System.out.println(4131.48 * 24);
          
    }

}
