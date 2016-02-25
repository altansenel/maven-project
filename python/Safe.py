# Python class for table safe 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the Safe object 
#
 
class Safe:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,excCode ,responsible ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(SafeData,self).__init__();
		self.id = id;
		self.name = name;
		self.excCode = excCode;
		self.responsible = responsible;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		