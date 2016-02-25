# Python class for table invoice_trans_factor 
# Created on 24 Þub 2016 ( Time 15:13:27 )


#
# This class defines the InvoiceTransFactor object 
#
 
class InvoiceTransFactor:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,effect ,amount ,transId ,factorId ):
		# super(InvoiceTransFactorData,self).__init__();
		self.id = id;
		self.effect = effect;
		self.amount = amount;
		self.transId = transId;
		self.factorId = factorId;
		