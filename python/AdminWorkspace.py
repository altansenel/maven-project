# Python class for table admin_workspace 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the AdminWorkspace object 
#
 
class AdminWorkspace:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,description ,startDate ,endDate ,hasDateRestriction ,isActive ,version ):
		# super(AdminWorkspaceData,self).__init__();
		self.id = id;
		self.name = name;
		self.description = description;
		self.startDate = startDate;
		self.endDate = endDate;
		self.hasDateRestriction = hasDateRestriction;
		self.isActive = isActive;
		self.version = version;
		