package com.shirokumacafe.archetype.common.utilities;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.sql.Clob;

/**
 * Created with IntelliJ IDEA.
 * User: SHIROKUMA
 * Date: 14-4-25
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
public class Bigs {

    public static String clobToString(final Clob clob){

        if( null == clob ){
            return "";
        }

        StringBuilder str = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(clob.getCharacterStream());
            String tmpStr = "";
            while ((tmpStr = br.readLine()) != null) {
                str.append(tmpStr);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(br);
        }
        return str.toString();
    }
}
