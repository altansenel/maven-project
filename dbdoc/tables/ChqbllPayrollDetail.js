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
chqbll_payroll_detail: new uml.BDDTable({
		id:'chqbll_payroll_detail',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 446 },
        name: 'chqbll_payroll_detail',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																															],
        methods: [
																	'sort: VARCHAR(6)',
														'is_customer: BIT',
														'portfolio_no: INT',
														'row_no: INT',
														'serial_no: VARCHAR(25)',
														'due_date: DATE',
														'amount: DOUBLE',
														'description: VARCHAR(100)',
														'due_year: INT',
														'due_month: VARCHAR(7)',
														'owner: VARCHAR(70)',
														'payment_place: VARCHAR(30)',
														'bank_account_no: VARCHAR(15)',
														'bank_name: VARCHAR(50)',
														'bank_branch: VARCHAR(30)',
														'correspondent_branch: VARCHAR(30)',
														'contact_name: VARCHAR(100)',
														'last_step: VARCHAR(15)',
														'last_contact_name: VARCHAR(100)',
														'surety: VARCHAR(100)',
														'surety_address: VARCHAR(100)',
														'surety_phone1: VARCHAR(15)',
														'surety_phone2: VARCHAR(15)',
														'exc_code: VARCHAR(3)',
														'exc_rate: DOUBLE',
														'exc_equivalent: DOUBLE',
														'total_paid: DOUBLE',
														'cbtype_id: INT',
														'trans_id: INT',
														'trans_source_id: INT',
														'trans_point_id: INT',
														'private_code_id: INT',
														'contact_id: INT',
														'bank_id: INT',
														'workspace: INT',
											]
    }),

	
		
						chqbll_type: new uml.BDDTable({
		id:'chqbll_type',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 170 },
        name: 'chqbll_type',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'sort: VARCHAR(6)',
														'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						chqbll_payroll: new uml.BDDTable({
		id:'chqbll_payroll',
        position: { x:725.7759995228321  , y: 118.59646051284588 },
        size: { width: 220, height: 379 },
        name: 'chqbll_payroll',
        attributes: [
										'id: INT',
																																																																																																																																																																																																														],
        methods: [
																	'sort: VARCHAR(6)',
														'receipt_no: INT',
														'_right: VARCHAR(50)',
														'trans_date: DATE',
														'trans_no: VARCHAR(20)',
														'trans_type: VARCHAR(6)',
														'total: DOUBLE',
														'row_count: INT',
														'adat: INT',
														'avarage_date: DATE',
														'description: VARCHAR(100)',
														'trans_year: INT',
														'trans_month: VARCHAR(7)',
														'exc_code: VARCHAR(3)',
														'exc_rate: DOUBLE',
														'exc_equivalent: DOUBLE',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'trans_source_id: INT',
														'trans_point_id: INT',
														'private_code_id: INT',
														'contact_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						contact: new uml.BDDTable({
		id:'contact',
        position: { x:512.513343960095  , y: -4.5307910843948775 },
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
	
		
						chqbll_payroll_source: new uml.BDDTable({
		id:'chqbll_payroll_source',
        position: { x:270.0000000000001  , y: 38.23085463760208 },
        size: { width: 220, height: 181 },
        name: 'chqbll_payroll_source',
        attributes: [
										'id: INT',
																																																																																],
        methods: [
																	'sort: VARCHAR(6)',
														'name: VARCHAR(30)',
														'suitable_right: VARCHAR(30)',
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
        position: { x:111.710656517073  , y: 226.8727484027592 },
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
	
		
						global_private_code: new uml.BDDTable({
		id:'global_private_code',
        position: { x:111.71065651707295  , y: 473.12725159724073 },
        size: { width: 220, height: 203 },
        name: 'global_private_code',
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
	  
																																																																		
								chqbll_detail_partial: new uml.BDDTable({
		id:'chqbll_detail_partial',
        position: { x:269.99999999999983  , y: 661.7691453623979 },
        size: { width: 220, height: 214 },
        name: 'chqbll_detail_partial',
        attributes: [
										'id: INT',
																																																																																																					],
        methods: [
																	'sort: VARCHAR(6)',
														'is_customer: BIT',
														'trans_date: DATE',
														'amount: DOUBLE',
														'exc_code: VARCHAR(3)',
														'exc_rate: DOUBLE',
														'exc_equivalent: DOUBLE',
														'description: VARCHAR(100)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'detail_id: INT',
														'safe_id: INT',
														'trans_id: INT',
									]
    }),
																																																																																																																																																																																																																																																																																																																																																																																																																																																	
								chqbll_detail_history: new uml.BDDTable({
		id:'chqbll_detail_history',
        position: { x:512.5133439600947  , y: 704.5307910843949 },
        size: { width: 220, height: 170 },
        name: 'chqbll_detail_history',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'sort: VARCHAR(6)',
														'step_date: DATE',
														'step: VARCHAR(15)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'detail_id: INT',
														'contact_id: INT',
														'bank_id: INT',
														'safe_id: INT',
									]
    }),
																																																																																																																																																																												
								chqbll_trans_detail: new uml.BDDTable({
		id:'chqbll_trans_detail',
        position: { x:725.7759995228321  , y: 581.4035394871543 },
        size: { width: 220, height: 93 },
        name: 'chqbll_trans_detail',
        attributes: [
										'id: INT',
																								],
        methods: [
																	'trans_id: INT',
														'detail_id: INT',
									]
    }),
																																																			};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
	new joint.dia.Link({
	source: { id: classes.chqbll_payroll_detail.id },
	target: { id: classes.chqbll_type.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_detail_ibfk_1' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.chqbll_payroll_detail.id },
	target: { id: classes.chqbll_payroll.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_detail_ibfk_2' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.chqbll_payroll_detail.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_detail_ibfk_3' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.chqbll_payroll_detail.id },
	target: { id: classes.chqbll_payroll_source.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_detail_ibfk_4' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.chqbll_payroll_detail.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_detail_ibfk_5' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.chqbll_payroll_detail.id },
	target: { id: classes.global_private_code.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_detail_ibfk_6' } }}
	]
}),	
	 
																																																																		new joint.dia.Link({
	source: { id: classes.chqbll_detail_partial.id },
	target: { id: classes.chqbll_payroll_detail.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_detail_partial_ibfk_2' } }}
	]
}),	
																																																																																																																																																																																																																																																																																																																																																																																																																																																	new joint.dia.Link({
	source: { id: classes.chqbll_detail_history.id },
	target: { id: classes.chqbll_payroll_detail.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_detail_history_ibfk_4' } }}
	]
}),	
																																																																																																																																																																												new joint.dia.Link({
	source: { id: classes.chqbll_trans_detail.id },
	target: { id: classes.chqbll_payroll_detail.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_trans_detail_ibfk_2' } }}
	]
}),	
																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonChqbllPayrollDetailGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonChqbllPayrollDetailGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


