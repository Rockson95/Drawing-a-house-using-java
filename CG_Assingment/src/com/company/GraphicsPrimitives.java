package com.company;

import java.applet.Applet;
import java.awt.*;


public class GraphicsPrimitives extends Applet
{
    public  void vertEllipse (int xc, int yc, int r, Graphics g)
    {
        int x0 = 0;
        int y0 = r;

        int p0 = (5/4) - r;
        int tx = 2 * x0;
        int ty = 2 * y0;

        while(x0 <= y0)
        {
            //sectors
            g.drawString(".", xc + x0, 2 * (yc - y0));//1st clockwise
            g.drawString(".", xc + y0, 2 * (yc - x0));//2nd clockwise
            g.drawString(".", xc + y0, 2 * (yc + x0));//3rd clockwise
            g.drawString(".", xc + x0, 2 * (yc + y0));//4th clockwise
            g.drawString(".", xc - x0, 2 * (yc + y0));//5th clockwise
            g.drawString(".", xc - y0, 2 * (yc + x0));//6th clockwise
            g.drawString(".", xc - y0, 2 * (yc - x0));//7th clockwise
            g.drawString(".", xc - x0, 2 * (yc - y0));//8th clockwise

            if (p0 < 0)
            {
                x0++;
                p0 = p0 + ((2 * x0) + 2) + 1;
            }
            else
            {
                x0++;
                y0--;
                p0 = p0 + ((2 * x0) + 2) + 1 - ((2 * y0) - 2);
            }
        }

    }

    public void hEllipse(int centerx,int centery,int r,Graphics g)
    {
        int xo=0;
        int yo=r;

        int rad=r*2;
        int d=rad/r;

        int Po=(5/4)-r;

        int xc=centerx;
        int yc=centery;

        while(xo<yo)
        {
            //sectors
            g.drawString(".",d*(xc+xo),yc-yo);//1st clockwise
            g.drawString(".",d*(xc+yo),yc-xo);//2nd clockwise
            g.drawString(".",d*(xc+yo),yc+xo);//3rd clockwise
            g.drawString(".",d*(xc+xo),yc+yo);//4th clockwise
            g.drawString(".",d*(xc-xo),yc+yo);//5th clockwise
            g.drawString(".",d*(xc-yo),yc+xo);//6th clockwise
            g.drawString(".",d*(xc-yo),yc-xo);//7th clockwise
            g.drawString(".",d*(xc-xo),yc-yo);//8th clockwise

            if(Po<0)
            {
                xo++;
                Po=Po+((2*xo)+2)+1;
            }
            else
            {
                xo++;
                yo--;
                Po=Po+((2*xo)+2)+1-((2*yo)-2);
            }
        }
    }

    public void circle(int xc, int yc, int r, Graphics g)
    {
        int x0 = 0;
        int y0 = r;
        int p0 = (5/4) - r;
        int tx = 2 * x0;
        int ty = 2 * y0;

        while(x0 <= y0)
        {
            g.drawString("o", xc + x0, yc - y0);//1st arc clockwise
            g.drawString("o", xc + y0, yc - x0);//2nd arc clockwise
//            g.drawString(".", xc + y0, yc + x0);//3rd arc clockwise
//            g.drawString(".", xc + x0, yc + y0);//4th arc clockwise
//            g.drawString(".", xc - x0, yc + y0);//5th arc clockwise
//            g.drawString(".", xc - y0, yc + x0);//6th arc clockwise
            g.drawString("o", xc - y0, yc - x0);//7th arc clockwise
            g.drawString("o", xc - x0, yc - y0);//8th arc clockwise

            if(p0 < 0)
            {
                x0++;
                p0 = p0 + ((2 * x0) + 2) + 1;
            }
            else
            {
                x0++;
                y0--;
                p0 = p0 + ((2 * x0) + 2) + 1 - ((2 * y0) - 2);
            }
        }
    }

