package com.xuecheng;


import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGGG {


    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @Test
    public void testTempletFTL() throws FileNotFoundException {

        File file = new File("D:\\kuxue\\xi-code1\\freemarker\\src\\main\\resources\\templates\\index_banner.ftl");

        FileInputStream fileInputStream = new FileInputStream(file);

        ObjectId objectid = gridFsTemplate.store(fileInputStream, "轮播伯", "ftl");


        String s = objectid.toString();

        System.out.println(s);

    }

    @Test
    public void testGridFsGet() throws Exception {

        //1. 通过id 查询数据库
        String fileId = "5db117feb7f6632a04634bbe";

        //根据id查询文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));

        //打开下载流对象
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());

        //创建gridFsResource，用于获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);

        //获取流中的数据
      /*  String s = IOUtils.toString(gridFsResource.getInputStream());

        System.out.println(s);
*/
        InputStream inputStream = gridFsResource.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/aaa.html"));

        IOUtils.copy(inputStream,fileOutputStream);


    }
}
