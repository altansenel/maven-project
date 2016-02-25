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
bank: new uml.BDDTable({
		id:'bank',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 204 },
        name: 'bank',
        attributes: [
										'id: INT',
																																																																																																					],
        methods: [
																	'account_no: VARCHAR(15)',
														'name: VARCHAR(50)',
														'branch: VARCHAR(30)',
														'city: VARCHAR(20)',
														'iban: VARCHAR(26)',
														'exc_code: VARCHAR(3)',
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
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
								chqbll_detail_history: new uml.BDDTable({
		id:'chqbll_detail_history',
        position: { x:270.0000000000001  , y: 38.23085463760208 },
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
																																																																																																																																																																																							
								bank_trans: new uml.BDDTable({
		id:'bank_trans',
        position: { x:269.99999999999983  , y: 661.7691453623979 },
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
																																														};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
									new joint.dia.Link({
	source: { id: classes.chqbll_trans.id },
	target: { id: classes.bank.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_trans_ibfk_2' } }}
	]
}),	
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				new joint.dia.Link({
	source: { id: classes.chqbll_detail_history.id },
	target: { id: classes.bank.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'chqbll_detail_history_ibfk_2' } }}
	]
}),	
																																																																																																																																																																																							new joint.dia.Link({
	source: { id: classes.bank_trans.id },
	target: { id: classes.bank.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'bank_trans_ibfk_1' } }}
	]
}),	
																																														];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonBankGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonBankGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


