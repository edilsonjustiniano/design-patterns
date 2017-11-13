package br.com.edilson.justiniano.design.patterns.facade.job;

public class ServerJob {

	public boolean startBooting() {
		return false;
	}

	public boolean init() {
		return false;
	}

	public boolean initializeContext() {
		return false;
	}

	public boolean initializeListeners() {
		return false;
	}

	public boolean createBeans() {
		return false;
	}

	public boolean releaseProcess() {
		return false;
	}

	public boolean destroy() {
		return false;
	}

	public boolean destroyContext() {
		return false;
	}

	public boolean destroyListeners() {
		return false;
	}

	public boolean destroyBeans() {
		return false;
	}

}
