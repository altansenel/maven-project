# Python class for table order_trans 
# Created on 24 Þub 2016 ( Time 15:13:27 )


#
# This class defines the OrderTrans object 
#
 
class OrderTrans:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,receiptNo ,right ,isCompleted ,transDate ,realDate ,deliveryDate ,transNo ,isTaxInclude ,roundingDigits ,total ,discountTotal ,subtotal ,roundingDiscount ,totalDiscountRate ,taxTotal ,netTotal ,plusFactorTotal ,minusFactorTotal ,description ,transYear ,transMonth ,contactId ,contactName ,contactTaxOffice ,contactTaxNumber ,contactAddress1 ,contactAddress2 ,consigner ,recepient ,transType ,excCode ,excRate ,excEquivalent ,isTransfer ,insertBy ,insertAt ,updateBy ,updateAt ,contactTransId ,sellerId ,transSourceId ,transPointId ,privateCodeId ,depotId ,waybillId ,invoiceId ,refModule ,refId ,statusId ,workspace ,version ):
		# super(OrderTransData,self).__init__();
		self.id = id;
		self.receiptNo = receiptNo;
		self.right = right;
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
		self.isTransfer = isTransfer;
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
		self.waybillId = waybillId;
		self.invoiceId = invoiceId;
		self.refModule = refModule;
		self.refId = refId;
		self.statusId = statusId;
		self.workspace = workspace;
		self.version = version;
		