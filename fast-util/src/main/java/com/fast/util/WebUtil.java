package com.fast.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebUtil {

    private static final Logger log = LoggerFactory.getLogger(WebUtil.class);


    /**
     * POST访问url并获取数据
     *
     * @param url   访问的链接
     * @param param 访问链接传递的参数
     * @return 字符串结果
     */
    public static String sendPost(String url, String param) {
        HttpURLConnection conn = null;
        OutputStream os = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            //POST提交设置参数
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setUseCaches(false);  //不允许缓存
            conn.setConnectTimeout(60000);//连接超时 单位毫秒
            conn.setReadTimeout(60000);   //读取超时 单位毫秒

            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);   //向httpUrlConnection输出
            conn.setDoInput(true);    //从httpUrlConnection读入

            //输出参数
            os = conn.getOutputStream();
            os.write(param.getBytes("utf-8"));
            os.flush();

            //获取接口返回数据
            is = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(is);

            //读取数据
            String temp;
            sb = new StringBuilder();
            while (null != (temp = br.readLine())) {
                sb.append(temp);
            }
        } catch (IOException e) {
            log.error("发送POST请求时报错");
        } finally {
            try {
                os.close();
                is.close();
                br.close();
                conn.disconnect();
            } catch (IOException e) {
                log.error("发送POST请求时流/conn连接关闭错误");
            }
        }
        return sb.toString();
    }
}
