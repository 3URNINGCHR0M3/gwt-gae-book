package org.gwtgaebook.template.server;

import java.util.TimeZone;

import org.gwtgaebook.template.server.APIServlet;
import org.gwtgaebook.template.shared.Constants;

import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;

public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(
				DispatchServiceImpl.class);
		serve("/api/v1/*").with(APIServlet.class);

		TimeZone.setDefault(TimeZone.getTimeZone(Constants.serverTimeZone));
	}

}
