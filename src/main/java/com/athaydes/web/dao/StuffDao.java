package com.athaydes.web.dao;

import java.util.Arrays;
import java.util.List;

/**
 * User: Renato
 */

public class StuffDao implements Dao<String> {
	@Override
	public List<? extends String> getAll() {
		return Arrays.asList( "Stuff", "Something else", "Whatever" );
	}

	@Override
	public String getById( String id ) {
		return id;
	}
}
