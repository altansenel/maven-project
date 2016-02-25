# Python class for table waybill_trans_relation 
# Created on 24 Þub 2016 ( Time 15:13:30 )


#
# This class defines the WaybillTransRelation object 
#
 
class WaybillTransRelation:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,relId ,relRight ,relReceiptNo ,transId ):
		# super(WaybillTransRelationData,self).__init__();
		self.id = id;
		self.relId = relId;
		self.relRight = relRight;
		self.relReceiptNo = relReceiptNo;
		self.transId = transId;
		