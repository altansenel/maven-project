# Python class for table stock_costing 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockCosting object 
#
 
class StockCosting:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,properties ,execDate ,calcDate ,costingType ,providerCode ,transPointId ,categoryId ,depotId ,stockId ,extraField0Id ,extraField1Id ,extraField2Id ,extraField3Id ,extraField4Id ,extraField5Id ,extraField6Id ,extraField7Id ,extraField8Id ,extraField9Id ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(StockCostingData,self).__init__();
		self.id = id;
		self.name = name;
		self.properties = properties;
		self.execDate = execDate;
		self.calcDate = calcDate;
		self.costingType = costingType;
		self.providerCode = providerCode;
		self.transPointId = transPointId;
		self.categoryId = categoryId;
		self.depotId = depotId;
		self.stockId = stockId;
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
		