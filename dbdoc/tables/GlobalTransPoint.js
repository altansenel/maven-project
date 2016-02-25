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
global_trans_point: new uml.BDDTable({
		id:'global_trans_point',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 193 },
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

	  
																		
								chqbll_trans: new uml.BDDTable({
		id:'chqbll_trans',
        position: { x:810.0  , y: 350.0 },
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
        position: { x:778.8763647513363  , y: 203.57480849271195 },
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
        position: { x:690.887018289189  , y: 82.4678628281381 },
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
        position: { x:561.2461179749811  , y: 7.619654133744746 },
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
        position: { x:412.3697532236448  , y: -8.027882332578429 },
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
																														
								safe_trans: new uml.BDDTable({
		id:'safe_trans',
        position: { x:270.0000000000001  , y: 38.23085463760208 },
        size: { width: 220, height: 368 },
        name: 'safe_trans',
        attributes: [
										'id: INT',
																																																																																																																																																																																																							],
        methods: [
																	'receipt_no: INT',
														'_right: VARCHAR(50)',
														'trans_date: DATE',
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
														'safe_id: INT',
														'expense_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
												
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:158.75388202501898  , y: 138.39730917470962 },
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
																																																												
								chqbll_payroll_detail: new uml.BDDTable({
		id:'chqbll_payroll_detail',
        position: { x:97.86686373582995  , y: 275.15179130560665 },
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
        position: { x:97.86686373582995  , y: 424.8482086943933 },
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
        position: { x:158.75388202501892  , y: 561.6026908252903 },
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
																																																																																										
								contact_trans: new uml.BDDTable({
		id:'contact_trans',
        position: { x:269.99999999999983  , y: 661.7691453623979 },
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
        position: { x:412.36975322364447  , y: 708.0278823325784 },
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
        position: { x:561.246117974981  , y: 692.3803458662553 },
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
																																																	
								bank_trans: new uml.BDDTable({
		id:'bank_trans',
        position: { x:690.8870182891891  , y: 617.5321371718619 },
        size: { width: 220, height: 379 },
        name: 'bank_trans',
        attributes: [
										'id: INT',
																																																																																																																																																																																																														],
        methods: [
																	'receipt_no: INT',
														'_right: VARCHAR(50)',
														'trans_date: DATE',
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
														'expense_amount: DOUBLE',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'trans_source_id: INT',
														'trans_point_id: INT',
														'private_code_id: INT',
														'bank_id: INT',
														'expense_id: INT',
														'ref_module: VARCHAR(10)',
														'ref_id: INT',
														'workspace: INT',
														'version: INT',
									]
    }),
																														
								chqbll_payroll: new uml.BDDTable({
		id:'chqbll_payroll',
        position: { x:778.8763647513363  , y: 496.42519150728805 },
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
	source: { id: classes.chqbll_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_trans_ibfk_5' } }}
	]
}),	
																																																																															new joint.dia.Link({
	source: { id: classes.invoice_trans_detail.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'invoice_trans_detail_ibfk_7' } }}
	]
}),	
																																		new joint.dia.Link({
	source: { id: classes.waybill_trans_detail.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'waybill_trans_detail_ibfk_7' } }}
	]
}),	
																																																		new joint.dia.Link({
	source: { id: classes.stock_trans_detail.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_trans_detail_ibfk_7' } }}
	]
}),	
																																																																																																																																										new joint.dia.Link({
	source: { id: classes.order_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'order_trans_ibfk_4' } }}
	]
}),	
																														new joint.dia.Link({
	source: { id: classes.safe_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'safe_trans_ibfk_4' } }}
	]
}),	
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
	source: { id: classes.stock_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_trans_ibfk_5' } }}
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
	source: { id: classes.contact_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'contact_trans_ibfk_3' } }}
	]
}),	
																																																	new joint.dia.Link({
	source: { id: classes.waybill_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'waybill_trans_ibfk_4' } }}
	]
}),	
																																new joint.dia.Link({
	source: { id: classes.invoice_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'invoice_trans_ibfk_4' } }}
	]
}),	
																																																	new joint.dia.Link({
	source: { id: classes.bank_trans.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'bank_trans_ibfk_4' } }}
	]
}),	
																														new joint.dia.Link({
	source: { id: classes.chqbll_payroll.id },
	target: { id: classes.global_trans_point.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_payroll_ibfk_3' } }}
	]
}),	
												];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonGlobalTransPointGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonGlobalTransPointGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


