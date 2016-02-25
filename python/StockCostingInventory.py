# Python class for table stock_costing_inventory 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockCostingInventory object 
#
 
class StockCostingInventory:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,date ,input ,remain ,price ,amount ,costingId ,stockId ,depotId ):
		# super(StockCostingInventoryData,self).__init__();
		self.id = id;
		self.date = date;
		self.input = input;
		self.remain = remain;
		self.price = price;
		self.amount = amount;
		self.costingId = costingId;
		self.stockId = stockId;
		self.depotId = depotId;
		