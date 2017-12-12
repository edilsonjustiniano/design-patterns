package br.com.edilson.justiniano.design.patterns.observer.runner;

import java.util.ArrayList;

import br.com.edilson.justiniano.design.patterns.observer.api.Commentary;
import br.com.edilson.justiniano.design.patterns.observer.api.Observer;
import br.com.edilson.justiniano.design.patterns.observer.api.Subject;
import br.com.edilson.justiniano.design.patterns.observer.api.impl.RealTimeNews;
import br.com.edilson.justiniano.design.patterns.observer.api.impl.SMSUser;

public class Runner {

	public static void main(String[] args) {
		Subject subject = new RealTimeNews(new ArrayList<>(), "Fifa world cup final match");
		Observer observer = new SMSUser(subject, "Edilson Justiniano");
		observer.subscribe();

		System.out.println();
		Observer observer2 = new SMSUser(subject, "Josy Chaves");
		observer2.subscribe();

		Commentary commentary = ((Commentary) subject);
		commentary.sendComment("Welcome to the final match of the Fifa world cup");
		commentary.sendComment("Current score 0-0");
		System.out.println();

		observer2.unSubscribe();
		System.out.println();

		commentary.sendComment("It’s a goal!!");
		commentary.sendComment("Current score 1-0");
		System.out.println();

		Observer observer3 = new SMSUser(subject, "Smith");
		observer3.subscribe();
		System.out.println();

		commentary.sendComment("It’s another goal!!");
		commentary.sendComment("Half-time score 2-0");
	}
}
