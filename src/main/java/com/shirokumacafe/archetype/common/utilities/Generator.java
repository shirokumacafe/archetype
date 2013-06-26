package com.shirokumacafe.archetype.common.utilities;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成工具
 *
 * @author lim
 */
public class Generator {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration();
        ClassPathResource resource = new ClassPathResource("generator");
        File file = new File("/generator");
        File[] s=file.listFiles();
        System.out.println(s);
//        cfg.setDirectoryForTemplateLoading(file);
//        cfg.setObjectWrapper(new DefaultObjectWrapper());
//        Template template = cfg.getTemplate("${className}Controller.ftl");
//        Map root = new HashMap();
//
//        root.put("className","User");
//        root.put("basepackage","com.shirokumacafe.demo");
//
//        Writer out = new OutputStreamWriter(System.out);
//        template.process(root,out);
//        out.flush();
//        String pattern = "%1$s 在 %4$tF %4$tT 说了 \"%1$s 爱 %2$s %3$d 年\"";
//        System.out.println(String.format(pattern, "mingming","shuilian",10000,System.currentTimeMillis()));
    }
}
