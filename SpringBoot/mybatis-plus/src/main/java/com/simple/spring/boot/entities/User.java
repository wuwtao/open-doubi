package com.simple.spring.boot.entities;

import lombok.Data;

/**
 * 实体类
 * @author: SimpleWu
 * @date: 2019/5/25
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
