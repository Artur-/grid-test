package com.example.grid1.data;

public enum Availability {
	COMING_SOON("Coming soon"), PREORDER("Preorder"), AVAILABLE("Available"), DISCONTINUED(
			"Discontinued");

	private final String name;
	
	private Availability(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean isAvailable() {
		return !(this == COMING_SOON || this == DISCONTINUED);
	}

	public boolean isReleased() {
		return !(this == COMING_SOON || this == PREORDER);
	}
	
}