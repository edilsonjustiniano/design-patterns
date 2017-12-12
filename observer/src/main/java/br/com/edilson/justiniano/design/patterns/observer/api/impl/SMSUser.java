package br.com.edilson.justiniano.design.patterns.observer.api.impl;

import br.com.edilson.justiniano.design.patterns.observer.api.Observer;
import br.com.edilson.justiniano.design.patterns.observer.api.Subject;

public class SMSUser implements Observer {

	// also called publisher
	private final Subject subject;

	private final String userInfo;

	private String comment;

	public SMSUser(Subject subject, String userInfo) {
		if (subject == null) {
			throw new IllegalArgumentException("No Publisher has been found");
		}
		this.subject = subject;
		this.userInfo = userInfo;
	}

	@Override
	public void update(String comment) {
		this.comment = comment;
		display();
	}

	@Override
	public void subscribe() {
		System.out.println("Subscribing " + userInfo + " to " + subject.subjectTitle() + " ...");
		this.subject.subscribeObserver(this);
		System.out.println("Subscribed successfully.");
	}

	@Override
	public void unSubscribe() {
		System.out.println("Unsubscribing " + userInfo + " to " + subject.subjectTitle() + " ...");
		this.subject.unSubscribeObserver(this);
		System.out.println("Unsubscribed successfully.");
	}

	private void display() {
		System.out.println("[" + userInfo + "]: " + comment);
	}

}
