package com.mark.mpdemo.domain.request.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 *
 * @author zhangzichen
 * @date 2020/11/09 10:54
 */
@Data
@TableName("user")
public class UserReqDto implements Serializable {

    private static final long serialVersionUID = -4121318779707413831L;

    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDel;
}
