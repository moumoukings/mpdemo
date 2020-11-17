package com.mark.mpdemo.bean;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 公共字段填充
 *
 * @author zhangzichen
 * @date 2020/11/10 15:40
 */
@Slf4j
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static int ISDEL = 0;
    private static int VERSION = 1;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setIfAbsent("createTime", new Date(), metaObject);
        this.setIfAbsent("updateTime", new Date(), metaObject);
        this.setIfAbsent("isDel", ISDEL, metaObject);
        this.setIfAbsent("version", VERSION, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setIfAbsent("updateTime", new Date(), metaObject);
        //this.setIfAbsent("version", ++VERSION, metaObject);
    }

    private void setIfAbsent(String fieldName, Object fielfVal, MetaObject metaObject) {
        if (getFieldValByName(fieldName, metaObject) != null) {
            return;
        }
        this.setFieldValByName(fieldName, fielfVal, metaObject);
    }
}
