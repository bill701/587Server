$(document)
			.ready(
					function() {

						var example=$("#example").dataTable({
							"bProcessing" : true,
							//"bServerSide": true,
							
							"sort" : "position",
							"bAutoWidth" : true,
							//bStateSave variable you can use to save state on client cookies: set value "true" 
							"bStateSave" : false,
							//Default: Page display length
							"iDisplayLength" : 10,
							//We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
							"iDisplayStart" : 0,
							"fnDrawCallback" : function() {

							},
							"sAjaxSource" : "springPaginationDataTables.web"+$("#groupSelect").val(),

							"columns" : [ 
							{
							    "data":"tag"
						
							},{
								"data" : "name"
							
							}, {
								"data" : "position",
								"sType" : "enum"
							}, {
								"data" : "office",
								"visible" : false
							}, {
								"data" : "phone"
							}, {
								"data" : "start_date"
							}, {
								"data" : "salary"
							}, ]
							,
							"columnDefs":[
							{
							   "targets":[ 0 ],
							   "data":"tag",
							   "render" : 
							   function(data, type,row){
							   //alert(data);
							       //alert(row.name);
			                       var tags=data.split(",");
			                       var result="";
			                       

			                       for (var i=0;i<tags.length;i++){
			                       
			                       result+=tags[i]+"+";
			                       }
			                       /* result+="<input type='button' onclick='addTag(event,'row.name')' value='add tag'></input>" */;
			                       var hehe='<input type="button" value="tags" onClick="addTag(event,\'' + row.tag + '\',\'' + row.name + '\')" />';
			                     
			                       $.ajax({
			                    	   dataType:"json",
			                       })
			                       return hehe;

					
														}
							}
							],
	
						});

	
						$("#example2")
								.dataTable(
										{
											"bProcessing" : true,
											//"bServerSide": true,
											"sort" : "position",
											"bAutoWidth" : true,
											//bStateSave variable you can use to save state on client cookies: set value "true" 
											"bStateSave" : false,
											//Default: Page display length
											"iDisplayLength" : 10,
											//We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
											"iDisplayStart" : 0,
											"fnDrawCallback" : function() {
												//Get page numer on client. Please note: number start from 0 So
												//for the first page you will see 0 second page 1 third page 2...
												//Un-comment below alert to see page number
												//alert("Current page number: "+this.fnPagingInfo().iPage);    
											},
											"sAjaxSource" : "springPaginationDataTables.web",

											"columns" : [ {
												"data" : "name"
											}, {
												"data" : "position",
												"sType" : "enum"
											}, {
												"data" : "office",
												"visible" : false
											}, {
												"data" : "phone"
											}, {
												"data" : "start_date",
												"sType" : "lastModify"
											}, {
												"data" : "salary"
											}, ],
											"columnDefs" : [ {
												"targets" : [ 5 ],
												"data" : "salary",
												"render" : function(data, type,
														full) {

													return "<a href='https://tt.amazon.com/"+data+"'>"
															+ data + "</a>";
												}

											},
											{
												"targets" : [ 4 ],
												"data" : "start_date",
												"render" : function(data, type,
														full) {

                                                   //  var now=new Date().toLocaleString();
                                                  
												
												var resultSecond= GetDateDiff(data,"second");
												var resultMinute= GetDateDiff(data,"minute");
												var resultHour= GetDateDiff(data,"hour");
												var resultDay= GetDateDiff(data,"day");
												if(resultSecond<60){
												return resultSecond+" second ago";
												}else if(resultMinute<60){
												return resultMinute+" minute ago"; 
												}else if(resultHour<24){
												return resultHour+" hour ago";
												}else{
												return resultDay +" day ago";
												}
												
													//return now ;
												}

											}

											],
											  initComplete: function () {
           // this.api().columns().every( function () {
                var column =  this.api().column(0);
                var select = $('<select><option value=""></option></select>')
                    .appendTo( $("#hehe"))
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' );
                } );
            //} );
        }

										});
										

		





						jQuery.extend(jQuery.fn.dataTableExt.oSort, {
							"enum-pre" : function(a) {
								// Add / alter the switch statement below to match your enum list
								switch (a) {
								case "Highest":
									return 1;
								case "High":
									return 2;
								case "Medium":
									return 3;
								case "Low":
									return 4;

								default:
									return 5;
								}
							},

							"enum-asc" : function(a, b) {
							alert(a);
							
								return ((a < b) ? -1 : ((a > b) ? 1 : 0));
							},

							"enum-desc" : function(a, b) {
								return ((a < b) ? 1 : ((a > b) ? -1 : 0));
							},
							
							
							
							
							"lastModify-pre" : function(a) {
								
								var words=a.split(" ");
								
								//alert(words);
								if(words[1]=="second"){
								
								return words[0];
								}else if(words[1]=="minute"){
								return words[0]*60;
								}else if(words[1]=="hour"){
									return words[0]*60*60;
								}else if(words[1]=="day"){
								return words[0]*60*60*24;
								}else{
								return 0;
								}
								
						
							},

							"lastModify-asc" : function(a, b) {
							
							return ((a < b) ? 1 : ((a > b) ? -1 : 0));
							
							},

							"lastModify-desc" : function(a, b) {
							
							
							return ((a < b) ? -1 : ((a > b) ? 1 : 0));

							}
							
							
							
						});
						var table = $('#example').DataTable();
						var colvis = new $.fn.dataTable.ColVis(table);

						$(colvis.button()).insertAfter('h2');
						
						setInterval(function()
							    {
							        example.fnReloadAjax();
							    },10000);
	

					});

function GetDateDiff(startTime, diffType) {
	 var currTime = new Date();
	
	startTime = startTime.replace(/-/g, "/");
	
	diffType = diffType.toLowerCase();
	var sTime = new Date(startTime);   
	var eTime = new Date(currTime); 

	var divNum = 1;
	switch (diffType) {
	case "second":
		divNum = 1000;
		break;
	case "minute":
		divNum = 1000 * 60;
		break;
	case "hour":
		divNum = 1000 * 3600;
		break;
	case "day":
		divNum = 1000 * 3600 * 24;
		break;
	default:
		break;
	}
	return parseInt((eTime.getTime() - sTime.getTime()) / parseInt(divNum)); 
	
	
	
	
}

$('div').mouseover(function(){
	alert("hehe");
});
