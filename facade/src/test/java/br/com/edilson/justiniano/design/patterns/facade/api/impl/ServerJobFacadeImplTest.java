package br.com.edilson.justiniano.design.patterns.facade.api.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.edilson.justiniano.design.patterns.facade.api.ServerJobFacade;
import br.com.edilson.justiniano.design.patterns.facade.job.ServerJob;

/**
 * Unit tests for {@link ServerJobFacadeImpl}
 *
 * @author edilson
 */
@RunWith(MockitoJUnitRunner.class)
public class ServerJobFacadeImplTest {

	@Mock
	private ServerJob serverJob;

	@InjectMocks
	private ServerJobFacade serverJobFacadeImpl = new ServerJobFacadeImpl(serverJob);

	@Test
	public void startServer_shouldSuccessfullyStart() {
		// given
		given(serverJob.startBooting()).willReturn(true);
		given(serverJob.init()).willReturn(true);
		given(serverJob.initializeContext()).willReturn(true);
		given(serverJob.initializeListeners()).willReturn(true);
		given(serverJob.createBeans()).willReturn(true);

		// when
		serverJobFacadeImpl.startServer();

		// then
		verify(serverJob).startBooting();
		verify(serverJob).init();
		verify(serverJob).initializeContext();
		verify(serverJob).initializeListeners();
		verify(serverJob).createBeans();
	}

	@Test
	public void stopServer_shouldSuccessfullyStop() {
		// given
		given(serverJob.releaseProcess()).willReturn(true);
		given(serverJob.destroy()).willReturn(true);
		given(serverJob.destroyContext()).willReturn(true);
		given(serverJob.destroyListeners()).willReturn(true);
		given(serverJob.destroyBeans()).willReturn(true);

		// when
		serverJobFacadeImpl.stopServer();

		// then
		verify(serverJob).releaseProcess();
		verify(serverJob).destroy();
		verify(serverJob).destroyContext();
		verify(serverJob).destroyListeners();
		verify(serverJob).destroyBeans();
	}
}
