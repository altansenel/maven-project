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
stock_extra_fields: new uml.BDDTable({
		id:'stock_extra_fields',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 160 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:807.3166145908759  , y: 306.1270363741469 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:799.3064614593587  , y: 262.9081175841196 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:786.0889535389927  , y: 220.9875381636919 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:767.8611334292137  , y: 180.9902373970793 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:744.894735944037  , y: 143.51248291362342 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:717.5321371718619  , y: 109.11298171081103 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:686.1812504365827  , y: 78.30455111980211 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:651.3094452494688  , y: 51.546473880184976 },
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
								
								sale_campaign: new uml.BDDTable({
		id:'sale_campaign',
        position: { x:613.4365799062368  , y: 29.237651292187593 },
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
        position: { x:573.1272515972407  , y: 11.710656517073005 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:530.9823795637915  , y: -0.7732233226847143 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:487.63024677635525  , y: -8.027882332578372 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:443.7171336825779  , y: -9.945170256300855 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:399.8976836543766  , y: -6.496504746965343 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:356.8251437630925  , y: 2.2667025359353943 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:315.14162637027164  , y: 16.21381235595652 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:275.4685367113187  , y: 35.13690542981749 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:238.3973091747097  , y: 58.753882025018925 },
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
								
								stock_price_update: new uml.BDDTable({
		id:'stock_price_update',
        position: { x:204.4805903775006  , y: 86.7126674170986 },
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
        position: { x:174.22400047716798  , y: 118.5964605128458 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:148.07859553964738  , y: 153.92994739459016 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:109.61331278424592  , y: 232.7954643954236 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:97.86686373582995  , y: 275.15179130560665 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:91.3699086869716  , y: 318.62393261084304 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:90.21930227312555  , y: 362.5638188129003 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:94.43219738575038  , y: 406.3164074144831 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:103.94578946220514  , y: 449.2294480941195 },
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
								
								stock: new uml.BDDTable({
		id:'stock',
        position: { x:118.61825275712147  , y: 490.66320625613844 },
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
        position: { x:138.23085463760208  , y: 530.0 },
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
								
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:162.49121638297453  , y: 566.6534083347373 },
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
								
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:191.03767187808563  , y: 600.077013365239 },
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
								
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:223.44465922205865  , y: 629.7725461245096 },
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
								
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:259.2290648760462  , y: 655.2973146163133 },
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
																	
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:297.85742577334827  , y: 676.270803333194 },
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
								
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:381.3087616644439  , y: 703.385786041159 },
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
								
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:424.8876694521148  , y: 709.1230580935367 },
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
								
								stock_costing: new uml.BDDTable({
		id:'stock_costing',
        position: { x:468.8409442474595  , y: 709.5066325116466 },
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
        position: { x:512.5133439600947  , y: 704.5307910843949 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:555.2538137001852  , y: 694.2697121466928 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:596.4251915072879  , y: 678.8763647513364 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:635.4137069676195  , y: 658.5802282527604 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:671.6381311172369  , y: 633.6838712984201 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:704.558441227157  , y: 604.5584412271571 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:733.68387129842  , y: 571.638131117237 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:758.5802282527604  , y: 535.4137069676196 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:778.8763647513363  , y: 496.42519150728805 },
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
								
								stock_price_list: new uml.BDDTable({
		id:'stock_price_list',
        position: { x:794.2697121466927  , y: 455.2538137001854 },
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
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_10' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_11' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_2' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_3' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_4' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_5' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_6' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_7' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_8' } }}
	]
}),	
								new joint.dia.Link({
	source: { id: classes.stock_price_list.id },
	target: { id: classes.stock_extra_fields.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'stock_price_list_ibfk_9' } }}
	]
}),	
																																																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonStockExtraFieldsGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonStockExtraFieldsGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


