package it;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class mainframe extends JFrame {

    private int[][] imagedata = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    public mainframe() {
        initframe();
        initimages();
        initmenu();
        setVisible(true);
    }
    private void initmenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("游戏");
        JMenuItem exit1 = new JMenuItem("退出");
        menu.add( exit1);
        exit1.addActionListener(e -> {
            System.exit(0);
        });

        JMenuItem exit2 = new JMenuItem("重新开始");
        menu.add( exit2);
        exit2.addActionListener(e -> {
            new mainframe();
            dispose();
        });
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public void initframe() {
        setTitle("stone_maze v1.0.0");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        ImageIcon originalIcon = new ImageIcon("D:\\lesson\\myproject\\hello\\stone_maze\\src\\image\\17.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(500, 550, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 500, 600);
        // 将背景图添加到最底层
        getLayeredPane().add(background, Integer.valueOf(0));
    }

    public void initimages() {
        String basePath = "D:\\lesson\\myproject\\hello\\stone_maze\\src\\image\\";

        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                int num = imagedata[i][j];
                ImageIcon icon = new ImageIcon(basePath + num + ".png");
                JLabel label = new JLabel(icon);
                label.setBounds(40 + j * 100, 110 + i * 100, 100, 100);
                // 将小图片添加到顶层
                getLayeredPane().add(label, Integer.valueOf(100));
            }
        }
    }
}
