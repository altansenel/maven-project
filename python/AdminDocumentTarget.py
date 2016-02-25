# Python class for table admin_document_target 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminDocumentTarget object 
#
 
class AdminDocumentTarget:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,isLocal ,targetType ,viewType ,path ,isCompressed ,description ,isActive ,version ):
		# super(AdminDocumentTargetData,self).__init__();
		self.id = id;
		self.name = name;
		self.isLocal = isLocal;
		self.targetType = targetType;
		self.viewType = viewType;
		self.path = path;
		self.isCompressed = isCompressed;
		self.description = description;
		self.isActive = isActive;
		self.version = version;
		