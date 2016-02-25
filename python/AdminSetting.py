# Python class for table admin_setting 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminSetting object 
#
 
class AdminSetting:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,code ,description ,insertBy ,insertAt ,updateBy ,updateAt ,jsonData ,version ):
		# super(AdminSettingData,self).__init__();
		self.id = id;
		self.code = code;
		self.description = description;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.jsonData = jsonData;
		self.version = version;
		