package com.shirokumacafe.archetype.common.convert;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 字符串转日期 转换器
 *
 * @author lim
 */
public class StringToDateConverter implements Converter<String, Date> {
    private final static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public Date convert(String source) {
        if (!StringUtils.hasLength(source)) {
            return null;
        }

        try {
            DateTime dt;
            if(source.length()==19 && !source.contains("T")){
                dt = fmt.parseDateTime(source);
            }
            else{
                dt = new DateTime(source);
            }
            return dt.toDate();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
}
