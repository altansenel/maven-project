# Python class for table chqbll_type 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the ChqbllType object 
#
 
class ChqbllType:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,sort ,name ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(ChqbllTypeData,self).__init__();
		self.id = id;
		self.sort = sort;
		self.name = name;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		