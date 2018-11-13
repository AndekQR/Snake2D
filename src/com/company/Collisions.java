package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Collisions extends JPanel{

    private Snake snakeObject;
    private int xOfApple;
    private int yOfApple;

    public Collisions(Snake object){
        this.snakeObject = object;
        this.apple();
    }

    private void apple(){
        Random random = new Random();
        xOfApple = random.nextInt(39);
        yOfApple = random.nextInt(39);
        snakeObject.siatka[xOfApple][yOfApple].setBackground(Color.YELLOW);
    }

    public boolean checkCollision(){
        if (xOfApple == snakeObject.xPositionOfHead && yOfApple == snakeObject.yPositionOfHead){
            apple();
            return true;
        }
        return false;
    }

}
