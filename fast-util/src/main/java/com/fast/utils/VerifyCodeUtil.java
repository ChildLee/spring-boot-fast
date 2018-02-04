package com.fast.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class VerifyCodeUtil {

    private static final String VERIFY_CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final Random random = new Random();

    private static int width = 200;

    private static int height = 80;


    /**
     * 使用系统默认字符源生成验证码
     *
     * @param verifySize 验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize) {
        return generateRandomString(verifySize, VERIFY_CODES);
    }

    public static String generateVerifyCode(int verifySize, String sources) {
        return generateRandomString(verifySize, sources);
    }

    /**
     * 生成随机字符串
     *
     * @param length  长度
     * @param sources 字符源
     * @return 指定长度的随机字符串
     */
    private static String generateRandomString(int length, String sources) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(sources.charAt(random.nextInt(sources.length())));
        }
        return sb.toString();
    }

    /**
     * 随机颜色值
     *
     * @param start 大于零,小于end
     * @param end   大于start,小于256
     * @return
     */
    private static Color getRandColor(int start, int end) {
        int r = start + random.nextInt(end - start);
        int g = start + random.nextInt(end - start);
        int b = start + random.nextInt(end - start);
        return new Color(r, g, b);
    }

    /**
     * 随机颜色值
     *
     * @return
     */
    private static int getRGB() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return ((255 & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
    }

    /**
     * 随机三角形背景
     *
     * @param g2=
     */
    public static void randomTriangle(Graphics g2) {
        int a = 30;//边长
        for (int i = 0; i < 250; i++) {
            g2.setColor(getRandColor(100, 255));
            int locationWidth = random.nextInt(width);
            int locationHeight = random.nextInt(height + 20) - 20;
            double triangleHeight = Math.sqrt(3) / 2 * a;
            int x[] = {locationWidth - (a / 2), locationWidth, locationWidth + (a / 2)};
            int y[] = {(int) (locationHeight + triangleHeight), locationHeight, (int) (locationHeight + triangleHeight)};
            g2.fillPolygon(x, y, 3);
            g2.setColor(getRandColor(150, 255));
            g2.drawPolygon(x, y, 3);
        }
    }

    /**
     * 输出指定验证码图片流
     *
     * @param code
     * @throws IOException
     */
    public static BufferedImage verifyCodeImage(String code) {
        int verifySize = code.length();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//使用抗锯齿
        //随机背景色
        g2.setColor(getRandColor(200, 255));
        g2.fillRect(0, 0, width, height);

        //随机三角形背景
        randomTriangle(g2);

        g2.setColor(getRandColor(0, 100));
        int fontSize = height;
        g2.setFont(new Font("华文彩云", Font.ITALIC, fontSize));
        AffineTransform affine = new AffineTransform();
        for (int i = 0; i < verifySize; i++) {
            affine.setToRotation((Math.PI / 3) * random.nextDouble() * (random.nextBoolean() ? 1 : -1), (width / verifySize) * i + fontSize / 2, height / 2);
            g2.setTransform(affine);
            g2.drawChars(code.toCharArray(), i, 1, (width / verifySize) * i, height / 2 + fontSize / 3);
        }
        //随机噪点
        for (int i = 0; i < 500; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            image.setRGB(x, y, getRGB());
        }
        g2.dispose();
        return image;
    }

    public static BufferedImage verifyCodeImage(int w, int h, String code) {
        width = w;
        height = h;
        return verifyCodeImage(code);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:/verifies");
        for (int i = 0; i < 100; i++) {
            String verifyCode = generateVerifyCode(4);
            File file1 = new File(file, verifyCode + ".jpg");
            File dir = file1.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileOutputStream outputStream = new FileOutputStream(file1);
            BufferedImage image = verifyCodeImage(verifyCode);
            ImageIO.write(image, "jpg", outputStream);
        }
    }
}
