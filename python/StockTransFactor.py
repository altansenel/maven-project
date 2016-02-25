# Python class for table stock_trans_factor 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockTransFactor object 
#
 
class StockTransFactor:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,effect ,quantity ,amount ,transId ,factorId ):
		# super(StockTransFactorData,self).__init__();
		self.id = id;
		self.effect = effect;
		self.quantity = quantity;
		self.amount = amount;
		self.transId = transId;
		self.factorId = factorId;
		