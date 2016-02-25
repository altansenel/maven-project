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
contact: new uml.BDDTable({
		id:'contact',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 479 },
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

	
		
						contact_category: new uml.BDDTable({
		id:'contact_category',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 192 },
        name: 'contact_category',
        attributes: [
										'id: INT',
																																																																																							],
        methods: [
																	'name: VARCHAR(30)',
														'working_dir: VARCHAR(6)',
														'debt_limit: DOUBLE',
														'credit_limit: DOUBLE',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:800.7732233226848  , y: 269.01762043620863 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:773.5658566677001  , y: 192.18638715593212 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:729.7725461245095  , y: 123.4446592220585 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:671.638131117237  , y: 66.31612870158011 },
        size: { width: 220, height: 170 },
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
	
		
						stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:602.1425742266517  , y: 23.729196666806047 },
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
	
		
						sale_seller: new uml.BDDTable({
		id:'sale_seller',
        position: { x:524.8482086943933  , y: -2.133136264170048 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:443.7171336825779  , y: -9.945170256300855 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:362.9081175841197  , y: 0.6935385406412706 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:286.56342009376317  , y: 29.237651292187536 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:218.59646051284582  , y: 74.22400047716792 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:162.49121638297464  , y: 133.3465916652625 },
        size: { width: 220, height: 170 },
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
	
		
						contact_extra_fields: new uml.BDDTable({
		id:'contact_extra_fields',
        position: { x:121.12363524866367  , y: 203.57480849271198 },
        size: { width: 220, height: 170 },
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
	  
						
								chqbll_trans: new uml.BDDTable({
		id:'chqbll_trans',
        position: { x:96.61421395884099  , y: 281.3087616644438 },
        size: { width: 220, height: 423 },
        name: 'chqbll_trans',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																										],
        methods: [
																	'sort: VARCHAR(6)',
														'receipt_no: INT',
														'_right: VARCHAR(50)',
														'from_step: VARCHAR(15)',
														'to_step: VARCHAR(15)',
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
														'bank_id: INT',
														'safe_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
																																																																																		
								invoice_trans_detail: new uml.BDDTable({
		id:'invoice_trans_detail',
        position: { x:90.21930227312555  , y: 362.5638188129003 },
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
        position: { x:102.2667025359354  , y: 443.1748562369073 },
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
        position: { x:132.13886657078626  , y: 519.0097626029205 },
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
																																																																																																																																										
								order_trans: new uml.BDDTable({
		id:'order_trans',
        position: { x:178.3045511198021  , y: 586.1812504365827 },
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
																																																																																															
								chqbll_payroll_detail: new uml.BDDTable({
		id:'chqbll_payroll_detail',
        position: { x:238.39730917470962  , y: 641.246117974981 },
        size: { width: 220, height: 456 },
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
																		
								stock_trans: new uml.BDDTable({
		id:'stock_trans',
        position: { x:309.33679374386145  , y: 681.3817472428784 },
        size: { width: 220, height: 610 },
        name: 'stock_trans',
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
														'amount: DOUBLE',
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
														'ref_depot_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
																																																																														
								order_trans_detail: new uml.BDDTable({
		id:'order_trans_detail',
        position: { x:387.4866560399051  , y: 704.5307910843949 },
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
																								
								chqbll_detail_history: new uml.BDDTable({
		id:'chqbll_detail_history',
        position: { x:468.8409442474595  , y: 709.5066325116466 },
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
																																																																										
								contact_trans: new uml.BDDTable({
		id:'contact_trans',
        position: { x:549.2294480941194  , y: 696.0542105377949 },
        size: { width: 220, height: 368 },
        name: 'contact_trans',
        attributes: [
										'id: INT',
																																																																																																																																																																																																							],
        methods: [
																	'receipt_no: INT',
														'_right: VARCHAR(50)',
														'trans_date: DATE',
														'maturity: DATE',
														'trans_no: VARCHAR(20)',
														'trans_type: VARCHAR(6)',
														'amount: DOUBLE',
														'debt: DOUBLE',
														'credit: DOUBLE',
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
																																														
								waybill_trans: new uml.BDDTable({
		id:'waybill_trans',
        position: { x:624.5314632886814  , y: 664.8630945701825 },
        size: { width: 220, height: 621 },
        name: 'waybill_trans',
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
														'invoice_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'status_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
																																
								invoice_trans: new uml.BDDTable({
		id:'invoice_trans',
        position: { x:690.8870182891891  , y: 617.5321371718619 },
        size: { width: 220, height: 654 },
        name: 'invoice_trans',
        attributes: [
										'id: INT',
																																																																																																																																																																																																																																																																																																																																																																																													],
        methods: [
																	'receipt_no: INT',
														'_right: VARCHAR(50)',
														'is_cash: BIT',
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
														'withholding_rate: DOUBLE',
														'withholding_before: DOUBLE',
														'withholding_amount: DOUBLE',
														'withholding_after: DOUBLE',
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
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'status_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
																																																																													
								chqbll_payroll: new uml.BDDTable({
		id:'chqbll_payroll',
        position: { x:744.8947359440369  , y: 556.4875170863768 },
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
																		};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
	new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.contact_category.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_1' } }}
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
	target: { id: classes.stock_price_list.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_2' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.contact.id },
	target: { id: classes.sale_seller.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_ibfk_3' } }}
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
	 
						new joint.dia.Link({
	source: { id: classes.chqbll_trans.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_trans_ibfk_1' } }}
	]
}),	
																																																																																		new joint.dia.Link({
	source: { id: classes.invoice_trans_detail.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'invoice_trans_detail_ibfk_4' } }}
	]
}),	
																																		new joint.dia.Link({
	source: { id: classes.waybill_trans_detail.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'waybill_trans_detail_ibfk_4' } }}
	]
}),	
																																																		new joint.dia.Link({
	source: { id: classes.stock_trans_detail.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_trans_detail_ibfk_4' } }}
	]
}),	
																																																																																																																																										new joint.dia.Link({
	source: { id: classes.order_trans.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_ibfk_1' } }}
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
	source: { id: classes.stock_trans.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_trans_ibfk_1' } }}
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
	source: { id: classes.chqbll_detail_history.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_detail_history_ibfk_1' } }}
	]
}),	
																																																																										new joint.dia.Link({
	source: { id: classes.contact_trans.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_trans_ibfk_1' } }}
	]
}),	
																																														new joint.dia.Link({
	source: { id: classes.waybill_trans.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'waybill_trans_ibfk_1' } }}
	]
}),	
																																new joint.dia.Link({
	source: { id: classes.invoice_trans.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'invoice_trans_ibfk_1' } }}
	]
}),	
																																																																													new joint.dia.Link({
	source: { id: classes.chqbll_payroll.id },
	target: { id: classes.contact.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_ibfk_1' } }}
	]
}),	
																		];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonContactGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonContactGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


