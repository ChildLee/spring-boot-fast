package com.fast.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.fast.utils.StringUtil.isNull;

public class ConvertUtil {

    private final static Logger log = LoggerFactory.getLogger(ConvertUtil.class);

    /**
     * 除去Map集合中的空值
     *
     * @param params 参数集合
     */
    public static void removeNullValue(Map<String, String> params) {
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (isNull(entry.getKey()) || isNull(entry.getValue())) {
                iterator.remove();
            }
        }
    }

    /**
     * 对参数按照key=value的格式，并按照参数名ASCII字典序排序
     *
     * @param params 参数集合
     * @return 拼接完返回字符串
     */
    public static String toKeyValue(Map<String, String> params) {
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sb.append("&").append(next.getKey()).append("=").append(next.getValue());
        }
        return sb.substring(1);
    }

    /**
     * 对参数按照key=value的格式，并按照参数名ASCII字典序排序
     *
     * @param params 参数集合
     * @return 拼接完返回字符串
     */
    public static String toKeyValueSort(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = params.get(key);
            sb.append("&").append(key).append("=").append(value);
        }
        return sb.substring(1);
    }

    /**
     * 将参数集合转换成xml格式
     *
     * @param params 参数集合
     * @return xml字符串
     */
    public static String toXML(Map<String, String> params) {
        Document document = DocumentHelper.createDocument();
        Element xml = document.addElement("xml");
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            xml.addElement(next.getKey()).addCDATA(next.getValue());
        }
        return document.getRootElement().asXML();
    }

    /**
     * 将xml格式转换成参数集合
     *
     * @param xml 需要解析的xml数据
     * @return 参数集合
     */
    public static Map<String, String> xmlToMap(String xml) {
        if (isNull(xml)) return null;
        Map<String, String> map = new HashMap();
        try {
            //读取XML文本内容获取Document对象
            Document document = DocumentHelper.parseText(xml);
            //获取根节点元素对象
            Element root = document.getRootElement();
            //获取当前节点的所有属性节点
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                map.put(element.getName(), element.getStringValue());
            }
        } catch (DocumentException e) {
            log.error("xml转map集合出错");
        }
        return map;
    }
}
