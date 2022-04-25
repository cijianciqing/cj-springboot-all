package cj.springboot2.template.mybatis.plus.service.impl;

import cj.springboot2.template.mybatis.plus.entity.SysUserEntity;
import cj.springboot2.template.mybatis.plus.dao.SysUserDao;
import cj.springboot2.template.mybatis.plus.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cj
 * @since 2022-04-25
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

}
