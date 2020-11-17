var updateCtgr = function(ctgr_seq1, ctgr_use){

		$.ajax({
			url : '/ctgrupdateservlet',
			data : {
				"ctgr_seq1":ctgr_seq1,
				"ctgr_use":ctgr_use
			},   
			dataType : 'json',
			type : 'post',
			success : function(res){
				//alert("상태 : " + res.status);
			},
			error : function(xhr){
				//alert("상태 : " + ctgr_seq1 + " , " + ctgr_use);
			}
			
	})
}
	  