# Python class for table chqbll_trans 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the ChqbllTrans object 
#
 
class ChqbllTrans:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,sort ,receiptNo ,right ,fromStep ,toStep ,transDate ,transNo ,transType ,total ,rowCount ,adat ,avarageDate ,description ,transYear ,transMonth ,excCode ,excRate ,excEquivalent ,insertBy ,insertAt ,updateBy ,updateAt ,transSourceId ,transPointId ,privateCodeId ,contactId ,bankId ,safeId ,refModule ,refId ,workspace ,version ):
		# super(ChqbllTransData,self).__init__();
		self.id = id;
		self.sort = sort;
		self.receiptNo = receiptNo;
		self.right = right;
		self.fromStep = fromStep;
		self.toStep = toStep;
		self.transDate = transDate;
		self.transNo = transNo;
		self.transType = transType;
		self.total = total;
		self.rowCount = rowCount;
		self.adat = adat;
		self.avarageDate = avarageDate;
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
		self.contactId = contactId;
		self.bankId = bankId;
		self.safeId = safeId;
		self.refModule = refModule;
		self.refId = refId;
		self.workspace = workspace;
		self.version = version;
		