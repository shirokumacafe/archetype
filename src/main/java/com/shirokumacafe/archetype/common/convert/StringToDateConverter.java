package com.shirokumacafe.archetype.common.convert;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.owasp.esapi.ESAPI;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * 字符串转日期 转换器
 *
 * @author lim
 */
public class StringToDateConverter implements Converter<String, Date> {
    private static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public Date convert(String source) {

        if (source.isEmpty() ) {
            return null;
        }

        try {
            DateTime dt;
            String decodedStr = ESAPI.encoder().decodeForHTML(source);
            if( decodedStr.length()==19 && !decodedStr.contains("T") ){
                dt = fmt.parseDateTime( decodedStr );
            }
            else{
                dt = new DateTime( decodedStr );
            }
            return dt.toDate();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
}
