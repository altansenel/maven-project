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
stock_category: new uml.BDDTable({
		id:'stock_category',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 193 },
        name: 'stock_category',
        attributes: [
										'id: INT',
																																																																																														],
        methods: [
																	'par1id: INT',
														'par2id: INT',
														'par3id: INT',
														'par4id: INT',
														'par5id: INT',
														'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'workspace: INT',
														'version: INT',
											]
    }),

	  
																													
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 346 },
        name: 'sale_campaign',
        attributes: [
										'id: INT',
																																																																																																																																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'start_date: DATE',
														'end_date: DATE',
														'discount_rate1: DOUBLE',
														'discount_rate2: DOUBLE',
														'discount_rate3: DOUBLE',
														'priority: TINYINT',
														'stock_category_id: INT',
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
																																																																																																																																																					
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:561.2461179749811  , y: 7.619654133744746 },
        size: { width: 220, height: 357 },
        name: 'stock_price_update',
        attributes: [
										'id: INT',
																																																																																																																																																																																																],
        methods: [
																	'name: VARCHAR(30)',
														'exec_date: DATETIME',
														'effect_type: VARCHAR(7)',
														'effect_direction: VARCHAR(8)',
														'effect: DOUBLE',
														'description: VARCHAR(50)',
														'buy_price: BIT',
														'sell_price: BIT',
														'provider_code: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
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
														'workspace: INT',
														'version: INT',
									]
    }),
																																																																																							
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:158.75388202501898  , y: 138.39730917470962 },
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
																																																																																																			
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:158.75388202501892  , y: 561.6026908252903 },
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
																																																																																																																																																																															
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:561.246117974981  , y: 692.3803458662553 },
        size: { width: 220, height: 368 },
        name: 'stock_price_list',
        attributes: [
										'id: INT',
																																																																																																																																																																																																							],
        methods: [
																	'name: VARCHAR(30)',
														'start_date: DATETIME',
														'end_date: DATETIME',
														'is_sell_price: BIT',
														'effect_type: VARCHAR(7)',
														'effect_direction: VARCHAR(8)',
														'effect: DOUBLE',
														'description: VARCHAR(50)',
														'provider_code: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
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
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
																																																																																																																																																																																																	};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
																													new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_category.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_1' } }}
	]
}),	
																																																																																																																																																					new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_category.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_1' } }}
	]
}),	
																																																																																							new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_category.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_1' } }}
	]
}),	
																																																																																																			new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_category.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_2' } }}
	]
}),	
																																																																																																																																																																															new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_category.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_1' } }}
	]
}),	
																																																																																																																																																																																																	];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonStockCategoryGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonStockCategoryGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


