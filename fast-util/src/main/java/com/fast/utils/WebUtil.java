package com.fast.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import static com.fast.utils.StringUtil.isNull;

/**
 * HTTP
 */
public class WebUtil {

    private final static Logger log = LoggerFactory.getLogger(WebUtil.class);

    public final static String APPLICATION_JSON = "application/json";
    public final static String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";

    /**
     * POST默认访问方式
     *
     * @param url   访问的链接
     * @param param 参数
     * @return
     */
    public static String sendPost(String url, String param) {
        return sendPost(url, param, null);
    }

    /**
     * POST访问,参数为json格式
     *
     * @param url   访问的链接
     * @param param 参数
     * @return
     */
    public static String sendJsonPost(String url, String param) {
        return sendPost(url, param, APPLICATION_JSON);
    }

    /**
     * POST访问,参数为form方式
     *
     * @param url    访问的链接
     * @param params 参数
     * @return
     */
    public static String sendFormPost(String url, String params) {
        return sendPost(url, params, APPLICATION_FORM_URLENCODED);
    }

    /**
     * POST访问,参数为form方式
     *
     * @param url    访问的链接
     * @param params 参数
     * @return
     */
    public static String sendFormPost(String url, Map<String, String> params) {
        return sendPost(url, ConvertUtil.toKeyValue(params), APPLICATION_FORM_URLENCODED);
    }

    /**
     * POST访问,参数为form方式
     *
     * @param url    访问的链接
     * @param params 参数
     * @return
     */
    public static String sendFormPostSort(String url, Map<String, String> params) {
        return sendPost(url, ConvertUtil.toKeyValueSort(params), APPLICATION_FORM_URLENCODED);
    }

    /**
     * POST访问url并获取数据
     *
     * @param url         访问的链接
     * @param params      key=value格式的字符串
     * @param contentType 提交方式
     * @return
     */
    private static String sendPost(String url, String params, String contentType) {
        HttpURLConnection conn = null;
        //流
        OutputStream os = null;
        BufferedReader br = null;
        //结果
        StringBuilder sb = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            //POST提交设置参数
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);  //POST不允许缓存
            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);   //向httpUrlConnection输出
            conn.setDoInput(true);    //从httpUrlConnection读入

            conn.setConnectTimeout(10 * 1000);//连接超时 单位毫秒,10秒
            conn.setReadTimeout(10 * 1000);   //读取超时 单位毫秒,10秒

            if (!isNull(params)) {
                conn.setRequestProperty("Content-Type", contentType);
                conn.setRequestProperty("Charset", "UTF-8");
            }
            //输出参数
            os = conn.getOutputStream();
            os.write(params.getBytes("UTF-8"));
            os.flush();

            //获取接口返回数据
            //关闭br,里面的流会自己关闭
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            //读取数据
            String temp;
            sb = new StringBuilder();
            while (null != (temp = br.readLine())) {
                sb.append(temp);
            }
        } catch (IOException e) {
            log.error("发送POST请求时报错");
        } finally {
            conn.disconnect();
            try {
                os.close();
                br.close();
            } catch (IOException e) {
                log.error("发送POST请求时流关闭错误");
            }
        }
        return sb.toString();
    }

    public static String sendGet(String url, Map params) {
        url = url.concat("?").concat(ConvertUtil.toKeyValue(params));
        return sendGet(url);
    }

    /**
     * POST访问url并获取数据
     *
     * @param url 访问的链接
     * @return 字符串结果
     */
    public static String sendGet(String url) {
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            URLConnection conn = new URL(url).openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            //读取数据
            String temp;
            sb = new StringBuilder();
            while (null != (temp = br.readLine())) {
                sb.append(temp);
            }
        } catch (IOException e) {
            log.error("发送GET请求时出错");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                log.error("发送GET请求时流关闭错误");
            }
        }
        return sb.toString();
    }
}
