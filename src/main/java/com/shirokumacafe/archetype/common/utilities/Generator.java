package com.shirokumacafe.archetype.common.utilities;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成工具
 *
 * @author lim
 */
public class Generator {

    public static void main(String[] args) throws IOException, TemplateException, URISyntaxException {

        String className = "User";
        String basePackage = "com.shirokumacafe.archetype";

        File templateDirectory = new File(Generator.class.getClassLoader().getResource("generator").getFile());

        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        cfg.setDirectoryForTemplateLoading(templateDirectory);
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        Map root = new HashMap();

        root.put("className",className);
        root.put("basepackage",basePackage);

        for(File file: templateDirectory.listFiles()){

            Template template = cfg.getTemplate(file.getName());
            String outDirectory = "src/main/java/" + basePackage.replace(".","/");
            File outFile = new File(outDirectory+"/22.txt");
            outFile.createNewFile();
            Writer out = new FileWriter(outFile);
            template.process(root,out);
            out.flush();
        }

    }

}
