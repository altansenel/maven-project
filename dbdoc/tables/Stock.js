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
stock: new uml.BDDTable({
		id:'stock',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 468 },
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
        position: { x:792.3803458662553  , y: 238.75388202501892 },
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
        position: { x:741.2461179749811  , y: 138.39730917470968 },
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
        position: { x:661.6026908252903  , y: 58.753882025018925 },
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
        position: { x:561.2461179749811  , y: 7.619654133744746 },
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
        position: { x:338.7538820250189  , y: 7.619654133744689 },
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
        position: { x:238.3973091747097  , y: 58.753882025018925 },
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
        position: { x:158.75388202501898  , y: 138.39730917470962 },
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
        position: { x:107.61965413374475  , y: 238.7538820250189 },
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
	  
																																																																													
								invoice_trans_detail: new uml.BDDTable({
		id:'invoice_trans_detail',
        position: { x:107.61965413374475  , y: 461.2461179749812 },
        size: { width: 220, height: 753 },
        name: 'invoice_trans_detail',
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
														'tax_rate2: DOUBLE',
														'tax_rate3: DOUBLE',
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
														'serial_no: VARCHAR(100)',
														'input: DOUBLE',
														'output: DOUBLE',
														'in_total: DOUBLE',
														'out_total: DOUBLE',
														'is_return: BIT',
														'ret_input: DOUBLE',
														'ret_output: DOUBLE',
														'ret_in_total: DOUBLE',
														'ret_out_total: DOUBLE',
														'net_input: DOUBLE',
														'net_output: DOUBLE',
														'net_in_total: DOUBLE',
														'net_out_total: DOUBLE',
														'has_cost_effect: BIT',
														'trans_id: INT',
														'depot_id: INT',
														'contact_id: INT',
														'seller_id: INT',
														'trans_source_id: INT',
														'trans_point_id: INT',
														'private_code_id: INT',
														'parent_id: INT',
														'parent_right: VARCHAR(30)',
														'status_id: INT',
														'workspace: INT',
									]
    }),
																																		
								waybill_trans_detail: new uml.BDDTable({
		id:'waybill_trans_detail',
        position: { x:158.75388202501892  , y: 561.6026908252903 },
        size: { width: 220, height: 665 },
        name: 'waybill_trans_detail',
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
																																																		
								stock_trans_detail: new uml.BDDTable({
		id:'stock_trans_detail',
        position: { x:238.39730917470962  , y: 641.246117974981 },
        size: { width: 220, height: 720 },
        name: 'stock_trans_detail',
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
														'tax_rate2: DOUBLE',
														'tax_rate3: DOUBLE',
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
														'serial_no: VARCHAR(100)',
														'input: DOUBLE',
														'output: DOUBLE',
														'in_total: DOUBLE',
														'out_total: DOUBLE',
														'is_return: BIT',
														'ret_input: DOUBLE',
														'ret_output: DOUBLE',
														'ret_in_total: DOUBLE',
														'ret_out_total: DOUBLE',
														'net_input: DOUBLE',
														'net_output: DOUBLE',
														'net_in_total: DOUBLE',
														'net_out_total: DOUBLE',
														'has_cost_effect: BIT',
														'trans_id: INT',
														'depot_id: INT',
														'contact_id: INT',
														'seller_id: INT',
														'trans_source_id: INT',
														'trans_point_id: INT',
														'private_code_id: INT',
														'workspace: INT',
									]
    }),
																																																																																																																																																																																																														
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:338.75388202501887  , y: 692.3803458662553 },
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
																																																																															
								stock_barcode: new uml.BDDTable({
		id:'stock_barcode',
        position: { x:449.99999999999994  , y: 710.0 },
        size: { width: 220, height: 192 },
        name: 'stock_barcode',
        attributes: [
										'id: INT',
																																																																																							],
        methods: [
																	'barcode: VARCHAR(128)',
														'prefix: VARCHAR(30)',
														'suffix: VARCHAR(30)',
														'unit_no: SMALLINT',
														'is_primary: BIT',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'stock_id: INT',
														'workspace: INT',
									]
    }),
																																							
								order_trans_detail: new uml.BDDTable({
		id:'order_trans_detail',
        position: { x:561.246117974981  , y: 692.3803458662553 },
        size: { width: 220, height: 665 },
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
																																																																																																																																					
								stock_costing_inventory: new uml.BDDTable({
		id:'stock_costing_inventory',
        position: { x:661.6026908252902  , y: 641.2461179749812 },
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
        position: { x:741.246117974981  , y: 561.6026908252904 },
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
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_10' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_11' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_2' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_3' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_4' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_5' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_6' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_7' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_8' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.stock.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_ibfk_9' } }}
	]
}),	
	 
																																																																													new joint.dia.Link({
	source: { id: classes.invoice_trans_detail.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'invoice_trans_detail_ibfk_2' } }}
	]
}),	
																																		new joint.dia.Link({
	source: { id: classes.waybill_trans_detail.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'waybill_trans_detail_ibfk_2' } }}
	]
}),	
																																																		new joint.dia.Link({
	source: { id: classes.stock_trans_detail.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_trans_detail_ibfk_2' } }}
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
	source: { id: classes.stock_barcode.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_barcode_ibfk_1' } }}
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
	source: { id: classes.stock_costing_inventory.id },
	target: { id: classes.stock.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_costing_inventory_ibfk_2' } }}
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
		localStorage.jsonStockGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonStockGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


