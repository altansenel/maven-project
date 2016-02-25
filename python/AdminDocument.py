# Python class for table admin_document 
# Created on 24 Þub 2016 ( Time 15:13:24 )


#
# This class defines the AdminDocument object 
#
 
class AdminDocument:
	
	# Default constructor.
	def __init__(self):
		pass
     
	def __init__(self ,id ,module ,header ,right ,name ,pageRows ,reportTitleRows ,pageTitleRows ,detailRows ,pageFooterRows ,reportFooterRows ,reportTitleLabels ,pageTitleLabels ,detailLabels ,pageFooterLabels ,reportFooterLabels ,leftMargin ,topMargin ,bottomMargin ,isSinglePage ,hasPaging ,columnTitleType ,carryingOverName ,description ,templateRows ,isActive ,version ):
		# super(AdminDocumentData,self).__init__();
		self.id = id;
		self.module = module;
		self.header = header;
		self.right = right;
		self.name = name;
		self.pageRows = pageRows;
		self.reportTitleRows = reportTitleRows;
		self.pageTitleRows = pageTitleRows;
		self.detailRows = detailRows;
		self.pageFooterRows = pageFooterRows;
		self.reportFooterRows = reportFooterRows;
		self.reportTitleLabels = reportTitleLabels;
		self.pageTitleLabels = pageTitleLabels;
		self.detailLabels = detailLabels;
		self.pageFooterLabels = pageFooterLabels;
		self.reportFooterLabels = reportFooterLabels;
		self.leftMargin = leftMargin;
		self.topMargin = topMargin;
		self.bottomMargin = bottomMargin;
		self.isSinglePage = isSinglePage;
		self.hasPaging = hasPaging;
		self.columnTitleType = columnTitleType;
		self.carryingOverName = carryingOverName;
		self.description = description;
		self.templateRows = templateRows;
		self.isActive = isActive;
		self.version = version;
		