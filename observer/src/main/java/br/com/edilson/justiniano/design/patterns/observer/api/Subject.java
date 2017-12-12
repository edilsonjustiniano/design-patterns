package br.com.edilson.justiniano.design.patterns.observer.api;

/**
 * The interface that represents the side publisher of Observer design pattern
 *
 * @author edilson
 */
public interface Subject {

	void subscribeObserver(Observer observer);

	void unSubscribeObserver(Observer observer);

	void notifyObservers();

	String subjectTitle();
}
