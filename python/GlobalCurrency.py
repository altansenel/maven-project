# Python class for table global_currency 
# Created on 24 Þub 2016 ( Time 15:13:26 )


#
# This class defines the GlobalCurrency object 
#
 
class GlobalCurrency:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,code ,name ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,version ):
		# super(GlobalCurrencyData,self).__init__();
		self.id = id;
		self.code = code;
		self.name = name;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.version = version;
		