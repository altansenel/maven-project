# Python class for table stock_trans_source 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockTransSource object 
#
 
class StockTransSource:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,suitableRight ,hasCostEffect ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(StockTransSourceData,self).__init__();
		self.id = id;
		self.name = name;
		self.suitableRight = suitableRight;
		self.hasCostEffect = hasCostEffect;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		