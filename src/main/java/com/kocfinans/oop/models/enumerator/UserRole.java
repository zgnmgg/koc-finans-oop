package com.kocfinans.oop.models.enumerator;

public enum UserRole {
	ROLE_ADMIN, ROLE_CLIENT, ROLE_DEMO, ROLE_PREMIUM;

	public String getName() {
		return name();
	}
}
