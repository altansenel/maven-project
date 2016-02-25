# Python class for table stock_category 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the StockCategory object 
#
 
class StockCategory:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,par1id ,par2id ,par3id ,par4id ,par5id ,name ,insertBy ,insertAt ,updateBy ,updateAt ,workspace ,version ):
		# super(StockCategoryData,self).__init__();
		self.id = id;
		self.par1id = par1id;
		self.par2id = par2id;
		self.par3id = par3id;
		self.par4id = par4id;
		self.par5id = par5id;
		self.name = name;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.workspace = workspace;
		self.version = version;
		