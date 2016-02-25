# Python class for table global_currency_rate_detail 
# Created on 24 Þub 2016 ( Time 15:13:26 )


#
# This class defines the GlobalCurrencyRateDetail object 
#
 
class GlobalCurrencyRateDetail:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,date ,code ,name ,buying ,selling ,currencyRateId ):
		# super(GlobalCurrencyRateDetailData,self).__init__();
		self.id = id;
		self.date = date;
		self.code = code;
		self.name = name;
		self.buying = buying;
		self.selling = selling;
		self.currencyRateId = currencyRateId;
		