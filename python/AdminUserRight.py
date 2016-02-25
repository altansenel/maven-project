# Python class for table admin_user_right 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminUserRight object 
#
 
class AdminUserRight:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,rightLevel ,isCrud ,userRoleId ):
		# super(AdminUserRightData,self).__init__();
		self.id = id;
		self.name = name;
		self.rightLevel = rightLevel;
		self.isCrud = isCrud;
		self.userRoleId = userRoleId;
		