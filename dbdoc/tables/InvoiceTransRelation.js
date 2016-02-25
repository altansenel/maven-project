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
invoice_trans_relation: new uml.BDDTable({
		id:'invoice_trans_relation',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 105 },
        name: 'invoice_trans_relation',
        attributes: [
										'id: INT',
																																						],
        methods: [
																	'rel_id: INT',
														'rel_right: VARCHAR(30)',
														'rel_receipt_no: INT',
														'trans_id: INT',
											]
    }),

	
		
						invoice_trans: new uml.BDDTable({
		id:'invoice_trans',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 654 },
        name: 'invoice_trans',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																																																																																																																													],
        methods: [
																	'receipt_no: INT',
														'_right: VARCHAR(50)',
														'is_cash: BIT',
														'is_completed: BIT',
														'trans_date: DATE',
														'real_date: DATETIME',
														'delivery_date: DATETIME',
														'trans_no: VARCHAR(20)',
														'is_tax_include: BIT',
														'rounding_digits: BIT',
														'total: DOUBLE',
														'discount_total: DOUBLE',
														'subtotal: DOUBLE',
														'rounding_discount: DOUBLE',
														'total_discount_rate: DOUBLE',
														'tax_total: DOUBLE',
														'net_total: DOUBLE',
														'plus_factor_total: DOUBLE',
														'minus_factor_total: DOUBLE',
														'withholding_rate: DOUBLE',
														'withholding_before: DOUBLE',
														'withholding_amount: DOUBLE',
														'withholding_after: DOUBLE',
														'description: VARCHAR(100)',
														'trans_year: INT',
														'trans_month: VARCHAR(7)',
														'contact_id: INT',
														'contact_name: VARCHAR(100)',
														'contact_tax_office: VARCHAR(20)',
														'contact_tax_number: VARCHAR(15)',
														'contact_address1: VARCHAR(100)',
														'contact_address2: VARCHAR(100)',
														'consigner: VARCHAR(50)',
														'recepient: VARCHAR(50)',
														'trans_type: VARCHAR(6)',
														'exc_code: VARCHAR(3)',
														'exc_rate: DOUBLE',
														'exc_equivalent: DOUBLE',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'contact_trans_id: INT',
														'seller_id: INT',
														'trans_source_id: INT',
														'trans_point_id: INT',
														'private_code_id: INT',
														'depot_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'status_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	  
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
	new joint.dia.Link({
	source: { id: classes.invoice_trans_relation.id },
	target: { id: classes.invoice_trans.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'invoice_trans_relation_ibfk_1' } }}
	]
}),	
	 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonInvoiceTransRelationGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonInvoiceTransRelationGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


