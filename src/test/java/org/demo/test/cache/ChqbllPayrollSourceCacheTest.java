/*
 * JUnit test case for ChqbllPayrollSource caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.ChqbllPayrollSource ;
import org.demo.cache.ChqbllPayrollSourceCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for ChqbllPayrollSource caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllPayrollSourceCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(ChqbllPayrollSource chqbllPayrollSource) {
		chqbllPayrollSource.setId( 1 ) ;
		chqbllPayrollSource.setSort( "A" ) ;
		chqbllPayrollSource.setName( "A" ) ;
		chqbllPayrollSource.setSuitableRight( "A" ) ;
		chqbllPayrollSource.setInsertBy( "A" ) ;
		chqbllPayrollSource.setInsertAt( now ) ;
		chqbllPayrollSource.setUpdateBy( "A" ) ;
		chqbllPayrollSource.setUpdateAt( now ) ;
		chqbllPayrollSource.setIsActive( false ) ;
		chqbllPayrollSource.setWorkspace( 1 ) ;
		chqbllPayrollSource.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class ChqbllPayrollSourceCache ..." );
		
		ChqbllPayrollSource chqbllPayrollSource = new ChqbllPayrollSource();
		populate(chqbllPayrollSource);
		System.out.println("Entity populated : " + chqbllPayrollSource );
		
		ChqbllPayrollSourceCache.putChqbllPayrollSource(chqbllPayrollSource) ;	// Store in cache	
		
		ChqbllPayrollSource chqbllPayrollSource2 = ChqbllPayrollSourceCache.getChqbllPayrollSource( chqbllPayrollSource.getId() );
		Assert.assertTrue( chqbllPayrollSource == chqbllPayrollSource2 ) ; // Same instance
		
		ChqbllPayrollSourceCache.removeChqbllPayrollSource(  chqbllPayrollSource.getId() ) ; // Remove from cache	
		
		ChqbllPayrollSource chqbllPayrollSource3 = ChqbllPayrollSourceCache.getChqbllPayrollSource( chqbllPayrollSource.getId() );
		Assert.assertTrue( null == chqbllPayrollSource3 ) ; // Not in cache
		
	}
}
