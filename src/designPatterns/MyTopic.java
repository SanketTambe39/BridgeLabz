package designPatterns;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean updated;
	private final Object mutex = new Object();

	public MyTopic() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer observer) {

		if (!(observers == null))
			synchronized (mutex) {

				if (!observers.contains(observer)) {

					observers.add(observer);
				}
			}

	}

	@Override
	public void unregister(Observer observer) {

		synchronized (mutex) {

			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {

		List<Observer> localObserver = null;

		if (!updated) {
			return;
		}
		localObserver = new ArrayList<>(this.observers);
		this.updated = false;

		localObserver.forEach((Observer observer) -> observer.update());

	}

	@Override
	public Object getUpdate(Observer observer) {

		return this.message;
	}

	public void postMessage(String message) {
		System.out.println("\n Message posted to topic : " + message);

		this.message = message;
		this.updated = true;

		notifyObservers();
	}

}
