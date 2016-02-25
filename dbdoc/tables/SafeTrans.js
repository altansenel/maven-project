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
safe_trans: new uml.BDDTable({
		id:'safe_trans',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 358 },
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

	
		
						safe: new uml.BDDTable({
		id:'safe',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 181 },
        name: 'safe',
        attributes: [
										'id: INT',
																																																																																],
        methods: [
																	'name: VARCHAR(50)',
														'exc_code: VARCHAR(3)',
														'responsible: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'is_active: BIT',
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						safe_expense: new uml.BDDTable({
		id:'safe_expense',
        position: { x:630.0  , y: 38.23085463760208 },
        size: { width: 220, height: 159 },
        name: 'safe_expense',
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
														'workspace: INT',
														'version: INT',
									]
    }),
	
		
						safe_trans_source: new uml.BDDTable({
		id:'safe_trans_source',
        position: { x:270.0000000000001  , y: 38.23085463760208 },
        size: { width: 220, height: 170 },
        name: 'safe_trans_source',
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
        position: { x:90.0  , y: 349.99999999999994 },
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
        position: { x:269.99999999999983  , y: 661.7691453623979 },
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
        position: { x:630.0  , y: 661.7691453623979 },
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
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
	new joint.dia.Link({
	source: { id: classes.safe_trans.id },
	target: { id: classes.safe.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'safe_trans_ibfk_1' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.safe_trans.id },
	target: { id: classes.safe_expense.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'safe_trans_ibfk_2' } }}
	]
}),	
		new joint.dia.Link({
	source: { id: classes.safe_trans.id },
	target: { id: classes.safe_trans_source.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'safe_trans_ibfk_3' } }}
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
	source: { id: classes.safe_trans.id },
	target: { id: classes.global_private_code.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'safe_trans_ibfk_5' } }}
	]
}),	
	 
																																																																					new joint.dia.Link({
	source: { id: classes.chqbll_detail_partial.id },
	target: { id: classes.safe_trans.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_detail_partial_ibfk_3' } }}
	]
}),	
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonSafeTransGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonSafeTransGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


