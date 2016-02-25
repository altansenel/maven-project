# Python class for table stock_trans_tax 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockTransTax object 
#
 
class StockTransTax:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,taxRate ,basis ,amount ,transId ):
		# super(StockTransTaxData,self).__init__();
		self.id = id;
		self.taxRate = taxRate;
		self.basis = basis;
		self.amount = amount;
		self.transId = transId;
		