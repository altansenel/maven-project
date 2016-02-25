# Python class for table invoice_trans_relation 
# Created on 24 Þub 2016 ( Time 15:13:27 )


#
# This class defines the InvoiceTransRelation object 
#
 
class InvoiceTransRelation:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,relId ,relRight ,relReceiptNo ,transId ):
		# super(InvoiceTransRelationData,self).__init__();
		self.id = id;
		self.relId = relId;
		self.relRight = relRight;
		self.relReceiptNo = relReceiptNo;
		self.transId = transId;
		