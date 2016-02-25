# Python class for table stock_cost_factor 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockCostFactor object 
#
 
class StockCostFactor:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,factorType ,calcType ,effectType ,effect ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(StockCostFactorData,self).__init__();
		self.id = id;
		self.name = name;
		self.factorType = factorType;
		self.calcType = calcType;
		self.effectType = effectType;
		self.effect = effect;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		