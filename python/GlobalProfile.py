# Python class for table global_profile 
# Created on 24 Þub 2016 ( Time 15:13:26 )


#
# This class defines the GlobalProfile object 
#
 
class GlobalProfile:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,description ,isActive ,jsonData ,version ):
		# super(GlobalProfileData,self).__init__();
		self.id = id;
		self.name = name;
		self.description = description;
		self.isActive = isActive;
		self.jsonData = jsonData;
		self.version = version;
		