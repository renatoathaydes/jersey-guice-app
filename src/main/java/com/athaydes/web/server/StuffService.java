package com.athaydes.web.server;

import com.athaydes.web.dao.Dao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_HTML;

/**
 * User: Renato
 */
@Path( "stuff" )
public class StuffService {

	private Dao<String> dao;

	@Inject
	public StuffService( Dao<String> dao ) {
		this.dao = dao;
	}

	@GET
	@Produces( TEXT_HTML )
	public String getAll() {
		System.out.println( "Requested to get All" );
		String html = "<h2>All stuff</h2><ul>";
		for ( String stuff : dao.getAll() ) {
			html += "<li>" + stuff + "</li>";
		}
		html += "</ul>";
		return html;
	}

	@GET
	@Path( "{id}" )
	@Produces( TEXT_HTML )
	public String getById( @PathParam( "id" ) String id ) {
		System.out.println( "Requested to get ID = " + id );
		String stuff = dao.getById( id );
		if ( stuff == null ) return notFound();
		else return "<html><body><div>" + stuff + "</div></body></html>";
	}

	private String notFound() {
		return "<html><body><div>Not Found</div></body></html>";
	}

}
