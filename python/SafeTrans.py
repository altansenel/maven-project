# Python class for table safe_trans 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the SafeTrans object 
#
 
class SafeTrans:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,receiptNo ,right ,transDate ,transNo ,transType ,amount ,debt ,credit ,description ,transYear ,transMonth ,excCode ,excRate ,excEquivalent ,insertBy ,insertAt ,updateBy ,updateAt ,transSourceId ,transPointId ,privateCodeId ,safeId ,expenseId ,refModule ,refId ,workspace ,version ):
		# super(SafeTransData,self).__init__();
		self.id = id;
		self.receiptNo = receiptNo;
		self.right = right;
		self.transDate = transDate;
		self.transNo = transNo;
		self.transType = transType;
		self.amount = amount;
		self.debt = debt;
		self.credit = credit;
		self.description = description;
		self.transYear = transYear;
		self.transMonth = transMonth;
		self.excCode = excCode;
		self.excRate = excRate;
		self.excEquivalent = excEquivalent;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.transSourceId = transSourceId;
		self.transPointId = transPointId;
		self.privateCodeId = privateCodeId;
		self.safeId = safeId;
		self.expenseId = expenseId;
		self.refModule = refModule;
		self.refId = refId;
		self.workspace = workspace;
		self.version = version;
		