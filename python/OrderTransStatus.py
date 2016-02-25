# Python class for table order_trans_status 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the OrderTransStatus object 
#
 
class OrderTransStatus:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,parentId ,name ,ordering ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(OrderTransStatusData,self).__init__();
		self.id = id;
		self.parentId = parentId;
		self.name = name;
		self.ordering = ordering;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		