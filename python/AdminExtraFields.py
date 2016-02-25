# Python class for table admin_extra_fields 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminExtraFields object 
#
 
class AdminExtraFields:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,idno ,distinction ,name ,isRequired ,isActive ):
		# super(AdminExtraFieldsData,self).__init__();
		self.id = id;
		self.idno = idno;
		self.distinction = distinction;
		self.name = name;
		self.isRequired = isRequired;
		self.isActive = isActive;
		