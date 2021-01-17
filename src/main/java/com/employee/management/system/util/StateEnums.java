package com.employee.management.system.util;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum StateEnums {

	ADDED(1, "ADDED"), IN_CHECK(2, "IN-CHECK"), APPROVED(3, "APPROVED"), ACTIVE(4, "ACTIVE");

	private StateEnums(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	private Integer id;

	private String value;

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

}
