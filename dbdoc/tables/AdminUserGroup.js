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
admin_user_group: new uml.BDDTable({
		id:'admin_user_group',
        position: { x:450  , y: 350 },
        size: { width: 180, height: 127 },
        name: 'admin_user_group',
        attributes: [
										'id: INT',
																																																				],
        methods: [
																	'name: VARCHAR(30)',
														'description: VARCHAR(50)',
														'editing_timeout: SMALLINT',
														'editing_limit: VARCHAR(10)',
														'has_edit_dif_date: BIT',
														'version: INT',
											]
    }),

	  
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															
								admin_user_given_role: new uml.BDDTable({
		id:'admin_user_given_role',
        position: { x:810.0  , y: 350.0 },
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
																																																																																																																																										
								admin_user: new uml.BDDTable({
		id:'admin_user',
        position: { x:90.0  , y: 349.99999999999994 },
        size: { width: 220, height: 192 },
        name: 'admin_user',
        attributes: [
										'id: INT',
																																																																																							],
        methods: [
																	'username: VARCHAR(20)',
														'title: VARCHAR(30)',
														'email: VARCHAR(100)',
														'auth_token: VARCHAR(32)',
														'password_hash: VARCHAR(60)',
														'is_admin: BIT',
														'is_active: BIT',
														'profile: VARCHAR(20)',
														'workspace: INT',
														'user_group_id: INT',
														'version: INT',
									]
    }),
				};

_.each(classes, function(c) { graph.addCell(c); });






var relations = [
 
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															new joint.dia.Link({
	source: { id: classes.admin_user_given_role.id },
	target: { id: classes.admin_user_group.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_user_given_role_ibfk_1' } }}
	]
}),	
																																																																																																																																										new joint.dia.Link({
	source: { id: classes.admin_user.id },
	target: { id: classes.admin_user_group.id },
	vertices: [],
	smooth: false,
	attrs: {
	'.marker-target': { d: 'M 20 0 L 0 5 L 20 10 z' }
	},
	labels: [
	{ position: 60, attrs: { text: { text: 'admin_user_ibfk_1' } }}
	]
}),	
				];

_.each(relations, function(r) { graph.addCell(r); });
_.each(relations, function(r) { r.toBack(); });
 
 function saveGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		localStorage.jsonAdminUserGroupGraph=(JSON.stringify(graph.toJSON()));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
} 

 function loadGraph(){
	if(typeof(Storage)!=="undefined")
  	{
		 graph.fromJSON(JSON.parse(localStorage.jsonAdminUserGroupGraph));
  	}
	else
  	{
  		document.getElementById("error").innerHTML="Sorry, your browser does not support web storage...";
  	}
     
   } 

function updateZoom(){
	paper.scale(document.getElementById("zoom").value);
}


