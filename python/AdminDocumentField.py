# Python class for table admin_document_field 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminDocumentField object 
#
 
class AdminDocumentField:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,module ,band ,type ,name ,nickName ,hiddenField ,label ,originalLabel ,labelWidth ,labelAlign ,width ,row ,column ,format ,prefix ,suffix ,value ,msgPrefix ,defauld ,isDbField ,tableType ,reportTitleDocId ,pageTitleDocId ,detailDocId ,pageFooterDocId ,reportFooterDocId ):
		# super(AdminDocumentFieldData,self).__init__();
		self.id = id;
		self.module = module;
		self.band = band;
		self.type = type;
		self.name = name;
		self.nickName = nickName;
		self.hiddenField = hiddenField;
		self.label = label;
		self.originalLabel = originalLabel;
		self.labelWidth = labelWidth;
		self.labelAlign = labelAlign;
		self.width = width;
		self.row = row;
		self.column = column;
		self.format = format;
		self.prefix = prefix;
		self.suffix = suffix;
		self.value = value;
		self.msgPrefix = msgPrefix;
		self.defauld = defauld;
		self.isDbField = isDbField;
		self.tableType = tableType;
		self.reportTitleDocId = reportTitleDocId;
		self.pageTitleDocId = pageTitleDocId;
		self.detailDocId = detailDocId;
		self.pageFooterDocId = pageFooterDocId;
		self.reportFooterDocId = reportFooterDocId;
		