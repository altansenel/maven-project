# Python class for table global_currency_rate 
# Created on 24 Þub 2016 ( Time 15:13:26 )


#
# This class defines the GlobalCurrencyRate object 
#
 
class GlobalCurrencyRate:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,date ,source ,insertBy ,insertAt ,updateBy ,updateAt ,version ):
		# super(GlobalCurrencyRateData,self).__init__();
		self.id = id;
		self.date = date;
		self.source = source;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.version = version;
		