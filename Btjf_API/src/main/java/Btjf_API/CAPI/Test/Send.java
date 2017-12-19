package Btjf_API.CAPI.Test;

import java.util.ArrayList;

/**
 * Created by wl on 2016/11/29.
 */
public class Send {

    int i ;
    int y;
    public Send init(){
         y = i++;
        return this;
    }
    public static void main(String[] args){
//        System.out.println("-------------test is ending---------------");
//        String s1 ="java" ;
//        String s3 = "va";
//        String s2 = "ja"+s3;
//        int s1 = 3;
//        int s3 = 2;
//        int s2 = 1 +s3;
//
//        System.out.println(s1==s2);
//        System.out.println(s1.equals(s2));
        Send send = new Send();
        send.init()
                .init()
                .init();
        System.out.println(send.y);


    }
}
