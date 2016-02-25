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
sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 336 },
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
        position: { x:755.2973146163133  , y: 159.22906487604624 },
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
        position: { x:607.8136128440678  , y: 26.43414333229987 },
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
        position: { x:412.3697532236448  , y: -8.027882332578429 },
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
        position: { x:228.36186888276302  , y: 66.31612870158006 },
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
        position: { x:111.710656517073  , y: 226.8727484027592 },
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
        position: { x:97.86686373582995  , y: 424.8482086943933 },
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
        position: { x:191.03767187808563  , y: 600.077013365239 },
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
        position: { x:362.9081175841196  , y: 699.3064614593587 },
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
        position: { x:561.246117974981  , y: 692.3803458662553 },
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
        position: { x:725.7759995228321  , y: 581.4035394871543 },
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
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_10' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_11' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_2' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_3' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_4' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_5' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_6' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_7' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_8' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.sale_campaign.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'sale_campaign_ibfk_9' } }}
	]
}),	
	 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonSaleCampaignGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonSaleCampaignGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


