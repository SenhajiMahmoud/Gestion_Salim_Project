package com.Pizzeria.services;

/**
 * @author Mahmoud
 *
 */
public class NotificationService {
	private String content;

	public NotificationService(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
