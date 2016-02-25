# Python class for table stock_trans_currency 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockTransCurrency object 
#
 
class StockTransCurrency:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,currency ,amount ,transId ):
		# super(StockTransCurrencyData,self).__init__();
		self.id = id;
		self.currency = currency;
		self.amount = amount;
		self.transId = transId;
		