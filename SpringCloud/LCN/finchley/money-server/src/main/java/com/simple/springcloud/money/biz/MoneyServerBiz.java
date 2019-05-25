package com.simple.springcloud.money.biz;

import com.codingapi.txlcn.tc.annotation.TxTransaction;
import com.simple.springcloud.money.fegin.UserFegin;
import com.simple.springcloud.money.ibiz.IMoneyServerBiz;
import com.simple.springcloud.money.mapper.MoneyServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @title: ${name}
 * @author: SimpleWu
 * @date: 2019/5/24
 */
@Service
public class MoneyServerBiz implements IMoneyServerBiz {

    @Autowired
    private UserFegin userFegin;

    @Autowired
    private MoneyServerMapper moneyServerMapper;

    @Override
    @TxTransaction
    @Transactional
    public String insert() {
        String userId = UUID.randomUUID().toString();

        Map<String,Object> param = new HashMap<>();
        param.put("ID",userId);
        param.put("USER_ID",userId);
        param.put("MONEY",100);
        param.put("USERPASS","12321321");

        //先调用远程服务测试事务回滚
        System.out.println( userFegin.hello("张三","12321321",userId));


        moneyServerMapper.insert(param);

        return "success " + param;
    }


}
