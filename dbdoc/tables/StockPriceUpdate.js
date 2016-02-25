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
stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 347 },
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

	
		
						stock_category: new uml.BDDTable({
		id:'stock_category',
        position: { x:810.0  , y: 350.0 },
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
	
		
						stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:761.7691453623979  , y: 170.00000000000003 },
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
        position: { x:630.0  , y: 38.23085463760208 },
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
        position: { x:450.0  , y: -10.0 },
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
        position: { x:270.0000000000001  , y: 38.23085463760208 },
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
        position: { x:138.23085463760208  , y: 170.00000000000003 },
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
        position: { x:90.0  , y: 349.99999999999994 },
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
        position: { x:138.23085463760208  , y: 530.0 },
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
        position: { x:269.99999999999983  , y: 661.7691453623979 },
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
        position: { x:449.99999999999994  , y: 710.0 },
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
        position: { x:630.0  , y: 661.7691453623979 },
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
	  
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
								stock_price_update_detail: new uml.BDDTable({
		id:'stock_price_update_detail',
        position: { x:761.7691453623978  , y: 530.0000000000002 },
        size: { width: 220, height: 115 },
        name: 'stock_price_update_detail',
        attributes: [
										'id: INT',
																																						],
        methods: [
																	'price_update_id: INT',
														'stock_id: INT',
														'buy_price: DOUBLE',
														'sell_price: DOUBLE',
									]
    }),
																																																												};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
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
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_10' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_11' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_2' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_3' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_4' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_5' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_6' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_7' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_8' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock_price_update.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_ibfk_9' } }}
	]
}),	
	 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												new joint.dia.Link({
	source: { id: classes.stock_price_update_detail.id },
	target: { id: classes.stock_price_update.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_update_detail_ibfk_1' } }}
	]
}),	
																																																												];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonStockPriceUpdateGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonStockPriceUpdateGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


