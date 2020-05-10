package com.applet.service;

import com.applet.bean.entity.Admin;
import com.applet.utils.QiniuUtils;
import com.applet.utils.RequestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 *  图片上传测试
 * @author gsj
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ImageUploadTest {

    @Test
    public void test1() {
//        File file = new File("D:/p1.png");
//        QiniuUtils.uploadPhoto(file,"tt1");
        Admin admin = new Admin();
        System.out.println(admin);
    }

}
