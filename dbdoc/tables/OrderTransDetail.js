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
order_trans_detail: new uml.BDDTable({
		id:'order_trans_detail',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 655 },
        name: 'order_trans_detail',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																																																																																																																																				],
        methods: [
																	'receipt_no: INT',
														'_right: VARCHAR(50)',
														'trans_date: DATE',
														'delivery_date: DATE',
														'trans_type: VARCHAR(6)',
														'row_no: INT',
														'stock_id: INT',
														'name: VARCHAR(100)',
														'quantity: DOUBLE',
														'unit: VARCHAR(6)',
														'unit_ratio: DOUBLE',
														'base_price: DOUBLE',
														'price: DOUBLE',
														'tax_rate: DOUBLE',
														'discount_rate1: DOUBLE',
														'discount_rate2: DOUBLE',
														'discount_rate3: DOUBLE',
														'amount: DOUBLE',
														'tax_amount: DOUBLE',
														'discount_amount: DOUBLE',
														'total: DOUBLE',
														'description: VARCHAR(100)',
														'trans_year: INT',
														'trans_month: VARCHAR(7)',
														'unit1: VARCHAR(6)',
														'unit2: VARCHAR(6)',
														'unit3: VARCHAR(6)',
														'unit2ratio: DOUBLE',
														'unit3ratio: DOUBLE',
														'exc_code: VARCHAR(3)',
														'exc_rate: DOUBLE',
														'exc_equivalent: DOUBLE',
														'plus_factor_amount: DOUBLE',
														'minus_factor_amount: DOUBLE',
														'input: DOUBLE',
														'output: DOUBLE',
														'in_total: DOUBLE',
														'out_total: DOUBLE',
														'net_input: DOUBLE',
														'net_output: DOUBLE',
														'net_in_total: DOUBLE',
														'net_out_total: DOUBLE',
														'completed: DOUBLE',
														'cancelled: DOUBLE',
														'is_transfer: BIT',
														'trans_id: INT',
														'depot_id: INT',
														'contact_id: INT',
														'seller_id: INT',
														'trans_source_id: INT',
														'trans_point_id: INT',
														'private_code_id: INT',
														'status_id: INT',
														'workspace: INT',
											]
    }),

	
		
						order_trans: new uml.BDDTable({
		id:'order_trans',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 632 },
        name: 'order_trans',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																																																																																																															],
        methods: [
																	'receipt_no: INT',
														'_right: VARCHAR(50)',
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
														'is_transfer: BIT',
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
														'waybill_id: INT',
														'invoice_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'status_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						stock: new uml.BDDTable({
		id:'stock',
        position: { x:725.7759995228321  , y: 118.59646051284588 },
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
        position: { x:512.513343960095  , y: -4.5307910843948775 },
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
	
		
						contact: new uml.BDDTable({
		id:'contact',
        position: { x:270.0000000000001  , y: 38.23085463760208 },
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
	
		
						sale_seller: new uml.BDDTable({
		id:'sale_seller',
        position: { x:111.710656517073  , y: 226.8727484027592 },
        size: { width: 220, height: 170 },
        name: 'sale_seller',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
																	'name: VARCHAR(30)',
														'prim_rate: DOUBLE',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						order_trans_source: new uml.BDDTable({
		id:'order_trans_source',
        position: { x:111.71065651707295  , y: 473.12725159724073 },
        size: { width: 220, height: 170 },
        name: 'order_trans_source',
        attributes: [
										'id: INT',
																																																																									],
        methods: [
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
        position: { x:269.99999999999983  , y: 661.7691453623979 },
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
        position: { x:512.5133439600947  , y: 704.5307910843949 },
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
	
		
						order_trans_status: new uml.BDDTable({
		id:'order_trans_status',
        position: { x:725.7759995228321  , y: 581.4035394871543 },
        size: { width: 220, height: 181 },
        name: 'order_trans_status',
        attributes: [
										'id: INT',
																																																																																],
        methods: [
																	'parent_id: INT',
														'name: VARCHAR(30)',
														'ordering: INT',
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
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.order_trans.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_1' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_2' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.stock_depot.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_3' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_4' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.sale_seller.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_5' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.order_trans_source.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_6' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_7' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.global_private_code.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_8' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.order_trans_detail.id },
	target: { id: classes.order_trans_status.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_detail_ibfk_9' } }}
	]
}),	
	 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonOrderTransDetailGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonOrderTransDetailGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


