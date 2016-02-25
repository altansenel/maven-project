# Python class for table admin_user_group 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminUserGroup object 
#
 
class AdminUserGroup:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,description ,editingTimeout ,editingLimit ,hasEditDifDate ,version ):
		# super(AdminUserGroupData,self).__init__();
		self.id = id;
		self.name = name;
		self.description = description;
		self.editingTimeout = editingTimeout;
		self.editingLimit = editingLimit;
		self.hasEditDifDate = hasEditDifDate;
		self.version = version;
		