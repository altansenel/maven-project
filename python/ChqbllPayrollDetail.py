# Python class for table chqbll_payroll_detail 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the ChqbllPayrollDetail object 
#
 
class ChqbllPayrollDetail:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,sort ,isCustomer ,portfolioNo ,rowNo ,serialNo ,dueDate ,amount ,description ,dueYear ,dueMonth ,owner ,paymentPlace ,bankAccountNo ,bankName ,bankBranch ,correspondentBranch ,contactName ,lastStep ,lastContactName ,surety ,suretyAddress ,suretyPhone1 ,suretyPhone2 ,excCode ,excRate ,excEquivalent ,totalPaid ,cbtypeId ,transId ,transSourceId ,transPointId ,privateCodeId ,contactId ,bankId ,workspace ):
		# super(ChqbllPayrollDetailData,self).__init__();
		self.id = id;
		self.sort = sort;
		self.isCustomer = isCustomer;
		self.portfolioNo = portfolioNo;
		self.rowNo = rowNo;
		self.serialNo = serialNo;
		self.dueDate = dueDate;
		self.amount = amount;
		self.description = description;
		self.dueYear = dueYear;
		self.dueMonth = dueMonth;
		self.owner = owner;
		self.paymentPlace = paymentPlace;
		self.bankAccountNo = bankAccountNo;
		self.bankName = bankName;
		self.bankBranch = bankBranch;
		self.correspondentBranch = correspondentBranch;
		self.contactName = contactName;
		self.lastStep = lastStep;
		self.lastContactName = lastContactName;
		self.surety = surety;
		self.suretyAddress = suretyAddress;
		self.suretyPhone1 = suretyPhone1;
		self.suretyPhone2 = suretyPhone2;
		self.excCode = excCode;
		self.excRate = excRate;
		self.excEquivalent = excEquivalent;
		self.totalPaid = totalPaid;
		self.cbtypeId = cbtypeId;
		self.transId = transId;
		self.transSourceId = transSourceId;
		self.transPointId = transPointId;
		self.privateCodeId = privateCodeId;
		self.contactId = contactId;
		self.bankId = bankId;
		self.workspace = workspace;
		