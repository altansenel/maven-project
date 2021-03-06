/*
 * Created on 24 �ub 2016 ( Time 16:27:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import org.demo.bean.Contact;
import org.demo.bean.jpa.ContactCategoryEntity;
import org.demo.bean.jpa.ContactEntity;
import org.demo.bean.jpa.ContactExtraFieldsEntity;
import org.demo.bean.jpa.SaleSellerEntity;
import org.demo.bean.jpa.StockPriceListEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ContactServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public ContactServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'ContactEntity' to 'Contact'
	 * @param contactEntity
	 */
	public Contact mapContactEntityToContact(ContactEntity contactEntity) {
		if(contactEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Contact contact = map(contactEntity, Contact.class);

		//--- Link mapping ( link to ContactCategory )
		if(contactEntity.getContactCategory() != null) {
			contact.setCategoryId(contactEntity.getContactCategory().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields3() != null) {
			contact.setExtraField8Id(contactEntity.getContactExtraFields3().getId());
		}
		//--- Link mapping ( link to SaleSeller )
		if(contactEntity.getSaleSeller() != null) {
			contact.setSellerId(contactEntity.getSaleSeller().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields6() != null) {
			contact.setExtraField1Id(contactEntity.getContactExtraFields6().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields8() != null) {
			contact.setExtraField3Id(contactEntity.getContactExtraFields8().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields10() != null) {
			contact.setExtraField5Id(contactEntity.getContactExtraFields10().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields2() != null) {
			contact.setExtraField7Id(contactEntity.getContactExtraFields2().getId());
		}
		//--- Link mapping ( link to StockPriceList )
		if(contactEntity.getStockPriceList() != null) {
			contact.setPriceListId(contactEntity.getStockPriceList().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields4() != null) {
			contact.setExtraField9Id(contactEntity.getContactExtraFields4().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields5() != null) {
			contact.setExtraField0Id(contactEntity.getContactExtraFields5().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields7() != null) {
			contact.setExtraField2Id(contactEntity.getContactExtraFields7().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields9() != null) {
			contact.setExtraField4Id(contactEntity.getContactExtraFields9().getId());
		}
		//--- Link mapping ( link to ContactExtraFields )
		if(contactEntity.getContactExtraFields() != null) {
			contact.setExtraField6Id(contactEntity.getContactExtraFields().getId());
		}
		return contact;
	}
	
	/**
	 * Mapping from 'Contact' to 'ContactEntity'
	 * @param contact
	 * @param contactEntity
	 */
	public void mapContactToContactEntity(Contact contact, ContactEntity contactEntity) {
		if(contact == null) {
			return;
		}

		//--- Generic mapping 
		map(contact, contactEntity);

		//--- Link mapping ( link : contact )
		if( hasLinkToContactCategory(contact) ) {
			ContactCategoryEntity contactCategory1 = new ContactCategoryEntity();
			contactCategory1.setId( contact.getCategoryId() );
			contactEntity.setContactCategory( contactCategory1 );
		} else {
			contactEntity.setContactCategory( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields2 = new ContactExtraFieldsEntity();
			contactExtraFields2.setId( contact.getExtraField8Id() );
			contactEntity.setContactExtraFields3( contactExtraFields2 );
		} else {
			contactEntity.setContactExtraFields3( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToSaleSeller(contact) ) {
			SaleSellerEntity saleSeller3 = new SaleSellerEntity();
			saleSeller3.setId( contact.getSellerId() );
			contactEntity.setSaleSeller( saleSeller3 );
		} else {
			contactEntity.setSaleSeller( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields4 = new ContactExtraFieldsEntity();
			contactExtraFields4.setId( contact.getExtraField1Id() );
			contactEntity.setContactExtraFields6( contactExtraFields4 );
		} else {
			contactEntity.setContactExtraFields6( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields5 = new ContactExtraFieldsEntity();
			contactExtraFields5.setId( contact.getExtraField3Id() );
			contactEntity.setContactExtraFields8( contactExtraFields5 );
		} else {
			contactEntity.setContactExtraFields8( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields6 = new ContactExtraFieldsEntity();
			contactExtraFields6.setId( contact.getExtraField5Id() );
			contactEntity.setContactExtraFields10( contactExtraFields6 );
		} else {
			contactEntity.setContactExtraFields10( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields7 = new ContactExtraFieldsEntity();
			contactExtraFields7.setId( contact.getExtraField7Id() );
			contactEntity.setContactExtraFields2( contactExtraFields7 );
		} else {
			contactEntity.setContactExtraFields2( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToStockPriceList(contact) ) {
			StockPriceListEntity stockPriceList8 = new StockPriceListEntity();
			stockPriceList8.setId( contact.getPriceListId() );
			contactEntity.setStockPriceList( stockPriceList8 );
		} else {
			contactEntity.setStockPriceList( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields9 = new ContactExtraFieldsEntity();
			contactExtraFields9.setId( contact.getExtraField9Id() );
			contactEntity.setContactExtraFields4( contactExtraFields9 );
		} else {
			contactEntity.setContactExtraFields4( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields10 = new ContactExtraFieldsEntity();
			contactExtraFields10.setId( contact.getExtraField0Id() );
			contactEntity.setContactExtraFields5( contactExtraFields10 );
		} else {
			contactEntity.setContactExtraFields5( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields11 = new ContactExtraFieldsEntity();
			contactExtraFields11.setId( contact.getExtraField2Id() );
			contactEntity.setContactExtraFields7( contactExtraFields11 );
		} else {
			contactEntity.setContactExtraFields7( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields12 = new ContactExtraFieldsEntity();
			contactExtraFields12.setId( contact.getExtraField4Id() );
			contactEntity.setContactExtraFields9( contactExtraFields12 );
		} else {
			contactEntity.setContactExtraFields9( null );
		}

		//--- Link mapping ( link : contact )
		if( hasLinkToContactExtraFields(contact) ) {
			ContactExtraFieldsEntity contactExtraFields13 = new ContactExtraFieldsEntity();
			contactExtraFields13.setId( contact.getExtraField6Id() );
			contactEntity.setContactExtraFields( contactExtraFields13 );
		} else {
			contactEntity.setContactExtraFields( null );
		}

	}
	
	/**
	 * Verify that ContactCategory id is valid.
	 * @param ContactCategory ContactCategory
	 * @return boolean
	 */
	private boolean hasLinkToContactCategory(Contact contact) {
		if(contact.getCategoryId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that ContactExtraFields id is valid.
	 * @param ContactExtraFields ContactExtraFields
	 * @return boolean
	 */
	private boolean hasLinkToContactExtraFields(Contact contact) {
		if(contact.getExtraField8Id() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that SaleSeller id is valid.
	 * @param SaleSeller SaleSeller
	 * @return boolean
	 */
	private boolean hasLinkToSaleSeller(Contact contact) {
		if(contact.getSellerId() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Verify that StockPriceList id is valid.
	 * @param StockPriceList StockPriceList
	 * @return boolean
	 */
	private boolean hasLinkToStockPriceList(Contact contact) {
		if(contact.getPriceListId() != null) {
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