    public void positiveLine(int a, int b, int a1, int b1, Graphics g)
    {
        int x1=a;
        int y1=b;
        int x2=a1;
        int y2=b1;
        int dx=x2-x1;
        int dy=y2-y1;
        int tdx=-5*dx;
        int tdy=2*dy;
        int p=2*dy-dx;

        for(int k=0;k<dx;k++)
        {
            g.drawString("o",x1,y1);
            if(p<0)
            {
                x1++;
                p=tdy-dx;
            }
            else
            {
                x1++;
                y1++;
                p=p+tdy-tdx;
            }
        }
    }

    public void bresenhamLineAlgorithmLow(int x1, int y1, int x2, int y2, Graphics g) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int yi = 1;
        if (dy < 0) {
            yi = -1;
            dy = -dy;
        }
        int D = (2 * dy) - dx;
        int y = y1;

        for (int x = x1; x <= x2; x++) {
            g.fillOval(x, y, 10, 10);

            if (D > 0) {
                y = y + yi;
                D = D + (2 * (dy - dx));
            } else {
                D = D + (2 * dy);
            }
        }
    }

    public void bresenhamLineAlgorithmHigh(int x1, int y1, int x2, int y2, Graphics g) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int xi = 1;
        if (dx < 0) {
            xi = -1;
            dx = -dx;
        }
        int D = (2 * dx) - dy;
        int x = x1;

        for (int y = y1; y <= y2; y++) {
            g.fillOval(x, y, 10, 10);

            if (D > 0) {
                x = x + xi;
                D = D + (2 * (dx - dy));
            } else {
                D = D + (2 * dx);
            }
        }
    }

    public void plotLine(int x1, int y1, int x2, int y2, Graphics g) {
        if (Math.abs(y2 - y1) < Math.abs(x2 - x1)) {
            if (x1 > x2) {
                negativeLine(x2, y2, x1, y1, g);
            } else {
                negativeLine(x1, y1, x2, y2, g);
            }
        } else {
            if (y1 > y2) {
                positiveLine(x2, y2, x1, y1, g);
            } else {
                positiveLine(x1, y1, x2, y2, g);
            }
        }
    }

    public void negativeLine(
            int a, int b, int a1, int b1, Graphics g
    )
    {
        int x1=a;
        int y1=b;
        int x2=a1;
        int y2=b1;
        int dx=x2-x1;
        int dy=y2-y1;
        int tdy=2*dy;
        int p=2*dy-dx;


        for(int k=0;k<dx;k++)
        {
            g.drawString("o",x1,y1);
            if(p<0)
            {
                x1++;
                y1--;

                p = p + tdy;
            }
            else
            {
                x1--;
                y1++;

                p=p+tdy-(2*dx);
            }
        }
    }


    public void horizontalLine(int a,int b,int a1,int b1,Graphics g)
    {
        int x1 = a;
        int y1 = b;
        int x2 = a1;
        int y2 = b1;
        int dx = x2 - x1;
        int dy = y2 - y1;
        int w = 2 * dx;
        int q = 2 * dy;
        int p = 2 * dy - dx;
        for(int k=0;k<dx;k++)
        {
            g.drawString("o",x1,y1);
            if(p<0)
            {
                x1++;
                p = q - dx;
            }
            else
            {
                x1++;
                p = p + q - w;
            }
        }
    }

    public void verticalLine(int a,int b,int a1,int b1,Graphics g)
    {
        int x1=a;
        int y1=b;
        int x2=a1;
        int y2=b1;
        int dx=x2-x1;
        int dy=y2-y1;
        int w=2*dx;
        int q=2*dy;
        int p=2*dy-dx;

        for(int k=0;k<dy;k++)
        {
            g.drawString("o",x1,y1);
            if(p<0)
            {
                x1 ++;
                p=q-dx;
            }
            else
            {
                y1++;
                p=p+q-w;
            }
        }
    }
}