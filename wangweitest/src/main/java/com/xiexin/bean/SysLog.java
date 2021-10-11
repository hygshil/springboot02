package com.xiexin.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_log
 * @author 
 */
@ToString  //lombok的插件的注解，不用写toString
@Data
public class SysLog implements Serializable {
    private String userSession;

    private String eventType;

    private Long categoryId;

    private Integer userId;

    private Integer productId;

    private String addressName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date eventTime;

    private static final long serialVersionUID = 1L;

}