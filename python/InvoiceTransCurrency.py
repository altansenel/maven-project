# Python class for table invoice_trans_currency 
# Created on 24 Þub 2016 ( Time 15:13:26 )


#
# This class defines the InvoiceTransCurrency object 
#
 
class InvoiceTransCurrency:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,currency ,amount ,transId ):
		# super(InvoiceTransCurrencyData,self).__init__();
		self.id = id;
		self.currency = currency;
		self.amount = amount;
		self.transId = transId;
		