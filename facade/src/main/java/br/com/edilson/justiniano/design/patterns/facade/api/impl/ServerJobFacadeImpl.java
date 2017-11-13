package br.com.edilson.justiniano.design.patterns.facade.api.impl;

import br.com.edilson.justiniano.design.patterns.facade.api.ServerJobFacade;
import br.com.edilson.justiniano.design.patterns.facade.job.ServerJob;

public class ServerJobFacadeImpl implements ServerJobFacade {

	private final ServerJob serverJob;

	public ServerJobFacadeImpl(ServerJob serverJob) {
		this.serverJob = serverJob;
	}

	@Override
	public void startServer() {
		serverJob.startBooting();
		serverJob.init();
		serverJob.initializeContext();
		serverJob.initializeListeners();
		serverJob.createBeans();
	}

	@Override
	public void stopServer() {
		serverJob.releaseProcess();
		serverJob.destroy();
		serverJob.destroyContext();
		serverJob.destroyListeners();
		serverJob.destroyBeans();
	}

}
