package cj.springboot2.template.mybatis.plus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*
* 实现自动装填
* */
@Slf4j
@Component
public class CJMetaObjectHandler implements MetaObjectHandler {


    /**
     * 创建时间
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info(" -------------------- start insert fill ...  --------------------");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "flag", Boolean.class, false);

//        if (metaObject.hasGetter("createTime") && metaObject.hasGetter("updateTime")) {
//            setFieldValByName("createTime", new Date(), metaObject);
//            setFieldValByName("updateTime", new Date(), metaObject);
//        }
//        if (metaObject.hasGetter("flag")) {
//            setFieldValByName("flag", false, metaObject);
//
//        }
    }

    /**
     * 最后一次更新时间
     */
    @Override
    public  void updateFill(MetaObject metaObject) {
        log.info(" -------------------- start update fill ...  --------------------");
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

//
//        if (metaObject.hasGetter("updateTime")) {
//            setFieldValByName("updateTime", new Date(), metaObject);
//        }
    }

}