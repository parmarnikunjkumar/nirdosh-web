
(function($){
	
	title= function(){
	    alert('it works')
		$("body").append('See it works');
	};
	
	dialog=function(id){
		$('#'+id).dialog();
		
	};
	
	pollApiUsage = function(rest_url,id){
		setTimeout(function(){
			$.ajax({
				type:'GET',
				dataType:'json',
				url:rest_url,
				success:function(result){
				    var str='<table border="1"><thead><tr><th>API-KEY</th><th>Volume / S</th><th>Request / S</th><th>Total Request</th></tr></thead>'; 
				    str+='<tbody>';
				    var totalKeys=0;
				    var totalVolume=0;
				    var totalRequest=0;
				    var totalTotalRequest=0;
				    $.each(result,function(key,data){
				    	str+= '<tr><td>'+data.apiKey+'</td>'
						 	 +'<td>'+data.currentVolumePerSecond+'</td>'
						 	 +'<td>'+data.currentRequestsPerSecond+'</td>'
						 	 +'<td>'+data.totalNumberOfRequests+'</td></tr>';
				    	totalKeys++;
				    	totalVolume += data.currentVolumePerSecond;
				    	totalRequest += data.currentRequestsPerSecond;
				    	totalTotalRequest +=  data.totalNumberOfRequests;
				    });
				    str+='</tbody>';
				    str += '<tfoot border="1"><tr><td>'+totalKeys+'</td><td>'+totalVolume+'</td><td>'+totalRequest+'</td><td>'+totalTotalRequest+'</td></tr></tfoot>';
				    str+= '</table>';
				    $('#'+id).html(str);
				},
				complete:pollApiUsage(rest_url,id)				
			});
		},2000);
	};
	
	incrementCustomerEntryCount= function(customerId,index){
		$.ajax({
			dataType:'json',
			url:'rest/customer/'+customerId+'/incrementEntry',
			success:function(result){
				var str ='<td>'+result.firstName+'</td>'
						+'<td>'+result.lastName+'</td>'
						+'<td>'+result.firstName+'</td>'
						+'<td>'+result.firstName+'</td>'
						+'<td>'+result.firstName+'</td>'
						+'<td>'+result.firstName+'</td>';
			}
			
		});
		
	};
	

	
})(jQuery);

