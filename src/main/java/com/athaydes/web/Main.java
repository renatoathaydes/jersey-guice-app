package com.athaydes.web;

import com.athaydes.web.dao.Dao;
import com.athaydes.web.dao.StuffDao;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * User: Renato
 */
public class Main extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		final ResourceConfig rc = new PackagesResourceConfig( "com.athaydes.web.server" );

		return Guice.createInjector( new ServletModule() {
			@Override
			protected void configureServlets() {
				bind( new TypeLiteral<Dao<String>>() {
				} ).to( StuffDao.class );

				for ( Class<?> resource : rc.getClasses() ) {
					System.out.println( "Binding resource: " + resource.getName() );
					bind( resource );
				}

				serve( "/services/*" ).with( GuiceContainer.class );
			}
		} );
	}
}
