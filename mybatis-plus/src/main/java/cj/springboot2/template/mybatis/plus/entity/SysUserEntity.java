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
@TableName("sys_user")
public class SysUserEntity extends CJBaseColmns {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("`name`")
    private String name;

    @TableField("age")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SysUserEntity{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
        "}";
    }
}
