package com.znsd.message.dao;

import com.znsd.sportsbean.http.MessageDomain;
import com.znsd.sportsbean.view.MessageAndUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageDao {

    void add(MessageDomain messageDomain);

    List<MessageDomain> select();

    void read(Integer id);

    List<MessageAndUser> selectView();

    void delete(Integer id);
}
