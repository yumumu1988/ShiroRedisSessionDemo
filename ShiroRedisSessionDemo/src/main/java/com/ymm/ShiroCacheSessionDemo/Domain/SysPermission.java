package com.ymm.ShiroCacheSessionDemo.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by James on 7/31/2017.
 */
@Entity
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 6289696331635628249L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissionId;

    private String name;

    @Column(columnDefinition = "enum('menu', 'button')")
    private String resourceType;

    private String url;

    private String permission;

    private Long parentId;

    private String parentIds;

    private Boolean available;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString(){
        return String.format("SysPermission[permissionId = %s, name = %s, resourceType = %s, url = %s, permission = %s, parentId = %s, parentIds = %s, available = %s, role = %s]", permissionId, name, resourceType, url, permission, parentId, parentIds, available, roles);
    }
}
