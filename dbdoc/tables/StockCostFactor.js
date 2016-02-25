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
stock_cost_factor: new uml.BDDTable({
		id:'stock_cost_factor',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 193 },
        name: 'stock_cost_factor',
        attributes: [
										'id: INT',
																																																																																														],
        methods: [
																	'name: VARCHAR(30)',
														'factor_type: VARCHAR(8)',
														'calc_type: VARCHAR(7)',
														'effect_type: VARCHAR(7)',
														'effect: DOUBLE',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
											]
    }),

	  
																																																																																																																																						
								invoice_trans_factor: new uml.BDDTable({
		id:'invoice_trans_factor',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 115 },
        name: 'invoice_trans_factor',
        attributes: [
										'id: INT',
																																						],
        methods: [
																	'effect: DOUBLE',
														'amount: DOUBLE',
														'trans_id: INT',
														'factor_id: INT',
									]
    }),
												
								waybill_trans_factor: new uml.BDDTable({
		id:'waybill_trans_factor',
        position: { x:450.0  , y: -10.0 },
        size: { width: 220, height: 115 },
        name: 'waybill_trans_factor',
        attributes: [
										'id: INT',
																																						],
        methods: [
																	'effect: DOUBLE',
														'amount: DOUBLE',
														'trans_id: INT',
														'factor_id: INT',
									]
    }),
																																																																																																																		
								stock_trans_factor: new uml.BDDTable({
		id:'stock_trans_factor',
        position: { x:90.0  , y: 349.99999999999994 },
        size: { width: 220, height: 126 },
        name: 'stock_trans_factor',
        attributes: [
										'id: INT',
																																													],
        methods: [
																	'effect: DOUBLE',
														'quantity: DOUBLE',
														'amount: DOUBLE',
														'trans_id: INT',
														'factor_id: INT',
									]
    }),
																																																																																																																																																																																																																																																																	
								order_trans_factor: new uml.BDDTable({
		id:'order_trans_factor',
        position: { x:449.99999999999994  , y: 710.0 },
        size: { width: 220, height: 115 },
        name: 'order_trans_factor',
        attributes: [
										'id: INT',
																																						],
        methods: [
																	'effect: DOUBLE',
														'amount: DOUBLE',
														'trans_id: INT',
														'factor_id: INT',
									]
    }),
																																																																																																																																																																																																																		};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
																																																																																																																																						new joint.dia.Link({
	source: { id: classes.invoice_trans_factor.id },
	target: { id: classes.stock_cost_factor.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'invoice_trans_factor_ibfk_2' } }}
	]
}),	
												new joint.dia.Link({
	source: { id: classes.waybill_trans_factor.id },
	target: { id: classes.stock_cost_factor.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'waybill_trans_factor_ibfk_2' } }}
	]
}),	
																																																																																																																		new joint.dia.Link({
	source: { id: classes.stock_trans_factor.id },
	target: { id: classes.stock_cost_factor.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_trans_factor_ibfk_2' } }}
	]
}),	
																																																																																																																																																																																																																																																																	new joint.dia.Link({
	source: { id: classes.order_trans_factor.id },
	target: { id: classes.stock_cost_factor.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_factor_ibfk_2' } }}
	]
}),	
																																																																																																																																																																																																																		];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonStockCostFactorGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonStockCostFactorGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


