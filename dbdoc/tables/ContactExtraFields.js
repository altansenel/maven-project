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
contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 160 },
        name: 'contact_extra_fields',
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

	  
																																																																																																																																																																																																																		
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:741.2461179749811  , y: 138.39730917470968 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:561.2461179749811  , y: 7.619654133744746 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:338.7538820250189  , y: 7.619654133744689 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
														
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:158.75388202501898  , y: 138.39730917470962 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:90.0  , y: 349.99999999999994 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:158.75388202501892  , y: 561.6026908252903 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:338.75388202501887  , y: 692.3803458662553 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:561.246117974981  , y: 692.3803458662553 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
								
								contact: new uml.BDDTable({
		id:'contact',
        position: { x:741.246117974981  , y: 561.6026908252904 },
        size: { width: 220, height: 489 },
        name: 'contact',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																				],
        methods: [
																	'code: VARCHAR(30)',
														'name: VARCHAR(100)',
														'tax_office: VARCHAR(20)',
														'tax_number: VARCHAR(15)',
														'tc_kimlik: VARCHAR(11)',
														'relevant: VARCHAR(30)',
														'phone: VARCHAR(15)',
														'fax: VARCHAR(15)',
														'mobile_phone: VARCHAR(15)',
														'address1: VARCHAR(100)',
														'address2: VARCHAR(100)',
														'city: VARCHAR(20)',
														'country: VARCHAR(20)',
														'email: VARCHAR(100)',
														'website: VARCHAR(100)',
														'status: VARCHAR(12)',
														'exc_code: VARCHAR(3)',
														'note: TEXT',
														'is_active: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'seller_id: INT',
														'category_id: INT',
														'price_list_id: INT',
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
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
																																																																																																																																																																																																																		new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_10' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_11' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_12' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_13' } }}
	]
}),	
														new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_4' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_5' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_6' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_7' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_8' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_9' } }}
	]
}),	
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonContactExtraFieldsGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonContactExtraFieldsGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


