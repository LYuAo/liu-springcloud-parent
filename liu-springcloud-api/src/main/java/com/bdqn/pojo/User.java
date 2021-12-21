package com.bdqn.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor//生成一个无参数的构造方法
@Builder
@AllArgsConstructor//生成一个全部参数的构造方法
@Accessors(chain = true)  //链式写法
public class User {
    private  int id;
    private String name;
    private int age;
    private String email;
    private String source;
}
