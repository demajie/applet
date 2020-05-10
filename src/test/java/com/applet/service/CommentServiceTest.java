package com.applet.service;


import com.applet.bean.dto.CommentAddInfo;
import com.applet.bean.dto.ReplyAddInfo;
import com.baomidou.mybatisplus.extension.api.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gsj
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    /**
     *  添加留言
     */
    @Test
    public void test1() {
        CommentAddInfo addInfo = new CommentAddInfo();
        addInfo.setContent("12321421412");
        addInfo.setIsAnonymous(0);
        addInfo.setPhone("111");
        addInfo.setTitle("粑粑");
        addInfo.setTypeId(1);
        commentService.addComment(addInfo);
    }

    /**
     *  管理元添加回复
     */
    @Test
    public void test2(){
        ReplyAddInfo addInfo = new ReplyAddInfo();
        addInfo.setCommentId(1);
        addInfo.setContent("处理完毕");
        addInfo.setStatus(2);
        commentService.addReply(addInfo);
    }
}
