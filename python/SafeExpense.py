# Python class for table safe_expense 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the SafeExpense object 
#
 
class SafeExpense:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,name ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(SafeExpenseData,self).__init__();
		self.id = id;
		self.name = name;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		