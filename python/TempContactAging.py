# Python class for table temp_contact_aging 
# Created on 24 Þub 2016 ( Time 15:13:30 )


#
# This class defines the TempContactAging object 
#
 
class TempContactAging:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,username ,contactName ,receiptNo ,right ,transDate ,transNo ,amount ,paid ,remain ,excCode ,description ):
		# super(TempContactAgingData,self).__init__();
		self.username = username;
		self.contactName = contactName;
		self.receiptNo = receiptNo;
		self.right = right;
		self.transDate = transDate;
		self.transNo = transNo;
		self.amount = amount;
		self.paid = paid;
		self.remain = remain;
		self.excCode = excCode;
		self.description = description;
		