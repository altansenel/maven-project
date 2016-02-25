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
safe: new uml.BDDTable({
		id:'safe',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 171 },
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
																																																								
								chqbll_detail_partial: new uml.BDDTable({
		id:'chqbll_detail_partial',
        position: { x:450.0  , y: -10.0 },
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
																																																																																																																																																																																																																																																																	
								safe_trans: new uml.BDDTable({
		id:'safe_trans',
        position: { x:90.0  , y: 349.99999999999994 },
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
																																																																																																																																																																																					
								chqbll_detail_history: new uml.BDDTable({
		id:'chqbll_detail_history',
        position: { x:449.99999999999994  , y: 710.0 },
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
																																																																																																																																																																																																																													};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
												new joint.dia.Link({
	source: { id: classes.chqbll_trans.id },
	target: { id: classes.safe.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_trans_ibfk_3' } }}
	]
}),	
																																																								new joint.dia.Link({
	source: { id: classes.chqbll_detail_partial.id },
	target: { id: classes.safe.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_detail_partial_ibfk_1' } }}
	]
}),	
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
	source: { id: classes.chqbll_detail_history.id },
	target: { id: classes.safe.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_detail_history_ibfk_3' } }}
	]
}),	
																																																																																																																																																																																																																													];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonSafeGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonSafeGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


