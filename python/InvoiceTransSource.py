# Python class for table invoice_trans_source 
# Created on 24 Þub 2016 ( Time 15:13:27 )


#
# This class defines the InvoiceTransSource object 
#
 
class InvoiceTransSource:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,suitableRight ,hasCostEffect ,hasStockEffect ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(InvoiceTransSourceData,self).__init__();
		self.id = id;
		self.name = name;
		self.suitableRight = suitableRight;
		self.hasCostEffect = hasCostEffect;
		self.hasStockEffect = hasStockEffect;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		