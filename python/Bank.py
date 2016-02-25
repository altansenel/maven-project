# Python class for table bank 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the Bank object 
#
 
class Bank:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,accountNo ,name ,branch ,city ,iban ,excCode ,insertBy ,insertAt ,updateBy ,updateAt ,isActive ,workspace ,version ):
		# super(BankData,self).__init__();
		self.id = id;
		self.accountNo = accountNo;
		self.name = name;
		self.branch = branch;
		self.city = city;
		self.iban = iban;
		self.excCode = excCode;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.isActive = isActive;
		self.workspace = workspace;
		self.version = version;
		