package cj.springboot2.template.mybatis.plus.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface CJMapper<T> extends BaseMapper<T> {
    int deleteByIdWithFill(T entity);
}
