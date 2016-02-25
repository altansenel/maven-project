# Python class for table stock_costing_detail 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockCostingDetail object 
#
 
class StockCostingDetail:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,sellDate ,sellQuantity ,sellCostPrice ,sellCostAmount ,buyCostPrice ,buyCostAmount ,profitLossAmount ,transYear ,transMonth ,costingId ,stockId ):
		# super(StockCostingDetailData,self).__init__();
		self.id = id;
		self.sellDate = sellDate;
		self.sellQuantity = sellQuantity;
		self.sellCostPrice = sellCostPrice;
		self.sellCostAmount = sellCostAmount;
		self.buyCostPrice = buyCostPrice;
		self.buyCostAmount = buyCostAmount;
		self.profitLossAmount = profitLossAmount;
		self.transYear = transYear;
		self.transMonth = transMonth;
		self.costingId = costingId;
		self.stockId = stockId;
		