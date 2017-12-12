package br.com.edilson.justiniano.design.patterns.observer.api.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edilson.justiniano.design.patterns.observer.api.Commentary;
import br.com.edilson.justiniano.design.patterns.observer.api.Observer;
import br.com.edilson.justiniano.design.patterns.observer.api.Subject;

public class RealTimeNews implements Subject, Commentary {

	private final List<Observer> observers;
	private final String newsTitle;
	private List<String> comments;

	public RealTimeNews(List<Observer> observers, String newsTitle) {
		this.observers = observers;
		this.newsTitle = newsTitle;
		this.comments = new ArrayList<>();
	}

	@Override
	public void sendComment(String comment) {
		comments.add(comment);
		notifyObservers();
	}

	@Override
	public void subscribeObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unSubscribeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		System.out.println("Notifying observers:");
		observers.stream().forEach((observer) -> {
			String lastComment = comments.get(comments.size() - 1);
			observer.update(lastComment);
		});
	}

	@Override
	public String subjectTitle() {
		return newsTitle;
	}

}
