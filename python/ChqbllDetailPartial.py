# Python class for table chqbll_detail_partial 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the ChqbllDetailPartial object 
#
 
class ChqbllDetailPartial:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,sort ,isCustomer ,transDate ,amount ,excCode ,excRate ,excEquivalent ,description ,insertBy ,insertAt ,detailId ,safeId ,transId ):
		# super(ChqbllDetailPartialData,self).__init__();
		self.id = id;
		self.sort = sort;
		self.isCustomer = isCustomer;
		self.transDate = transDate;
		self.amount = amount;
		self.excCode = excCode;
		self.excRate = excRate;
		self.excEquivalent = excEquivalent;
		self.description = description;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.detailId = detailId;
		self.safeId = safeId;
		self.transId = transId;
		