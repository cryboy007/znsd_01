package com.znsd.message.service;

import com.github.pagehelper.PageInfo;
import com.znsd.sportsbean.http.MessageDomain;
import com.znsd.sportsbean.view.MessageAndUser;

public interface MessageService {
    public boolean add(MessageDomain messageDomain);

    public PageInfo<MessageDomain> getList(Integer page, Integer limit);

    public boolean readMessage(Integer id);

    public PageInfo<MessageAndUser> getView(Integer page, Integer limit);

    public boolean delete(Integer id);
}
