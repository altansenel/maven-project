# Python class for table stock_barcode 
# Created on 24 Þub 2016 ( Time 15:13:28 )


#
# This class defines the StockBarcode object 
#
 
class StockBarcode:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,barcode ,prefix ,suffix ,unitNo ,isPrimary ,insertBy ,insertAt ,updateBy ,updateAt ,stockId ,workspace ):
		# super(StockBarcodeData,self).__init__();
		self.id = id;
		self.barcode = barcode;
		self.prefix = prefix;
		self.suffix = suffix;
		self.unitNo = unitNo;
		self.isPrimary = isPrimary;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.updateBy = updateBy;
		self.updateAt = updateAt;
		self.stockId = stockId;
		self.workspace = workspace;
		