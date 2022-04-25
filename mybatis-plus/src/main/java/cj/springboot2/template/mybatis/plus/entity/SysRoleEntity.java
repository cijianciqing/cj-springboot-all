package cj.springboot2.template.mybatis.plus.entity;

import cj.springboot2.template.mybatis.plus.config.CJBaseColmns;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cj
 * @since 2022-04-25
 */
@TableName("sys_role")
public class SysRoleEntity extends CJBaseColmns {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("role_name")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysRoleEntity{" +
            "id=" + id +
            ", roleName=" + roleName +
        "}";
    }
}
