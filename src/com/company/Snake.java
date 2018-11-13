package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Snake extends JPanel implements KeyListener {

    private final static int sizeOfTheNet=80;
    public int xPositionOfHead, yPositionOfHead; //publiczny dla klasy Collisions
    public JPanel[][] siatka=new JPanel[sizeOfTheNet][sizeOfTheNet];
    private boolean stillUp=false, stillDown=false, stillRight=false, stillLeft=false;
    private Timer timer=new Timer();
    private Timer timerBody=new Timer();
    private Collisions collisions;
    private long currentTime;
    private Dimension snakePanelDimension=new Dimension(800, 800);
    private int bodyLenght=0;
    private Dimension oneCellDimension=new Dimension(snakePanelDimension.width / sizeOfTheNet, snakePanelDimension.height / sizeOfTheNet);
    private ArrayList<Point> positionsOfHead;
    private int positionInTheList;
    private static final int MAX_LENGTH_SNAKE= 4;

    public Snake() {
        this.tlo();
        collisions=new Collisions(this);
        positionsOfHead=new ArrayList<Point>(0);
        this.resetSnake();


    }


    private void tlo() {
        this.setLayout(new GridLayout(sizeOfTheNet, sizeOfTheNet));

        for (int i=0; i < siatka.length; i++) {
            for (int j=0; j < siatka.length; j++) {
                siatka[i][j]=new JPanel();
                siatka[i][j].setSize(oneCellDimension);
                //siatka[i][j].setBorder(BorderFactory.createLineBorder(Color.green));
                siatka[i][j].setPreferredSize(oneCellDimension);
                siatka[i][j].setBackground(Color.black);
                this.add(siatka[i][j]);
            }
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP: {

                stillDown=false;
                stillLeft=false;
                stillRight=false;
                stillUp=true;
                this.goUp();

                break;
            }
            case KeyEvent.VK_DOWN: {

                stillDown=true;
                stillLeft=false;
                stillRight=false;
                stillUp=false;
                this.goDown();

                break;
            }
            case KeyEvent.VK_LEFT: {

                stillDown=false;
                stillLeft=true;
                stillRight=false;
                stillUp=false;
                this.goLeft();

                break;
            }
            case KeyEvent.VK_RIGHT: {

                stillDown=false;
                stillLeft=false;
                stillRight=true;
                stillUp=false;
                this.goRight();

                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private void resetSnake() {
        int xCenter=sizeOfTheNet / 2;
        int yCenter=sizeOfTheNet / 2;
        xPositionOfHead=xCenter;
        yPositionOfHead=yCenter;
        drawHeadSnake(xPositionOfHead, yPositionOfHead);
        positionsOfHead.add(new Point(xPositionOfHead, yPositionOfHead));
        timer.schedule(new RemindTask(), 0, 50);

    }

    private void drawHeadSnake(int x, int y) {
        siatka[x][y].setBackground(Color.green);
    }

    private void clearHeadSnake(int x, int y) {
        siatka[x][y].setBackground(Color.black);
    }

    private void drawBody() {

        if (bodyLenght > 0) {
            positionInTheList=positionsOfHead.size()-1 ;
            for (int i=0; i < bodyLenght; i++) {
                    System.out.println("PETLA NR::: "+i);
                    System.out.println("posotionsInTheList::: "+positionInTheList);
                    System.out.println("positionsOfHead size::: "+positionsOfHead.size());
                    System.out.println("------------------------------------------------------------------------");
                    siatka[positionsOfHead.get(positionInTheList).x][positionsOfHead.get(positionInTheList).y].setBackground(Color.green); //-1: rysowanie już po pierwszej kropce
                    positionInTheList--;

            }
            positionInTheList = positionsOfHead.size() - 1;
            for (int i=0; i <bodyLenght ; i++) {
                System.out.println("////////////////////////////////////");
                System.out.println("body lenght::: "+bodyLenght);
                System.out.println("positionInTheList - bodyLenght::: "+ (positionInTheList - bodyLenght ));
                if ((positionInTheList-bodyLenght) < 0) {
                    siatka[positionsOfHead.get((0)).x][positionsOfHead.get((0)).y].setBackground(Color.BLACK); //usuwanie ogona żwwby miał taką długość jaka jest ilosć zebranych kropek
                }else
                    siatka[positionsOfHead.get((positionInTheList - bodyLenght)).x][positionsOfHead.get((positionInTheList - bodyLenght)).y].setBackground(Color.BLACK); //usuwanie ogona żwwby miał taką długość jaka jest ilosć zebranych kropek

            }
        }
//        if (positionsOfHead.size() > MAX_LENGTH_SNAKE) {
//            System.out.println("+++++++++++++++");
//            System.out.println("skracanie positionsOfHead");
//            System.out.println("positionsOfHead.size() - bodylenght::: "+(positionsOfHead.size()-bodyLenght));
//            int sizePositionsOfHead = positionsOfHead.size();
//            for (int i=0; i < sizePositionsOfHead - bodyLenght; i++) {
//                System.out.println("petla skracania::: "+i);
//                positionsOfHead.remove(0);
//            }
//
//            System.out.println("po skroceniu::: " +positionsOfHead.size());
//            System.out.println("+++++++++++++++ ");
////            positionsOfHead=new ArrayList<Point>(positionsOfHead.subList(positionsOfHead.size() - bodyLenght - 2, positionsOfHead.size()-1));
//
//        }

    }

    private void goUp() {




        if (xPositionOfHead > 0) {
            clearHeadSnake(xPositionOfHead, yPositionOfHead);
            xPositionOfHead=xPositionOfHead - 1; //w tablicach odwrotnie osie
            if (collisions.checkCollision())
                bodyLenght++;
            positionsOfHead.add(new Point(xPositionOfHead, yPositionOfHead));
            drawHeadSnake(xPositionOfHead, yPositionOfHead);
            drawBody();
        }


    }

    private void goDown() {

        if (xPositionOfHead < sizeOfTheNet - 1) {
            clearHeadSnake(xPositionOfHead, yPositionOfHead);
            xPositionOfHead=xPositionOfHead + 1;
            if (collisions.checkCollision())
                bodyLenght++;
            positionsOfHead.add(new Point(xPositionOfHead, yPositionOfHead));
            drawHeadSnake(xPositionOfHead, yPositionOfHead);
            drawBody();
        }

    }

    private void goRight() {


        if (yPositionOfHead < sizeOfTheNet - 1) {//710 - 20(head of snake)
            clearHeadSnake(xPositionOfHead, yPositionOfHead);
            yPositionOfHead=yPositionOfHead + 1;
            if (collisions.checkCollision())
                bodyLenght++;
            positionsOfHead.add(new Point(xPositionOfHead, yPositionOfHead));
            drawHeadSnake(xPositionOfHead, yPositionOfHead);
            drawBody();
        }
    }

    private void goLeft() {


        if (yPositionOfHead > 0) {
            clearHeadSnake(xPositionOfHead, yPositionOfHead);
            yPositionOfHead=yPositionOfHead - 1;
            if (collisions.checkCollision())
                bodyLenght++;
            positionsOfHead.add(new Point(xPositionOfHead, yPositionOfHead));
            drawHeadSnake(xPositionOfHead, yPositionOfHead);
            drawBody();
        }
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {

            if (stillUp)
                goUp();
            if (stillDown)
                goDown();
            if (stillRight)
                goRight();
            if (stillLeft)
                goLeft();
        }
    }
}

