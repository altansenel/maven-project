# Python class for table stock_price_update 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockPriceUpdate object 
#
 
class StockPriceUpdate:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,execDate ,effectType ,effectDirection ,effect ,description ,buyPrice ,sellPrice ,providerCode ,insertBy ,insertAt ,updateBy ,updateAt ,categoryId ,extraField0Id ,extraField1Id ,extraField2Id ,extraField3Id ,extraField4Id ,extraField5Id ,extraField6Id ,extraField7Id ,extraField8Id ,extraField9Id ,workspace ,version ):
		# super(StockPriceUpdateData,self).__init__();
		self.id = id;
		self.name = name;
		self.execDate = execDate;
		self.effectType = effectType;
		self.effectDirection = effectDirection;
		self.effect = effect;
		self.description = description;
		self.buyPrice = buyPrice;
		self.sellPrice = sellPrice;
		self.providerCode = providerCode;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
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
		self.workspace = workspace;
		self.version = version;
		