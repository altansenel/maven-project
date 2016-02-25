# Python class for table stock_price_update_detail 
# Created on 24 Þub 2016 ( Time 15:13:29 )


#
# This class defines the StockPriceUpdateDetail object 
#
 
class StockPriceUpdateDetail:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,priceUpdateId ,stockId ,buyPrice ,sellPrice ):
		# super(StockPriceUpdateDetailData,self).__init__();
		self.id = id;
		self.priceUpdateId = priceUpdateId;
		self.stockId = stockId;
		self.buyPrice = buyPrice;
		self.sellPrice = sellPrice;
		