package br.com.edilson.justiniano.design.patterns.observer.api;

public interface Observer {

	void update(String desc);

	void subscribe();

	void unSubscribe();
}
