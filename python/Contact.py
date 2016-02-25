# Python class for table contact 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the Contact object 
#
 
class Contact:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,code ,name ,taxOffice ,taxNumber ,tcKimlik ,relevant ,phone ,fax ,mobilePhone ,address1 ,address2 ,city ,country ,email ,website ,status ,excCode ,note ,isActive ,insertBy ,insertAt ,updateBy ,updateAt ,sellerId ,categoryId ,priceListId ,extraField0Id ,extraField1Id ,extraField2Id ,extraField3Id ,extraField4Id ,extraField5Id ,extraField6Id ,extraField7Id ,extraField8Id ,extraField9Id ,workspace ,version ):
		# super(ContactData,self).__init__();
		self.id = id;
		self.code = code;
		self.name = name;
		self.taxOffice = taxOffice;
		self.taxNumber = taxNumber;
		self.tcKimlik = tcKimlik;
		self.relevant = relevant;
		self.phone = phone;
		self.fax = fax;
		self.mobilePhone = mobilePhone;
		self.address1 = address1;
		self.address2 = address2;
		self.city = city;
		self.country = country;
		self.email = email;
		self.website = website;
		self.status = status;
		self.excCode = excCode;
		self.note = note;
		self.isActive = isActive;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.sellerId = sellerId;
		self.categoryId = categoryId;
		self.priceListId = priceListId;
		self.extraField0Id = extraField0Id;
		self.extraField1Id = extraField1Id;
		self.extraField2Id = extraField2Id;
		self.extraField3Id = extraField3Id;
		self.extraField4Id = extraField4Id;
		self.extraField5Id = extraField5Id;
		self.extraField6Id = extraField6Id;
		self.extraField7Id = extraField7Id;
		self.extraField8Id = extraField8Id;
		self.extraField9Id = extraField9Id;
		self.workspace = workspace;
		self.version = version;
		