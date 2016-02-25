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
stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 358 },
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

	
		
						global_trans_point: new uml.BDDTable({
		id:'global_trans_point',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 203 },
        name: 'global_trans_point',
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
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:783.7861876440435  , y: 215.14162637027167 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:708.9623281219144  , y: 99.922986634761 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:596.4251915072881  , y: 21.123635248663675 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:462.56381881290037  , y: -9.78069772687445 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:326.87274840275927  , y: 11.710656517072948 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_category: new uml.BDDTable({
		id:'stock_category',
        position: { x:209.11298171081114  , y: 82.46786282813798 },
        size: { width: 220, height: 203 },
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
	
		
						stock: new uml.BDDTable({
		id:'stock',
        position: { x:126.43414333229993  , y: 192.18638715593204 },
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
	
		
						stock_depot: new uml.BDDTable({
		id:'stock_depot',
        position: { x:90.87694190646329  , y: 324.88766945211484 },
        size: { width: 220, height: 159 },
        name: 'stock_depot',
        attributes: [
										'id: INT',
																																																																		],
        methods: [
																	'name: VARCHAR(50)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:107.61965413374475  , y: 461.2461179749812 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:174.22400047716786  , y: 581.4035394871541 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:280.99023739707934  , y: 667.8611334292137 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:412.36975322364447  , y: 708.0278823325784 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:549.2294480941194  , y: 696.0542105377949 },
        size: { width: 220, height: 170 },
        name: 'stock_extra_fields',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'extra_fields_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	  
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
								stock_costing_inventory: new uml.BDDTable({
		id:'stock_costing_inventory',
        position: { x:671.6381311172369  , y: 633.6838712984201 },
        size: { width: 220, height: 159 },
        name: 'stock_costing_inventory',
        attributes: [
										'id: INT',
																																																																		],
        methods: [
																	'_date: DATE',
														'input: DOUBLE',
														'remain: DOUBLE',
														'price: DOUBLE',
														'amount: DOUBLE',
														'costing_id: INT',
														'stock_id: INT',
														'depot_id: INT',
									]
    }),
																																																																																																						
								stock_costing_detail: new uml.BDDTable({
		id:'stock_costing_detail',
        position: { x:761.7691453623978  , y: 530.0000000000002 },
        size: { width: 220, height: 192 },
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
																														};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
	new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_1' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_10' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_11' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_12' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_13' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_14' } }}
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
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_3' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_depot.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_4' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_5' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_6' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_7' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_8' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_costing.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_ibfk_9' } }}
	]
}),	
	 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									new joint.dia.Link({
	source: { id: classes.stock_costing_inventory.id },
	target: { id: classes.stock_costing.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_inventory_ibfk_1' } }}
	]
}),	
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
																														];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonStockCostingGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonStockCostingGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


