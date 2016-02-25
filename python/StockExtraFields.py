# Python class for table stock_extra_fields 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockExtraFields object 
#
 
class StockExtraFields:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,extraFieldsId ,workspace ,version ):
		# super(StockExtraFieldsData,self).__init__();
		self.id = id;
		self.name = name;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.extraFieldsId = extraFieldsId;
		self.workspace = workspace;
		self.version = version;
		