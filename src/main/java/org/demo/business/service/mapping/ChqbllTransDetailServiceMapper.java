/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.ChqbllTransDetail;
import org.demo.bean.jpa.ChqbllTransDetailEntity;
import org.demo.bean.jpa.ChqbllPayrollDetailEntity;
import org.demo.bean.jpa.ChqbllTransEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ChqbllTransDetailServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public ChqbllTransDetailServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'ChqbllTransDetailEntity' to 'ChqbllTransDetail'
	 * @param chqbllTransDetailEntity
	 */
	public ChqbllTransDetail mapChqbllTransDetailEntityToChqbllTransDetail(ChqbllTransDetailEntity chqbllTransDetailEntity) {
		if(chqbllTransDetailEntity == null) {
			return null;
		}

		//--- Generic mapping 
		ChqbllTransDetail chqbllTransDetail = map(chqbllTransDetailEntity, ChqbllTransDetail.class);

		//--- Link mapping ( link to ChqbllPayrollDetail )
		if(chqbllTransDetailEntity.getChqbllPayrollDetail() != null) {
			chqbllTransDetail.setDetailId(chqbllTransDetailEntity.getChqbllPayrollDetail().getId());
		}
		//--- Link mapping ( link to ChqbllTrans )
		if(chqbllTransDetailEntity.getChqbllTrans() != null) {
			chqbllTransDetail.setTransId(chqbllTransDetailEntity.getChqbllTrans().getId());
		}
		return chqbllTransDetail;
	}
	
	/**
	 * Mapping from 'ChqbllTransDetail' to 'ChqbllTransDetailEntity'
	 * @param chqbllTransDetail
	 * @param chqbllTransDetailEntity
	 */
	public void mapChqbllTransDetailToChqbllTransDetailEntity(ChqbllTransDetail chqbllTransDetail, ChqbllTransDetailEntity chqbllTransDetailEntity) {
		if(chqbllTransDetail == null) {
			return;
		}

		//--- Generic mapping 
		map(chqbllTransDetail, chqbllTransDetailEntity);

		//--- Link mapping ( link : chqbllTransDetail )
		if( hasLinkToChqbllPayrollDetail(chqbllTransDetail) ) {
			ChqbllPayrollDetailEntity chqbllPayrollDetail1 = new ChqbllPayrollDetailEntity();
			chqbllPayrollDetail1.setId( chqbllTransDetail.getDetailId() );
			chqbllTransDetailEntity.setChqbllPayrollDetail( chqbllPayrollDetail1 );
		} else {
			chqbllTransDetailEntity.setChqbllPayrollDetail( null );
		}

		//--- Link mapping ( link : chqbllTransDetail )
		if( hasLinkToChqbllTrans(chqbllTransDetail) ) {
			ChqbllTransEntity chqbllTrans2 = new ChqbllTransEntity();
			chqbllTrans2.setId( chqbllTransDetail.getTransId() );
			chqbllTransDetailEntity.setChqbllTrans( chqbllTrans2 );
		} else {
			chqbllTransDetailEntity.setChqbllTrans( null );
		}

	}
	
	/**
	 * Verify that ChqbllPayrollDetail id is valid.
	 * @param ChqbllPayrollDetail ChqbllPayrollDetail
	 * @return boolean
	 */
	private boolean hasLinkToChqbllPayrollDetail(ChqbllTransDetail chqbllTransDetail) {
		if(chqbllTransDetail.getDetailId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that ChqbllTrans id is valid.
	 * @param ChqbllTrans ChqbllTrans
	 * @return boolean
	 */
	private boolean hasLinkToChqbllTrans(ChqbllTransDetail chqbllTransDetail) {
		if(chqbllTransDetail.getTransId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}