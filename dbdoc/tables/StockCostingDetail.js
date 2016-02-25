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
stock_costing_detail: new uml.BDDTable({
		id:'stock_costing_detail',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 182 },
        name: 'stock_costing_detail',
        attributes: [
										'id: INT',
																																																																																							],
        methods: [
																	'sell_date: DATE',
														'sell_quantity: DOUBLE',
														'sell_cost_price: DOUBLE',
														'sell_cost_amount: DOUBLE',
														'buy_cost_price: DOUBLE',
														'buy_cost_amount: DOUBLE',
														'profit_loss_amount: DOUBLE',
														'trans_year: INT',
														'trans_month: VARCHAR(7)',
														'costing_id: INT',
														'stock_id: INT',
											]
    }),

	
		
						stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 368 },
        name: 'stock_costing',
        attributes: [
										'id: INT',
																																																																																																																																																																																																							],
        methods: [
																	'name: VARCHAR(30)',
														'properties: VARCHAR(100)',
														'exec_date: DATETIME',
														'calc_date: DATE',
														'costing_type: VARCHAR(8)',
														'provider_code: VARCHAR(30)',
														'trans_point_id: INT',
														'category_id: INT',
														'depot_id: INT',
														'stock_id: INT',
														'extra_field0_id: INT',
														'extra_field1_id: INT',
														'extra_field2_id: INT',
														'extra_field3_id: INT',
														'extra_field4_id: INT',
														'extra_field5_id: INT',
														'extra_field6_id: INT',
														'extra_field7_id: INT',
														'extra_field8_id: INT',
														'extra_field9_id: INT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock: new uml.BDDTable({
		id:'stock',
        position: { x:90.0  , y: 349.99999999999994 },
        size: { width: 220, height: 478 },
        name: 'stock',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																													],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'exc_code: VARCHAR(3)',
														'provider_code: VARCHAR(30)',
														'unit1: VARCHAR(6)',
														'unit2: VARCHAR(6)',
														'unit3: VARCHAR(6)',
														'unit2ratio: DOUBLE',
														'unit3ratio: DOUBLE',
														'buy_price: DOUBLE',
														'sell_price: DOUBLE',
														'buy_tax: DOUBLE',
														'sell_tax: DOUBLE',
														'tax_rate2: DOUBLE',
														'tax_rate3: DOUBLE',
														'prim_rate: DOUBLE',
														'max_limit: DOUBLE',
														'min_limit: DOUBLE',
														'note: TEXT',
														'category_id: INT',
														'extra_field0_id: INT',
														'extra_field1_id: INT',
														'extra_field2_id: INT',
														'extra_field3_id: INT',
														'extra_field4_id: INT',
														'extra_field5_id: INT',
														'extra_field6_id: INT',
														'extra_field7_id: INT',
														'extra_field8_id: INT',
														'extra_field9_id: INT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
	  
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
	new joint.dia.Link({
	source: { id: classes.stock_costing_detail.id },
	target: { id: classes.stock_costing.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_detail_ibfk_1' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing_detail.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_detail_ibfk_2' } }}
	]
}),	
	 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonStockCostingDetailGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonStockCostingDetailGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


