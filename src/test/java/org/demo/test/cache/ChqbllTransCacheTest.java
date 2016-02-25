/*
 * JUnit test case for ChqbllTrans caching service
 * Created on 24 �ub 2016 ( Date ISO 2016-02-24 - Time 15:13:25 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */

package org.demo.test.cache;


import org.demo.bean.ChqbllTrans ;
import org.demo.cache.ChqbllTransCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for ChqbllTrans caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ChqbllTransCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(ChqbllTrans chqbllTrans) {
		chqbllTrans.setId( 1 ) ;
		chqbllTrans.setSort( "A" ) ;
		chqbllTrans.setReceiptNo( 1 ) ;
		chqbllTrans.setRight( "A" ) ;
		chqbllTrans.setFromStep( "A" ) ;
		chqbllTrans.setToStep( "A" ) ;
		chqbllTrans.setTransDate( now ) ;
		chqbllTrans.setTransNo( "A" ) ;
		chqbllTrans.setTransType( "A" ) ;
		chqbllTrans.setTotal( 12.345 ) ;
		chqbllTrans.setRowCount( 1 ) ;
		chqbllTrans.setAdat( 1 ) ;
		chqbllTrans.setAvarageDate( now ) ;
		chqbllTrans.setDescription( "A" ) ;
		chqbllTrans.setTransYear( 1 ) ;
		chqbllTrans.setTransMonth( "A" ) ;
		chqbllTrans.setExcCode( "A" ) ;
		chqbllTrans.setExcRate( 12.345 ) ;
		chqbllTrans.setExcEquivalent( 12.345 ) ;
		chqbllTrans.setInsertBy( "A" ) ;
		chqbllTrans.setInsertAt( now ) ;
		chqbllTrans.setUpdateBy( "A" ) ;
		chqbllTrans.setUpdateAt( now ) ;
		chqbllTrans.setTransSourceId( 1 ) ;
		chqbllTrans.setTransPointId( 1 ) ;
		chqbllTrans.setPrivateCodeId( 1 ) ;
		chqbllTrans.setContactId( 1 ) ;
		chqbllTrans.setBankId( 1 ) ;
		chqbllTrans.setSafeId( 1 ) ;
		chqbllTrans.setRefModule( "A" ) ;
		chqbllTrans.setRefId( 1 ) ;
		chqbllTrans.setWorkspace( 1 ) ;
		chqbllTrans.setVersion( 1 ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class ChqbllTransCache ..." );
		
		ChqbllTrans chqbllTrans = new ChqbllTrans();
		populate(chqbllTrans);
		System.out.println("Entity populated : " + chqbllTrans );
		
		ChqbllTransCache.putChqbllTrans(chqbllTrans) ;	// Store in cache	
		
		ChqbllTrans chqbllTrans2 = ChqbllTransCache.getChqbllTrans( chqbllTrans.getId() );
		Assert.assertTrue( chqbllTrans == chqbllTrans2 ) ; // Same instance
		
		ChqbllTransCache.removeChqbllTrans(  chqbllTrans.getId() ) ; // Remove from cache	
		
		ChqbllTrans chqbllTrans3 = ChqbllTransCache.getChqbllTrans( chqbllTrans.getId() );
		Assert.assertTrue( null == chqbllTrans3 ) ; // Not in cache
		
	}
}
