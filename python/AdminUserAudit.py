# Python class for table admin_user_audit 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminUserAudit object 
#
 
class AdminUserAudit:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,username ,date ,right ,ip ,description ,logLevel ,workspace ):
		# super(AdminUserAuditData,self).__init__();
		self.id = id;
		self.username = username;
		self.date = date;
		self.right = right;
		self.ip = ip;
		self.description = description;
		self.logLevel = logLevel;
		self.workspace = workspace;
		