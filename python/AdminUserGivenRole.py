# Python class for table admin_user_given_role 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminUserGivenRole object 
#
 
class AdminUserGivenRole:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,userGroupId ,workspaceId ,userRoleId ):
		# super(AdminUserGivenRoleData,self).__init__();
		self.id = id;
		self.userGroupId = userGroupId;
		self.workspaceId = workspaceId;
		self.userRoleId = userRoleId;
		