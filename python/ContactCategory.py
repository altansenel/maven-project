# Python class for table contact_category 
# Created on 24 Þub 2016 ( Time 15:13:26 )


#
# This class defines the ContactCategory object 
#
 
class ContactCategory:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,workingDir ,debtLimit ,creditLimit ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(ContactCategoryData,self).__init__();
		self.id = id;
		self.name = name;
		self.workingDir = workingDir;
		self.debtLimit = debtLimit;
		self.creditLimit = creditLimit;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		