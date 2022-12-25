package com.company;

import java.applet.Applet;
import java.awt.*;

public class Draw extends Applet {
    Thread t=new Thread();

    public void init()
    {
        super.init();
        resize(1350,650);
        setBackground(Color.white);
    }

    public void run()
    {
        t.start();
    }

    //instance
    com.company.GraphicsPrimitives gp = new com.company.GraphicsPrimitives();//instance of the primitives

    public void paint(Graphics g)
    {

        gp.negativeLine(200,300,400,100,g);
        gp.positiveLine(400,100,475,150,g);
        gp.verticalLine(475,145,475,175, g);
        gp.horizontalLine(475,145,525,145, g);
        gp.verticalLine(525,145,525,230, g);
        gp.positiveLine(525,230,600,270, g);
        gp.negativeLine(580,320,595,310, g);
        gp.verticalLine(250, 295, 300, 450, g);
        gp.verticalLine(550, 295, 300, 450, g);
        gp.verticalLine(375, 360, 375, 450, g);
        gp.verticalLine(425,360,425,450, g);
        gp.horizontalLine(250, 450, 550, 450, g);
        gp.negativeLine(220,320,400,100,g);
        gp.positiveLine(400,140,580,300,g);
        gp.circle(400,360,25, g);
        gp.positiveLine(200,300,220,320, g);

    }
}
