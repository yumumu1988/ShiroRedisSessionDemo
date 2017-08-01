package com.ymm.ShiroCacheSessionDemo.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by James on 7/31/2017.
 */
@Entity
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 4585410710652188273L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    @Column(unique = true)
    private String username;

    private String name;

    private String password;

    private String salt;

    private byte state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getCredentialsSalt(){
        return this.username + this.salt;
    }

    @Override
    public String toString(){
        return String.format("UserInfo[uid = %s, username = %s, name = %s, password = %s, salt = %s, state = %s]", uid, username, name, password, salt, state);
    }
}
