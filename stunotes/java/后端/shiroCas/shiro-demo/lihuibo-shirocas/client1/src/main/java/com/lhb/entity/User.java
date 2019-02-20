package com.lhb.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {
    private Integer uid;

    private String loginname;

    private String loginpassword;

    private String uname;

    private Integer age;

    private String gender;
    
    private List<Role> roleList;
    
    private List<Permission> permissionList;
    
    public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		// 将权限集合进行去重
		this.permissionList = new ArrayList<Permission>(new HashSet<Permission>(permissionList));
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }
}