package com.company;
import java.awt.*;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        com.company.Draw draw = new com.company.Draw();
        JFrame f = new JFrame();

        com.company.GraphicsPrimitives gp = new com.company.GraphicsPrimitives();

        f.add(draw);
        f.setSize(1000,800);
        f.setVisible(true);
    }
}
