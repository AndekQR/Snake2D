package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Program extends JPanel {

    private JFrame ramkaGlowna;
    private Container containerGlowny;
    private Dimension dimensionPrefered = new Dimension(800, 800);

    public Program(){
        ramkaGlowna = new JFrame("TETRIS");
        containerGlowny = ramkaGlowna.getContentPane();
        containerGlowny.setLayout(new BorderLayout());
        containerGlowny.setPreferredSize(dimensionPrefered);


        ramkaGlowna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramkaGlowna.setResizable(false);

        ramkaGlowna.setVisible(true);

//        Background background = new Background();
//        containerGlowny.add(background);
//
        Snake snake = new Snake();
        containerGlowny.add(snake);
//        GridBagConstraints gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.fill = GridBagConstraints.CENTER;
//        background.add(snake, gridBagConstraints);
        ramkaGlowna.addKeyListener(snake);

        //collisions dodawane z klasy snake


        ramkaGlowna.pack();

    }
}
