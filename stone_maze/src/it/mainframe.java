package it;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class mainframe extends JFrame {

    private final int[][] imagedata = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    private int[][] windata =  new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    private int row;
    private int col;
    private JLabel backgroundLabel;
    private boolean hasWon = false;

    public mainframe() {
        initframe();
        initrandomarray();
        initimages();
        initmenu();
        initkeypress();
        setVisible(true);
    }

    private void initkeypress() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        move1(direction.up);
                        break;
                    case KeyEvent.VK_DOWN:
                        move1(direction.down);
                        break;
                    case KeyEvent.VK_LEFT:
                        move1(direction.left);
                        break;
                    case KeyEvent.VK_RIGHT:
                        move1(direction.right);
                        break;
                    case KeyEvent.VK_ESCAPE:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void move1(direction r) {
        if (hasWon) return;

        switch (r) {
            case up:
                if (row < imagedata.length - 1) {
                    int temp = imagedata[row][col];
                    imagedata[row][col] = imagedata[row + 1][col];
                    imagedata[row + 1][col] = temp;
                    row++;
                }
                System.out.println("上移");
                break;
            case down:
                if (row > 0) {
                    int temp = imagedata[row][col];
                    imagedata[row][col] = imagedata[row - 1][col];
                    imagedata[row - 1][col] = temp;
                    row--;
                }
                System.out.println("下移");
                break;
            case left:
                if (col < imagedata.length - 1) {
                    int temp = imagedata[row][col];
                    imagedata[row][col] = imagedata[row][col + 1];
                    imagedata[row][col + 1] = temp;
                    col++;
                }
                System.out.println("左移");
                break;
            case right:
                if (col > 0) {
                    int temp = imagedata[row][col];
                    imagedata[row][col] = imagedata[row][col - 1];
                    imagedata[row][col - 1] = temp;
                    col--;
                }
                System.out.println("右移");
                break;
            default:
                break;
        }
        initimages();
    }

    private void initrandomarray() {
        int total = imagedata.length * imagedata[0].length;
        int[] flat = new int[total];

        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                flat[i * 4 + j] = imagedata[i][j];
            }
        }

        for (int k = 0; k < 100; k++) {
            int idx1 = (int) (Math.random() * total);
            int idx2 = (int) (Math.random() * total);
            int temp = flat[idx1];
            flat[idx1] = flat[idx2];
            flat[idx2] = temp;
        }

        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                imagedata[i][j] = flat[i * 4 + j];
            }
        }

        out:
        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                if (imagedata[i][j] == 0) {
                    row = i;
                    col = j;
                    break out;
                }
            }
        }
    }

    private void initmenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("游戏");
        JMenuItem exit1 = new JMenuItem("退出");
        menu.add(exit1);
        exit1.addActionListener(e -> {
            System.exit(0);
        });

        JMenuItem exit2 = new JMenuItem("重新开始");
        menu.add(exit2);
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

        backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 500, 600);
        getLayeredPane().add(backgroundLabel, Integer.valueOf(0));
    }

    public void initimages() {
        getLayeredPane().removeAll();

        getLayeredPane().add(backgroundLabel, Integer.valueOf(0));

        String basePath = "D:\\lesson\\myproject\\hello\\stone_maze\\src\\image\\";

        if (iswin() && !hasWon){
            hasWon = true;
            showWinDialog(basePath);
        }

        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                int num = imagedata[i][j];

                if (num == 0) {
                    continue;
                }

                ImageIcon icon = new ImageIcon(basePath + num + ".png");
                JLabel label = new JLabel(icon);
                label.setBounds(40 + j * 100, 110 + i * 100, 100, 100);
                getLayeredPane().add(label, Integer.valueOf(100));
            }
        }

        revalidate();
        repaint();
    }

    private void showWinDialog(String basePath) {
        ImageIcon winIcon = new ImageIcon(basePath + "18.png");
        JLabel winLabel = new JLabel(winIcon);
        winLabel.setBounds(50, 50, 400, 300);
        getLayeredPane().add(winLabel, Integer.valueOf(200));

        JOptionPane.showMessageDialog(this, "恭喜你赢了！🎉", "胜利", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean iswin() {
        for (int i = 0; i < imagedata.length; i++) {
            for (int j = 0; j < imagedata[i].length; j++) {
                if (imagedata[i][j] != windata[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
