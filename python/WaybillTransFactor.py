# Python class for table waybill_trans_factor 
# Created on 24 Þub 2016 ( Time 15:13:30 )


#
# This class defines the WaybillTransFactor object 
#
 
class WaybillTransFactor:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,effect ,amount ,transId ,factorId ):
		# super(WaybillTransFactorData,self).__init__();
		self.id = id;
		self.effect = effect;
		self.amount = amount;
		self.transId = transId;
		self.factorId = factorId;
		