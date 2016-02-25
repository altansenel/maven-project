# Python class for table safe_trans_source 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the SafeTransSource object 
#
 
class SafeTransSource:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,suitableRight ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(SafeTransSourceData,self).__init__();
		self.id = id;
		self.name = name;
		self.suitableRight = suitableRight;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		