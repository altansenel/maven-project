# Python class for table admin_user 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminUser object 
#
 
class AdminUser:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,username ,title ,email ,authToken ,passwordHash ,isAdmin ,isActive ,profile ,workspace ,userGroupId ,version ):
		# super(AdminUserData,self).__init__();
		self.id = id;
		self.username = username;
		self.title = title;
		self.email = email;
		self.authToken = authToken;
		self.passwordHash = passwordHash;
		self.isAdmin = isAdmin;
		self.isActive = isActive;
		self.profile = profile;
		self.workspace = workspace;
		self.userGroupId = userGroupId;
		self.version = version;
		