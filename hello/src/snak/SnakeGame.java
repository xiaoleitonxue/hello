package snak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    
    // 游戏常量
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_HEIGHT = 480;
    private static final int CELL_SIZE = 20;
    private static final int GAME_SPEED = 150; // 毫秒
    
    // 颜色定义
    private static final Color BLACK = Color.BLACK;
    private static final Color WHITE = Color.WHITE;
    private static final Color RED = Color.RED;
    private static final Color GREEN = new Color(0, 255, 0);
    private static final Color DARK_GREEN = new Color(0, 200, 0);
    
    // 游戏变量
    private int[] snakeX; // 蛇身体的 X 坐标
    private int[] snakeY; // 蛇身体的 Y 坐标
    private int snakeLength; // 蛇的长度
    private int foodX, foodY; // 食物位置
    private int direction; // 移动方向：0-上，1-下，2-左，3-右
    private boolean gameOver;
    private int score;
    private Timer timer;
    private Random random;
    
    public SnakeGame() {
        random = new Random();
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setBackground(BLACK);
        setFocusable(true);
        
        // 添加键盘监听
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode());
            }
        });
        
        initGame();
        startGame();
    }
    
    /**
     * 初始化游戏
     */
    private void initGame() {
        // 初始化蛇的位置和长度
        snakeLength = 3;
        snakeX = new int[WINDOW_WIDTH / CELL_SIZE * WINDOW_HEIGHT / CELL_SIZE];
        snakeY = new int[WINDOW_WIDTH / CELL_SIZE * WINDOW_HEIGHT / CELL_SIZE];
        
        // 蛇的初始位置在屏幕中央
        for (int i = 0; i < snakeLength; i++) {
            snakeX[i] = WINDOW_WIDTH / 2 - i * CELL_SIZE;
            snakeY[i] = WINDOW_HEIGHT / 2;
        }
        
        direction = 3; // 初始向右移动
        gameOver = false;
        score = 0;
        
        // 生成第一个食物
        generateFood();
    }
    
    /**
     * 开始游戏
     */
    private void startGame() {
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(GAME_SPEED, this);
        timer.start();
    }
    
    /**
     * 生成食物
     */
    private void generateFood() {
        boolean validPosition;
        do {
            validPosition = true;
            foodX = random.nextInt((WINDOW_WIDTH - CELL_SIZE) / CELL_SIZE + 1) * CELL_SIZE;
            foodY = random.nextInt((WINDOW_HEIGHT - CELL_SIZE) / CELL_SIZE + 1) * CELL_SIZE;
            
            // 确保食物不会生成在蛇身上
            for (int i = 0; i < snakeLength; i++) {
                if (snakeX[i] == foodX && snakeY[i] == foodY) {
                    validPosition = false;
                    break;
                }
            }
        } while (!validPosition);
    }
    
    /**
     * 处理键盘按键
     */
    private void handleKeyPress(int keyCode) {
        if (gameOver) {
            if (keyCode == KeyEvent.VK_SPACE) {
                initGame();
            } else if (keyCode == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
            return;
        }
        
        // 改变方向（不能直接反向）
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (direction != 1) direction = 0;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (direction != 0) direction = 1;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (direction != 3) direction = 2;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (direction != 2) direction = 3;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }
    
    /**
     * 移动蛇
     */
    private void moveSnake() {
        // 移动身体
        for (int i = snakeLength; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        
        // 移动头部
        switch (direction) {
            case 0: // 上
                snakeY[0] -= CELL_SIZE;
                break;
            case 1: // 下
                snakeY[0] += CELL_SIZE;
                break;
            case 2: // 左
                snakeX[0] -= CELL_SIZE;
                break;
            case 3: // 右
                snakeX[0] += CELL_SIZE;
                break;
        }
    }
    
    /**
     * 检查碰撞
     */
    private void checkCollision() {
        // 检查墙壁碰撞
        if (snakeX[0] < 0 || snakeX[0] >= WINDOW_WIDTH || 
            snakeY[0] < 0 || snakeY[0] >= WINDOW_HEIGHT) {
            gameOver = true;
        }
        
        // 检查自身碰撞
        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                gameOver = true;
                break;
            }
        }
        
        // 检查食物碰撞
        if (snakeX[0] == foodX && snakeY[0] == foodY) {
            snakeLength++;
            score += 10;
            generateFood();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }
    
    /**
     * 绘制游戏画面
     */
    private void drawGame(Graphics g) {
        // 绘制网格线
        g.setColor(new Color(30, 30, 30));
        for (int x = 0; x < WINDOW_WIDTH; x += CELL_SIZE) {
            g.drawLine(x, 0, x, WINDOW_HEIGHT);
        }
        for (int y = 0; y < WINDOW_HEIGHT; y += CELL_SIZE) {
            g.drawLine(0, y, WINDOW_WIDTH, y);
        }
        
        // 绘制蛇
        for (int i = 0; i < snakeLength; i++) {
            if (i == 0) {
                g.setColor(GREEN); // 蛇头
            } else {
                g.setColor(DARK_GREEN); // 蛇身
            }
            g.fillRect(snakeX[i], snakeY[i], CELL_SIZE, CELL_SIZE);
            g.setColor(WHITE);
            g.drawRect(snakeX[i], snakeY[i], CELL_SIZE, CELL_SIZE);
        }
        
        // 绘制食物
        g.setColor(RED);
        g.fillRect(foodX, foodY, CELL_SIZE, CELL_SIZE);
        g.setColor(WHITE);
        g.drawRect(foodX, foodY, CELL_SIZE, CELL_SIZE);
        
        // 绘制分数
        g.setColor(WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 10, 20);
        
        // 游戏结束画面
        if (gameOver) {
            g.setColor(RED);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            String gameOverText = "GAME OVER";
            FontMetrics metrics = getFontMetrics(g.getFont());
            int textX = (WINDOW_WIDTH - metrics.stringWidth(gameOverText)) / 2;
            int textY = WINDOW_HEIGHT / 2 - 20;
            g.drawString(gameOverText, textX, textY);
            
            g.setColor(WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            String restartText = "Press SPACE to restart or ESC to quit";
            metrics = getFontMetrics(g.getFont());
            textX = (WINDOW_WIDTH - metrics.stringWidth(restartText)) / 2;
            textY = WINDOW_HEIGHT / 2 + 20;
            g.drawString(restartText, textX, textY);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            moveSnake();
            checkCollision();
        }
        repaint();
    }
    
    /**
     * 创建并显示游戏窗口
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("贪吃蛇");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        SnakeGame gamePanel = new SnakeGame();
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * 主函数
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            createAndShowGUI();
        });
    }
}
