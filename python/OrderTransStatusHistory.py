# Python class for table order_trans_status_history 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the OrderTransStatusHistory object 
#
 
class OrderTransStatusHistory:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,transTime ,transId ,statusId ,username ,description ):
		# super(OrderTransStatusHistoryData,self).__init__();
		self.id = id;
		self.transTime = transTime;
		self.transId = transId;
		self.statusId = statusId;
		self.username = username;
		self.description = description;
		