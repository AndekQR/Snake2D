package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background extends JPanel {
//    private BufferedImage tlo, brick;
//    private int xBrick= 0, yBrick= 0;
//    private boolean isEnd = false;
//
//    public Background(){
//        tlo();
//    }
//
//    private void tlo(){
//        this.setLayout(new GridBagLayout());
//        File imageFile = new File("leaves-pattern.png");
//        File brickFile = new File("brick2.png");
//        try {
//            tlo = ImageIO.read(imageFile);
//            brick = ImageIO.read(brickFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("tlo"+tlo.getData().toString());
//        System.out.println("brick"+brick.getData().toString());
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 =(Graphics2D) g;
//
//        while(!isEnd){
//            if (xBrick == 0){
//                g2.drawImage(brick, 0, yBrick, null);
//                g2.drawImage(brick, 750, yBrick,null);
//                yBrick = yBrick + 40;
//                if (yBrick>=800)
//                    xBrick = xBrick+40;
//            }
//            else if (isEnd == false){
//                g2.drawImage(brick, xBrick, 0, null);
//                g2.drawImage(brick, xBrick, 750, null);
//                xBrick = xBrick+40;
//                if (xBrick+80 >800)
//                    isEnd = true;
//            }
//
//
//
//        }
//    }



}
