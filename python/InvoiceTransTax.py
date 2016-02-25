# Python class for table invoice_trans_tax 
# Created on 24 Þub 2016 ( Time 15:13:27 )


#
# This class defines the InvoiceTransTax object 
#
 
class InvoiceTransTax:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,taxRate ,basis ,amount ,transId ):
		# super(InvoiceTransTaxData,self).__init__();
		self.id = id;
		self.taxRate = taxRate;
		self.basis = basis;
		self.amount = amount;
		self.transId = transId;
		