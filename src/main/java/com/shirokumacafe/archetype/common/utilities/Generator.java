//package com.shirokumacafe.archetype.common.utilities;
//
//import freemarker.template.Configuration;
//import freemarker.template.DefaultObjectWrapper;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.net.URISyntaxException;
//import java.util.*;
//
///**
// * 代码生成工具
// *
// * @author lim
// */
//public class Generator {
//    //生成的类名
//    String className = "User";
//    //包名
//    String basePackage = "com.shirokumacafe.archetype";
//    //类目录
//    String javaRoot = "src/main/java/";
//    //模板目录
//    String templateRoot = getResource("generator");
//
//    Map<String,String> controllerMap = new  HashMap<String,String>(){
//        {
//            this.put("in", "Controller.ftl");
//            this.put("filename",javaClient+"com/shirokumacafe/archetype/web/"+className+"Controller.java");
//            this.put("out",javaRoot+"com/shirokumacafe/archetype/web/");
//        }
//    };
//
//    public static class GeneratorModel{
//        private Map templateModel;
//        private Map filePathModel;
//
//        public GeneratorModel(Map templateModel, Map filePathModel) {
//            this.templateModel = templateModel;
//            this.filePathModel = ""+filePathModel;
//        }
//    }
//    public void generator(){
//
//    }
//
//    private String getResource(String resource){
//        return Generator.class.getClassLoader().getResource(resource).getFile();
//    }
//    public List<Map<String, String>> setup(Map<String,String>...maps){
//
//    }
//    public static void main(String[] args) throws IOException, TemplateException, URISyntaxException {
//
//        final String className = "User";
//        String basePackage = "com.shirokumacafe.archetype";
//        final String javaClient = "src/main/java/";
//        final String templateClient = Generator.class.getClassLoader().getResource("generator").getFile();
//
//        Map<String,String> controllerMap = new  HashMap<String,String>(){
//            {
//                this.put("in", "Controller.ftl");
//                this.put("out",javaClient+"com/shirokumacafe/archetype/web/"+className+"Controller.java");
//            }
//        };
//
//        List<Map<String, String>> templateList = Arrays.asList(controllerMap);
//        File templateDirectory = new File(templateClient);
//
//        Configuration cfg = new Configuration();
//        cfg.setDirectoryForTemplateLoading(templateDirectory);
//        cfg.setObjectWrapper(new DefaultObjectWrapper());
//
//        Map root = new HashMap();
//
//        root.put("className",className);
//        root.put("basepackage",basePackage);
//
//
//        for(Map<String, String> map :templateList){
//            Template template = cfg.getTemplate(map.get("in"));
//            String outDirectory = map.get("out");
//            File outFile = new File(outDirectory);
//            outFile.createNewFile();
//            Writer out = new FileWriter(outFile);
//            template.process(root,out);
//            out.flush();
//        }
//
//
//    }
//
//}
