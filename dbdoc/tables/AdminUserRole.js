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
admin_user_role: new uml.BDDTable({
		id:'admin_user_role',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 127 },
        name: 'admin_user_role',
        attributes: [
										'id: INT',
																																																				],
        methods: [
																	'name: VARCHAR(30)',
														'insert_by: VARCHAR(20)',
														'insert_at: DATETIME',
														'update_by: VARCHAR(20)',
														'update_at: DATETIME',
														'version: INT',
											]
    }),

	  
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											
								admin_user_right: new uml.BDDTable({
		id:'admin_user_right',
        position: { x:810.0  , y: 350.0 },
        size: { width: 220, height: 115 },
        name: 'admin_user_right',
        attributes: [
										'id: INT',
																																						],
        methods: [
																	'name: VARCHAR(50)',
														'right_level: VARCHAR(7)',
														'is_crud: BIT',
														'user_role_id: INT',
									]
    }),
															
								admin_user_given_role: new uml.BDDTable({
		id:'admin_user_given_role',
        position: { x:90.0  , y: 349.99999999999994 },
        size: { width: 220, height: 104 },
        name: 'admin_user_given_role',
        attributes: [
										'id: INT',
																															],
        methods: [
																	'user_group_id: INT',
														'workspace_id: INT',
														'user_role_id: INT',
									]
    }),
																																																																																																																																			};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											new joint.dia.Link({
	source: { id: classes.admin_user_right.id },
	target: { id: classes.admin_user_role.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_user_right_ibfk_1' } }}
	]
}),	
															new joint.dia.Link({
	source: { id: classes.admin_user_given_role.id },
	target: { id: classes.admin_user_role.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_user_given_role_ibfk_3' } }}
	]
}),	
																																																																																																																																			];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonAdminUserRoleGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonAdminUserRoleGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


