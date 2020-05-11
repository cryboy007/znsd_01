package com.znsd.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.znsd.message.dao.MessageDao;
import com.znsd.message.service.MessageService;
import com.znsd.sportsbean.http.MessageDomain;
import com.znsd.sportsbean.user.UserDomain;
import com.znsd.sportsbean.view.MessageAndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    public MessageDao messageDao;

    @Override
    public boolean add(MessageDomain messageDomain) {
        messageDao.add(messageDomain);
        return true;
    }

    @Override
    public PageInfo<MessageDomain> getList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MessageDomain> list = messageDao.select();
        PageInfo<MessageDomain> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public boolean readMessage(Integer id) {
        messageDao.read(id);
        return true;
    }

    @Override
    public PageInfo<MessageAndUser> getView(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<MessageAndUser> list = messageDao.selectView();
        PageInfo<MessageAndUser> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public boolean delete(Integer id) {
        messageDao.delete(id);
        return true;
    }

}
