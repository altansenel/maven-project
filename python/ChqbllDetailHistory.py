# Python class for table chqbll_detail_history 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the ChqbllDetailHistory object 
#
 
class ChqbllDetailHistory:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,sort ,stepDate ,step ,insertBy ,insertAt ,detailId ,contactId ,bankId ,safeId ):
		# super(ChqbllDetailHistoryData,self).__init__();
		self.id = id;
		self.sort = sort;
		self.stepDate = stepDate;
		self.step = step;
		self.insertBy = insertBy;
		self.insertAt = insertAt;
		self.detailId = detailId;
		self.contactId = contactId;
		self.bankId = bankId;
		self.safeId = safeId;
		