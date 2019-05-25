package com.simpel.springcloud.user.biz;

import com.codingapi.txlcn.tc.annotation.TxTransaction;
import com.simpel.springcloud.user.ibiz.IUserServerBiz;
import com.simpel.springcloud.user.mapper.UserServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author: SimpleWu
 * @date: 2019/5/24
 */
@Service
public class UserServerBiz implements IUserServerBiz {

    @Autowired
    private UserServerMapper userServerMapper;

    @Override
    @TxTransaction
    @Transactional
    public int insertUser(Map<String, Object> map) {
        return userServerMapper.insert(map);
    }
}
