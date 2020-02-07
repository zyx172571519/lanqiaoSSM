package com.taru.model;

/**
 *
 * 角色权限实体类
 */
public class RolePrivs {

    private Integer rolePrivsId;

    private String roleId;

    private String privsId;

    public Integer getRolePrivsId() {
        return rolePrivsId;
    }

    public void setRolePrivsId(Integer rolePrivsId) {
        this.rolePrivsId = rolePrivsId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPrivsId() {
        return privsId;
    }

    public void setPrivsId(String privsId) {
        this.privsId = privsId;
    }

    @Override
    public String toString() {
        return "RolePrivs{" +
                "rolePrivsId='" + rolePrivsId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", privsId='" + privsId + '\'' +
                '}';
    }
}
