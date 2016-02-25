var graph = new joint.dia.Graph;

var paper = new joint.dia.Paper({
    el: $('#paper'),
    width: 800,
    height:600,
    gridSize: 1,
    model: graph
});
paper.scale(.75);
if(document.getElementById("zoom")) {
	document.getElementById("zoom").value=0.8;
}

/*var paperSmall = new joint.dia.Paper({
    el: $('#paper-small'),
    width: 250,
    height: 250,
    model: graph
});

paperSmall.scale(.2);
*/


paper.on('cell:pointerup', function(cellView , evt) {
	if(evt.ctrlKey) {
		
		//transforms TABLE_NAME in DToName ex: BOOK_ORDER becomes BookOrder
		var viewToFind = cellView.model.id.toLowerCase();
		var elem = viewToFind.split('_');
		viewToFind = "";

		for(var i= 0; i < elem.length; i++)
		{
			viewToFind = viewToFind	+ elem[i].charAt(0).toUpperCase() + elem[i].slice(1);
		}
		document.location.href="./"+viewToFind+".html";
	}   	
});


/*define positionning of different beans around central bean*/

var uml = joint.shapes.uml;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													
   var classes = {  
admin_document: new uml.BDDTable({
		id:'admin_document',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 347 },
        name: 'admin_document',
        attributes: [
										'id: INT',
																																																																																																																																																																																																],
        methods: [
																	'module: VARCHAR(10)',
														'header: VARCHAR(20)',
														'_right: VARCHAR(50)',
														'name: VARCHAR(20)',
														'page_rows: INT',
														'report_title_rows: INT',
														'page_title_rows: INT',
														'detail_rows: INT',
														'page_footer_rows: INT',
														'report_footer_rows: INT',
														'report_title_labels: BIT',
														'page_title_labels: BIT',
														'detail_labels: BIT',
														'page_footer_labels: BIT',
														'report_footer_labels: BIT',
														'left_margin: INT',
														'top_margin: INT',
														'bottom_margin: INT',
														'is_single_page: BIT',
														'has_paging: BIT',
														'column_title_type: VARCHAR(7)',
														'carrying_over_name: VARCHAR(50)',
														'description: VARCHAR(30)',
														'template_rows: TEXT',
														'is_active: BIT',
														'version: INT',
											]
    }),

	  
																																																																																																																																																																																																																																																																																																																																																																																																																																																									
								admin_document_field: new uml.BDDTable({
		id:'admin_document_field',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 357 },
        name: 'admin_document_field',
        attributes: [
										'id: INT',
																																																																																																																																																																																																],
        methods: [
																	'module: VARCHAR(10)',
														'band: VARCHAR(12)',
														'_type: VARCHAR(20)',
														'name: VARCHAR(100)',
														'nick_name: VARCHAR(100)',
														'hidden_field: VARCHAR(100)',
														'_label: VARCHAR(70)',
														'original_label: VARCHAR(70)',
														'label_width: INT',
														'label_align: VARCHAR(5)',
														'_width: INT',
														'_row: INT',
														'_column: INT',
														'_format: VARCHAR(30)',
														'prefix: VARCHAR(5)',
														'suffix: VARCHAR(5)',
														'_value: VARCHAR(70)',
														'msg_prefix: VARCHAR(30)',
														'defauld: VARCHAR(50)',
														'is_db_field: BIT',
														'table_type: VARCHAR(10)',
														'report_title_doc_id: INT',
														'page_title_doc_id: INT',
														'detail_doc_id: INT',
														'page_footer_doc_id: INT',
														'report_footer_doc_id: INT',
									]
    }),
								
								admin_document_field: new uml.BDDTable({
		id:'admin_document_field',
        position: { x:561.2461179749811  , y: 7.619654133744746 },
        size: { width: 220, height: 357 },
        name: 'admin_document_field',
        attributes: [
										'id: INT',
																																																																																																																																																																																																],
        methods: [
																	'module: VARCHAR(10)',
														'band: VARCHAR(12)',
														'_type: VARCHAR(20)',
														'name: VARCHAR(100)',
														'nick_name: VARCHAR(100)',
														'hidden_field: VARCHAR(100)',
														'_label: VARCHAR(70)',
														'original_label: VARCHAR(70)',
														'label_width: INT',
														'label_align: VARCHAR(5)',
														'_width: INT',
														'_row: INT',
														'_column: INT',
														'_format: VARCHAR(30)',
														'prefix: VARCHAR(5)',
														'suffix: VARCHAR(5)',
														'_value: VARCHAR(70)',
														'msg_prefix: VARCHAR(30)',
														'defauld: VARCHAR(50)',
														'is_db_field: BIT',
														'table_type: VARCHAR(10)',
														'report_title_doc_id: INT',
														'page_title_doc_id: INT',
														'detail_doc_id: INT',
														'page_footer_doc_id: INT',
														'report_footer_doc_id: INT',
									]
    }),
								
								admin_document_field: new uml.BDDTable({
		id:'admin_document_field',
        position: { x:158.75388202501898  , y: 138.39730917470962 },
        size: { width: 220, height: 357 },
        name: 'admin_document_field',
        attributes: [
										'id: INT',
																																																																																																																																																																																																],
        methods: [
																	'module: VARCHAR(10)',
														'band: VARCHAR(12)',
														'_type: VARCHAR(20)',
														'name: VARCHAR(100)',
														'nick_name: VARCHAR(100)',
														'hidden_field: VARCHAR(100)',
														'_label: VARCHAR(70)',
														'original_label: VARCHAR(70)',
														'label_width: INT',
														'label_align: VARCHAR(5)',
														'_width: INT',
														'_row: INT',
														'_column: INT',
														'_format: VARCHAR(30)',
														'prefix: VARCHAR(5)',
														'suffix: VARCHAR(5)',
														'_value: VARCHAR(70)',
														'msg_prefix: VARCHAR(30)',
														'defauld: VARCHAR(50)',
														'is_db_field: BIT',
														'table_type: VARCHAR(10)',
														'report_title_doc_id: INT',
														'page_title_doc_id: INT',
														'detail_doc_id: INT',
														'page_footer_doc_id: INT',
														'report_footer_doc_id: INT',
									]
    }),
								
								admin_document_field: new uml.BDDTable({
		id:'admin_document_field',
        position: { x:158.75388202501892  , y: 561.6026908252903 },
        size: { width: 220, height: 357 },
        name: 'admin_document_field',
        attributes: [
										'id: INT',
																																																																																																																																																																																																],
        methods: [
																	'module: VARCHAR(10)',
														'band: VARCHAR(12)',
														'_type: VARCHAR(20)',
														'name: VARCHAR(100)',
														'nick_name: VARCHAR(100)',
														'hidden_field: VARCHAR(100)',
														'_label: VARCHAR(70)',
														'original_label: VARCHAR(70)',
														'label_width: INT',
														'label_align: VARCHAR(5)',
														'_width: INT',
														'_row: INT',
														'_column: INT',
														'_format: VARCHAR(30)',
														'prefix: VARCHAR(5)',
														'suffix: VARCHAR(5)',
														'_value: VARCHAR(70)',
														'msg_prefix: VARCHAR(30)',
														'defauld: VARCHAR(50)',
														'is_db_field: BIT',
														'table_type: VARCHAR(10)',
														'report_title_doc_id: INT',
														'page_title_doc_id: INT',
														'detail_doc_id: INT',
														'page_footer_doc_id: INT',
														'report_footer_doc_id: INT',
									]
    }),
								
								admin_document_field: new uml.BDDTable({
		id:'admin_document_field',
        position: { x:561.246117974981  , y: 692.3803458662553 },
        size: { width: 220, height: 357 },
        name: 'admin_document_field',
        attributes: [
										'id: INT',
																																																																																																																																																																																																],
        methods: [
																	'module: VARCHAR(10)',
														'band: VARCHAR(12)',
														'_type: VARCHAR(20)',
														'name: VARCHAR(100)',
														'nick_name: VARCHAR(100)',
														'hidden_field: VARCHAR(100)',
														'_label: VARCHAR(70)',
														'original_label: VARCHAR(70)',
														'label_width: INT',
														'label_align: VARCHAR(5)',
														'_width: INT',
														'_row: INT',
														'_column: INT',
														'_format: VARCHAR(30)',
														'prefix: VARCHAR(5)',
														'suffix: VARCHAR(5)',
														'_value: VARCHAR(70)',
														'msg_prefix: VARCHAR(30)',
														'defauld: VARCHAR(50)',
														'is_db_field: BIT',
														'table_type: VARCHAR(10)',
														'report_title_doc_id: INT',
														'page_title_doc_id: INT',
														'detail_doc_id: INT',
														'page_footer_doc_id: INT',
														'report_footer_doc_id: INT',
									]
    }),
																																																																																																																																																																																																																																																																			};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
																																																																																																																																																																																																																																																																																																																																																																																																																																																									new joint.dia.Link({
	source: { id: classes.admin_document_field.id },
	target: { id: classes.admin_document.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_document_field_ibfk_1' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.admin_document_field.id },
	target: { id: classes.admin_document.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_document_field_ibfk_2' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.admin_document_field.id },
	target: { id: classes.admin_document.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_document_field_ibfk_3' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.admin_document_field.id },
	target: { id: classes.admin_document.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_document_field_ibfk_4' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.admin_document_field.id },
	target: { id: classes.admin_document.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_document_field_ibfk_5' } }}
	]
}),	
																																																																																																																																																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonAdminDocumentGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonAdminDocumentGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


