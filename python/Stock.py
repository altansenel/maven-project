# Python class for table stock 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the Stock object 
#
 
class Stock:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,code ,name ,excCode ,providerCode ,unit1 ,unit2 ,unit3 ,unit2ratio ,unit3ratio ,buyPrice ,sellPrice ,buyTax ,sellTax ,taxRate2 ,taxRate3 ,primRate ,maxLimit ,minLimit ,note ,categoryId ,extraField0Id ,extraField1Id ,extraField2Id ,extraField3Id ,extraField4Id ,extraField5Id ,extraField6Id ,extraField7Id ,extraField8Id ,extraField9Id ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(StockData,self).__init__();
		self.id = id;
		self.code = code;
		self.name = name;
		self.excCode = excCode;
		self.providerCode = providerCode;
		self.unit1 = unit1;
		self.unit2 = unit2;
		self.unit3 = unit3;
		self.unit2ratio = unit2ratio;
		self.unit3ratio = unit3ratio;
		self.buyPrice = buyPrice;
		self.sellPrice = sellPrice;
		self.buyTax = buyTax;
		self.sellTax = sellTax;
		self.taxRate2 = taxRate2;
		self.taxRate3 = taxRate3;
		self.primRate = primRate;
		self.maxLimit = maxLimit;
		self.minLimit = minLimit;
		self.note = note;
		self.categoryId = categoryId;
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
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		