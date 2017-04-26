package com.example.auth.common;

import lombok.Getter;


public enum UserType {
	SUPER_ADMIN("1", "수퍼관리자"),
	MASTER("2", "관리자"),
	USER("3", "사용자");
	
	@Getter
	private String code;
	
	@Getter
	private String desc;
	
	UserType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
