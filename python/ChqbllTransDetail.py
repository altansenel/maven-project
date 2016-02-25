# Python class for table chqbll_trans_detail 
# Created on 24 Þub 2016 ( Time 15:13:25 )


#
# This class defines the ChqbllTransDetail object 
#
 
class ChqbllTransDetail:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,transId ,detailId ):
		# super(ChqbllTransDetailData,self).__init__();
		self.id = id;
		self.transId = transId;
		self.detailId = detailId;
		