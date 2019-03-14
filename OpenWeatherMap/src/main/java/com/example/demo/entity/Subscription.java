package com.example.demo.entity;


public class Subscription {

	private String city;
	private Long subscriptionType;
	
	public Subscription() {
		super();
	}

	public Subscription(String city, Long subscriptionType) {
		super();
		this.city = city;
		this.subscriptionType = subscriptionType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(Long subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Override
	public String toString() {
		return "Subscription [city=" + city + ", subscriptionType=" + subscriptionType + "]";
	}
	
}
