package com.shirokumacafe.archetype.common.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: SHIROKUMA
 * Date: 14-3-11
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */
public class NetWorks {

    /**
     * 连接url并取得回应数据
     */
    public static String connUrl(String urlStr) {
       return connUrl(urlStr,Charset.forName("UTF-8"));
    }

    /**
     * 连接url并取得回应数据
     */
    public static String connUrl(String urlStr,Charset charset) {
        URL url;
        StringBuffer sb = null;
        try {
            url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
            String s;
            sb = new StringBuffer();
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
