package com.zrl.Applet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import sun.applet.AppletAudioClip;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *@autho  zhengruilong
 *@date 2020-03-18
 */

public class applet extends Applet {

//制作杨辉三角
    int rows;
    public static long fac(int n) {
        long rac = 1;
        for (int k = 2; k < n; k++) {
            rac = k * rac;

        }
        return rac;
    }
   public  static  long com(int n ,int m){
        return  fac(n)/(fac(n-m)*fac(n));
   }

    @Override
    public void init() {
         rows = Integer.parseInt(getParameter("num"));
    }


    public void paint(Graphics graphics){
//      graphics.drawString("你好",2,120);

        int x,y=10;
        for (int n=0;n<rows;n++){
            x=10;
            for (int m=0;m<=n;m++){
                graphics.drawString(""+com(n,m),x,y);
                x=x+40;

            }
            y=y+20;
        }


    }





    public void update(Graphics graphics) {


//            Image image = getImage(new URL(""), "");
//            Graphics graphics = image.getGraphics();
//     graphics.drawImage();

//        AppletAudioClip appletAudioClip= null;
//        try {
//            appletAudioClip = new AppletAudioClip(new URL("D:/前端视频/6_Ajax/Ajax-day01/Ajax_Day01_am.mp4"));
//            appletAudioClip.play();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }


    }




    public static void main(String[] args) {


    }
}
