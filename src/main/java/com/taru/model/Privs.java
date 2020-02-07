package com.taru.model;

import java.util.List;

/**
 *
 * 权限类（菜单类）
 */
public class Privs {

    private Integer privsId;

    private String privsName;

    private String privsStatus;

    private String privsFather;

    private String privsSon;

    private List<Privs> privs;

    public String getPrivsSon() {
        return privsSon;
    }

    public void setPrivsSon(String privsSon) {
        this.privsSon = privsSon;
    }

    public List<Privs> getPrivs() {
        return privs;
    }

    public void setPrivs(List<Privs> privs) {
        this.privs = privs;
    }

    public Integer getPrivsId() {
        return privsId;
    }

    public void setPrivsId(Integer privsId) {
        this.privsId = privsId;
    }

    public String getPrivsName() {
        return privsName;
    }

    public void setPrivsName(String privsName) {
        this.privsName = privsName;
    }

    public String getPrivsStatus() {
        return privsStatus;
    }

    public void setPrivsStatus(String privsStatus) {
        this.privsStatus = privsStatus;
    }

    public String getPrivsFather() { return privsFather; }

    public void setPrivsFather(String privsFather) { this.privsFather = privsFather; }

    @Override
    public String toString() {
        return "Privs{" +
                "privsId='" + privsId + '\'' +
                ", privsName='" + privsName + '\'' +
                ", privsStatus='" + privsStatus + '\'' +
                '}';
    }
}
