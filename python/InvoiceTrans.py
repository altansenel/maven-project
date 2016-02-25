# Python class for table invoice_trans 
# Created on 24 Þub 2016 ( Time 15:13:26 )


#
# This class defines the InvoiceTrans object 
#
 
class InvoiceTrans:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,receiptNo ,right ,isCash ,isCompleted ,transDate ,realDate ,deliveryDate ,transNo ,isTaxInclude ,roundingDigits ,total ,discountTotal ,subtotal ,roundingDiscount ,totalDiscountRate ,taxTotal ,netTotal ,plusFactorTotal ,minusFactorTotal ,withholdingRate ,withholdingBefore ,withholdingAmount ,withholdingAfter ,description ,transYear ,transMonth ,contactId ,contactName ,contactTaxOffice ,contactTaxNumber ,contactAddress1 ,contactAddress2 ,consigner ,recepient ,transType ,excCode ,excRate ,excEquivalent ,insertBy ,insertAt ,updateBy ,updateAt ,contactTransId ,sellerId ,transSourceId ,transPointId ,privateCodeId ,depotId ,refModule ,refId ,statusId ,workspace ,version ):
		# super(InvoiceTransData,self).__init__();
		self.id = id;
		self.receiptNo = receiptNo;
		self.right = right;
		self.isCash = isCash;
		self.isCompleted = isCompleted;
		self.transDate = transDate;
		self.realDate = realDate;
		self.deliveryDate = deliveryDate;
		self.transNo = transNo;
		self.isTaxInclude = isTaxInclude;
		self.roundingDigits = roundingDigits;
		self.total = total;
		self.discountTotal = discountTotal;
		self.subtotal = subtotal;
		self.roundingDiscount = roundingDiscount;
		self.totalDiscountRate = totalDiscountRate;
		self.taxTotal = taxTotal;
		self.netTotal = netTotal;
		self.plusFactorTotal = plusFactorTotal;
		self.minusFactorTotal = minusFactorTotal;
		self.withholdingRate = withholdingRate;
		self.withholdingBefore = withholdingBefore;
		self.withholdingAmount = withholdingAmount;
		self.withholdingAfter = withholdingAfter;
		self.description = description;
		self.transYear = transYear;
		self.transMonth = transMonth;
		self.contactId = contactId;
		self.contactName = contactName;
		self.contactTaxOffice = contactTaxOffice;
		self.contactTaxNumber = contactTaxNumber;
		self.contactAddress1 = contactAddress1;
		self.contactAddress2 = contactAddress2;
		self.consigner = consigner;
		self.recepient = recepient;
		self.transType = transType;
		self.excCode = excCode;
		self.excRate = excRate;
		self.excEquivalent = excEquivalent;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.contactTransId = contactTransId;
		self.sellerId = sellerId;
		self.transSourceId = transSourceId;
		self.transPointId = transPointId;
		self.privateCodeId = privateCodeId;
		self.depotId = depotId;
		self.refModule = refModule;
		self.refId = refId;
		self.statusId = statusId;
		self.workspace = workspace;
		self.version = version;
		