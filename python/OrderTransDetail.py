# Python class for table order_trans_detail 
# Created on 24 Þub 2016 ( Time 15:13:27 )


#
# This class defines the OrderTransDetail object 
#
 
class OrderTransDetail:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,receiptNo ,right ,transDate ,deliveryDate ,transType ,rowNo ,stockId ,name ,quantity ,unit ,unitRatio ,basePrice ,price ,taxRate ,discountRate1 ,discountRate2 ,discountRate3 ,amount ,taxAmount ,discountAmount ,total ,description ,transYear ,transMonth ,unit1 ,unit2 ,unit3 ,unit2ratio ,unit3ratio ,excCode ,excRate ,excEquivalent ,plusFactorAmount ,minusFactorAmount ,input ,output ,inTotal ,outTotal ,netInput ,netOutput ,netInTotal ,netOutTotal ,completed ,cancelled ,isTransfer ,transId ,depotId ,contactId ,sellerId ,transSourceId ,transPointId ,privateCodeId ,statusId ,workspace ):
		# super(OrderTransDetailData,self).__init__();
		self.id = id;
		self.receiptNo = receiptNo;
		self.right = right;
		self.transDate = transDate;
		self.deliveryDate = deliveryDate;
		self.transType = transType;
		self.rowNo = rowNo;
		self.stockId = stockId;
		self.name = name;
		self.quantity = quantity;
		self.unit = unit;
		self.unitRatio = unitRatio;
		self.basePrice = basePrice;
		self.price = price;
		self.taxRate = taxRate;
		self.discountRate1 = discountRate1;
		self.discountRate2 = discountRate2;
		self.discountRate3 = discountRate3;
		self.amount = amount;
		self.taxAmount = taxAmount;
		self.discountAmount = discountAmount;
		self.total = total;
		self.description = description;
		self.transYear = transYear;
		self.transMonth = transMonth;
		self.unit1 = unit1;
		self.unit2 = unit2;
		self.unit3 = unit3;
		self.unit2ratio = unit2ratio;
		self.unit3ratio = unit3ratio;
		self.excCode = excCode;
		self.excRate = excRate;
		self.excEquivalent = excEquivalent;
		self.plusFactorAmount = plusFactorAmount;
		self.minusFactorAmount = minusFactorAmount;
		self.input = input;
		self.output = output;
		self.inTotal = inTotal;
		self.outTotal = outTotal;
		self.netInput = netInput;
		self.netOutput = netOutput;
		self.netInTotal = netInTotal;
		self.netOutTotal = netOutTotal;
		self.completed = completed;
		self.cancelled = cancelled;
		self.isTransfer = isTransfer;
		self.transId = transId;
		self.depotId = depotId;
		self.contactId = contactId;
		self.sellerId = sellerId;
		self.transSourceId = transSourceId;
		self.transPointId = transPointId;
		self.privateCodeId = privateCodeId;
		self.statusId = statusId;
		self.workspace = workspace;
		