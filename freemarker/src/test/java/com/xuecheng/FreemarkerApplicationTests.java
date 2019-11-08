package com.xuecheng;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@SpringBootTest
public class FreemarkerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGenerateHtml() throws Exception {

        //创建配置类
        Configuration configuration = new Configuration(Configuration.getVersion());

        //设置模板路径
        String classpath = this.getClass().getResource("/").getPath();
        configuration.setDirectoryForTemplateLoading(new File(classpath + "/templates/"));

        //设置字符集
        configuration.setDefaultEncoding("utf-8");

        //加载模板
        Template template = configuration.getTemplate("test1.ftl");

        //数据模型
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "库学教育");

        //静态化
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

        //静态化内容
        System.out.println("content = " + content);
        InputStream inputStream = IOUtils.toInputStream(content);

        //输出文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/test1.html"));
        int copy = IOUtils.copy(inputStream, fileOutputStream);
    }

    @Test
    public void test2() throws Exception {

        //   1   配置信息
        Configuration configuration = new Configuration(Configuration.getVersion());

        //   2   有一个 String 类型的  模板数据
        String templateString = "" + "<html>\n" + " <head></head>\n" + " <body>\n" + " 名称：${name}\n" + " </body>\n" + "</html>";


        //    3  模板类加载器   把String 的数据 生成 模板
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", templateString);
        configuration.setTemplateLoader(stringTemplateLoader);

        //得到模板
        Template template = configuration.getTemplate("template","utf‐8");


        //    4  数据模型   map
        HashMap<String, Object> map = new HashMap<>();

        map.put("name", "库学教育666");

        //静态化
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

        //静态化内容
        System.out.println("content = " + content);
        InputStream inputStream = IOUtils.toInputStream(content);

        //输出文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/test1.html"));

        int copy = IOUtils.copy(inputStream, fileOutputStream);

    }

}
