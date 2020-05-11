package com.znsd.message.controller;

import com.github.pagehelper.PageInfo;
import com.znsd.message.service.MessageService;
import com.znsd.sportsbean.http.MessageDomain;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.view.MessageAndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public boolean send(@RequestBody MessageDomain domain) {
        System.out.println(domain);
        return messageService.add(domain);
    }

    @PostMapping("/sendList")
    public boolean sendList(List<UserDomain> list, MessageDomain messageDomain) {
        try {
            for (UserDomain userDomain : list) {
                messageDomain.setUserId(userDomain.getId());
                messageService.add(messageDomain);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @GetMapping("/getList")
    public PageInfo getList(Integer page, Integer limit) {
        return messageService.getList(page, limit);
    }


    @GetMapping("/getList2")
    public PageInfo getList2(Integer page, Integer limit) {
        return messageService.getView(page, limit);
    }

    @PostMapping("/read")
    public boolean readMessage(Integer id) {
        return messageService.readMessage(id);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody MessageAndUser messageAndUser) {
        System.out.println(messageAndUser);
        return messageService.delete(messageAndUser.getId());
    }
}
