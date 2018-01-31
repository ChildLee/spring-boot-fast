package com.fast.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCodeUtil {

    private static final Random random = new Random();

    private static final String VERIFY_CODES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * 使用系统默认字符源生成验证码
     *
     * @param verifySize 验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize) {
        return generateRandomString(verifySize, VERIFY_CODES);
    }

    /**
     * 使用指定源生成验证码
     *
     * @param verifySize 验证码长度
     * @param sources    验证码字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources) {
        if (sources == null || sources.length() == 0) {
            sources = VERIFY_CODES;
        }
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
     * 生成随机验证码文件,并返回验证码值
     *
     * @param w
     * @param h
     * @param outputFile
     * @param verifySize
     * @return
     * @throws IOException
     */
    public static String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws IOException {
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, outputFile, verifyCode);
        return verifyCode;
    }

    /**
     * 输出随机验证码图片流,并返回验证码值
     *
     * @param w
     * @param h
     * @param os
     * @param verifySize
     * @return
     * @throws IOException
     */
    public static String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws IOException {
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, os, verifyCode);
        return verifyCode;
    }

    /**
     * 生成指定验证码图像文件
     *
     * @param w
     * @param h
     * @param file
     * @param code
     * @throws IOException
     */
    public static void outputImage(int w, int h, File file, String code) throws IOException {
        if (file == null) {
            return;
        }
        File dir = file.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            outputImage(w, h, fos, code);
            fos.close();
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 随机颜色值
     *
     * @param start
     * @param end
     * @return
     */
    private static Color getRandColor(int start, int end) {
        if (start > 255 || start < 0) start = 255;
        if (end > 255 || end < 0) end = 255;
        if (start > end) {
            int temp = end;
            end = start;
            start = temp;
        }
        int r = start + random.nextInt(end - start);
        int g = start + random.nextInt(end - start);
        int b = start + random.nextInt(end - start);
        return new Color(r, g, b);
    }

    /**
     * 输出指定验证码图片流
     *
     * @param w
     * @param h
     * @param os
     * @param code
     * @throws IOException
     */
    public static void outputImage(int w, int h, OutputStream os, String code) throws IOException {
        int verifySize = code.length();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//使用抗锯齿

        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, w, h);
        //边框
        Color c = getRandColor(200, 250);
        g2.setColor(c);
        g2.fillRect(0, 2, w, h - 4);
        //中线
        g2.setColor(Color.GRAY);
        g2.fillRect(0, h / 2, w, 4);

        //随机干扰线
        g2.setColor(getRandColor(160, 200));
//        for (int i = 0; i < 100; i++) {
//            int x = random.nextInt(w);
//            int y = random.nextInt(h);
//            int x2 = random.nextInt(w);
//            int y2 = random.nextInt(h);
//            g2.drawLine(x, y, x2, y2);
//        }


        //随机噪点
        for (int i = 0; i < 1000; i++) {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            image.setRGB(x, y, getRGB());
        }

//        shear(g2, w, h, c);// 使图片扭曲
//
//        g2.setColor(getRandColor(100, 160));
//        int fontSize = h - 4;
//        Font font = new Font("华文彩云", Font.ITALIC, fontSize);
//        g2.setFont(font);
//        char[] chars = code.toCharArray();
//        for (int i = 0; i < verifySize; i++) {
//            AffineTransform affine = new AffineTransform();
//            affine.setToRotation(Math.PI / 4 * random.nextDouble() * (random.nextBoolean() ? 1 : -1), (w / verifySize) * i + fontSize / 2, h / 2);
//            g2.setTransform(affine);
//            g2.drawChars(chars, i, 1, ((w - 10) / verifySize) * i + 5, h / 2 + fontSize / 2 - 10);
//        }
//
//        g2.dispose();
        ImageIO.write(image, "jpg", os);
    }

    private static int getRGB() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return ((255 & 0xFF) << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
    }

    private static void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }

    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {
        int period = random.nextInt(40) + 10; // 50;
        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File dir = new File("D:/verifies");
        int w = 200, h = 80;
        for (int i = 0; i < 100; i++) {
            String verifyCode = generateVerifyCode(4);
            File file = new File(dir, verifyCode + ".jpg");
            outputImage(w, h, file, verifyCode);
        }
    }
}
