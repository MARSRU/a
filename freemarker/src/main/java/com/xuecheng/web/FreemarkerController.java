package com.xuecheng.web;


import com.xuecheng.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@Controller
@RequestMapping("/freem")
public class FreemarkerController {

    @RequestMapping("/pop")
    public String freemarker(Map<String, Object> map) {

        map.put("name", "黑马程序员");
        Student stu1 = new Student();
        stu1.setName("小明");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());
        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);

        List<Student> friends = new ArrayList<>();
        friends.add(stu1);
        stu2.setFriends(friends);
        stu2.setBestFriend(stu1);


        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);

        map.put("stus", stus);
        HashMap<String, Student> stuMap = new HashMap<>();
        stuMap.put("stu1", stu1);
        stuMap.put("stu2", stu2);

        map.put("stu1",stu1);
        map.put("stuMap",stuMap);

        return "test1";

    }
}
