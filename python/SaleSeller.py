# Python class for table sale_seller 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the SaleSeller object 
#
 
class SaleSeller:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,primRate ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(SaleSellerData,self).__init__();
		self.id = id;
		self.name = name;
		self.primRate = primRate;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		