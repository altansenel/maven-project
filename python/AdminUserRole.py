# Python class for table admin_user_role 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminUserRole object 
#
 
class AdminUserRole:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,insertBy ,insertAt ,updateBy ,updateAt ,version ):
		# super(AdminUserRoleData,self).__init__();
		self.id = id;
		self.name = name;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.version = version;
		