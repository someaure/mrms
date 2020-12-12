package com.cqie.graduation.mrms.user.util.util;

import javafx.util.Pair;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author xd
 * @date 2020/12/12
 */

public class RandomValidateCodeUtil {
    /**
     * 随机产生只有数字的字符串 private String
     */
    private static final String RAND_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * 图片宽
     */
    private static final int WIDTH = 120;
    /**
     * 图片高
     */
    private static final int HEIGHT = 38;
    /**
     * 干扰线数量
     */
    private static final int LINE_SIZE = 40;
    /**
     * 随机产生字符数量
     */
    private static final int STRING_NUM = 4;

    private static final Random RANDOM = new Random();

    /**
     * 获得字体
     */
    private static Font getFont() {
        return new Font("Fixedsys", Font.BOLD, 18);
    }

    /**
     * 获得颜色
     */
    private static Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + RANDOM.nextInt(bc - fc - 16);
        int g = fc + RANDOM.nextInt(bc - fc - 14);
        int b = fc + RANDOM.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成随机图片
     */
    public static Pair<String, BufferedImage> generateVerifyCode() {
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        // 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        Graphics g = image.getGraphics();
        //图片大小
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //字体大小
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        //字体颜色
        g.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= LINE_SIZE; i++) {
            drawLine(g);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= STRING_NUM; i++) {
            randomString = drawString(g, randomString, i);
        }
        g.dispose();
        return new Pair<>(randomString, image);
    }

    /**
     * 绘制字符串
     */
    private static String drawString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(RANDOM.nextInt(101), RANDOM.nextInt(111), RANDOM
                .nextInt(121)));
        String rand = getRandomString(RANDOM.nextInt(RAND_STRING
                .length()));
        randomString += rand;
        g.translate(RANDOM.nextInt(3), RANDOM.nextInt(3));
        g.drawString(rand, 24 * i, 24);
        return randomString;
    }

    /**
     * 绘制干扰线
     */
    private static void drawLine(Graphics g) {
        int x = RANDOM.nextInt(WIDTH);
        int y = RANDOM.nextInt(HEIGHT);
        int xl = RANDOM.nextInt(13);
        int yl = RANDOM.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 获取随机的字符
     */
    public static String getRandomString(int num) {
        return String.valueOf(RAND_STRING.charAt(num));
    }

}
