var updateBoard = function(file_seq1){

		$.ajax({
			url : '/boardupdateservlet',
			data : {
				"fseq":file_seq1
			},   
			dataType : 'json',
			type : 'post',
			success : function(res){
				alert("상태 : " + res.status);
			},
			error : function(xhr){
				alert("상태 : " + file_seq1);
			}
			
	})
}
	  