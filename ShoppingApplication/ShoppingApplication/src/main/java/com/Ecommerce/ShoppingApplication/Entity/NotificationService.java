package com.Ecommerce.ShoppingApplication.Entity;

public interface NotificationService {
	void sendOrderConfirmation(String toEmail, String subject, String body);
}
