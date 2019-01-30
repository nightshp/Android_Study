$(function (){
	
	//控制中英文切换
    $(document).ready(function(){
    	  $("#hide").click(function(){
    	  $("#div1").show();
    	  $("#div2").hide();
    	  $("#hide").attr("class","btn btn-success ");
    	  $("#show").attr("class","btn btn-default ");
    	  });
    	  $("#show").click(function(){
    	  $("#div1").hide();
    	  $("#div2").show();
    	  $("#show").attr("class","btn btn-success ");
    	  $("#hide").attr("class","btn btn-default ");
    	  });
    	}); 
	// 获取界面传递述职id
	artistCode = getQueryString("artistCode");
	if (artistCode) {
		// 根据id查询数据并且赋值
		queryArtistInfo(artistCode);
	} 
		
	 
	  // 清空查询条件button
	  $("#btnReturn").click(function(){
	    window.history.back();
	   });
  

	 // 根据id查询数据并且赋值
	 function queryArtistInfo(artistCode) {
	 	// 获取参数
	 	var dataParam = {
	 		
	 			"artistCode" : artistCode
	 		
	 	};
	 	// 构造参数
	 	var param = {
	 		data : dataParam,
	 		url : "/queryDetaileArtist",
	 		callback : function(response) {
	 			if (response.retCode == 0 && response.artistDetaileInfoBean) {
	 				var artistInfo = response.artistDetaileInfoBean.artistI18nBeans[0];
	 				
	 					$("#idArtistCode").val(artistInfo.artistCode);
	 					$("#idArtistCode").attr("disabled","disabled");
	 					$("#idName").val(artistInfo.name);
	 					$("#idForignName").val(artistInfo.foreignName);
	 					$("#idAlias").val(artistInfo.alias);
	 					$("#idHomeTown").val(artistInfo.homeTown);
	 					$("#idDes").val(artistInfo.des);
	 					
	 					var artistInfo1 = response.artistDetaileInfoBean.artistI18nBeans[1];		
	 					$("#idArtistCode1").val(artistInfo1.artistCode);
	 					$("#idArtistCode1").attr("disabled","disabled");
	 					$("#idName1").val(artistInfo1.name);
	 					$("#idForignName1").val(artistInfo1.foreignName);
	 					$("#idAlias1").val(artistInfo1.alias);
	 					$("#idHomeTown1").val(artistInfo1.homeTown);
	 					$("#idDes1").val(artistInfo1.des);
	 			
	 					
	 					
	 					$("#idBirthday").val(response.artistDetaileInfoBean.birthday);
	 					
	 					$("#idSex").val(response.artistDetaileInfoBean.sex);
	 					
	 				    $("#idNationality").val(response.artistDetaileInfoBean.nationAlity);
	 				  
	 				    $("#idBloodgroup").val(response.artistDetaileInfoBean.bloodGroup);
	 				  
	 				    $("#idConstellation").val(response.artistDetaileInfoBean.constellation);
	 				   
	 				    if(response.artistDetaileInfoBean.isTeam==0){
	 				    	$("#idIsteam").val("否");
	 				    }else{
	 				    	$("#idIsteam").val("是");
	 				    }
	 				    
	 				   
	 				    $("#idMothertongue").val(response.artistDetaileInfoBean.motherTongue);
	 				   
	 				    if(response.artistDetaileInfoBean.marriage==0){
	 				    	$("#idMarriage").val("未婚");
	 				    }else if(response.artistDetaileInfoBean.marriage==1){
	 				    	$("#idMarriage").val("已婚");
	 				    }else if(response.artistDetaileInfoBean.marriage==2){
	 				    	$("#idMarriage").val("离异");
	 				    }else {
	 				    	$("#idMarriage").val("丧偶");
	 				    }
	 				    
	 				   
	 				    $("#idArtisttype").val(response.artistDetaileInfoBean.artistType);
	 			 
	 					if(response.artistDetaileInfoBean.height==null){
	 						$("#idHeight").val("");
	 					}else{
	 						$("#idHeight").val(response.artistDetaileInfoBean.height+"cm");
	 					}
	 					

	 					if(response.artistDetaileInfoBean.weight==null){
	 						$("#idHeight").val("");
	 					}else{
	 						$("#idWeight").val(response.artistDetaileInfoBean.weight+"kg");
	 					}
	 					
	 					$("#idZone").val(response.artistDetaileInfoBean.zone);
	 					$("#idCompanyName").val(response.artistDetaileInfoBean.companyName);
	 					$("#idBuildTime").val(response.artistDetaileInfoBean.buildTime);
	 					$("#idJoinintime").val(response.artistDetaileInfoBean.joinInTime);
	 					$("#idEducation").val(response.artistDetaileInfoBean.education);
	 					$("#idFavorite").val(response.artistDetaileInfoBean.favorite);
	 					$("#idDefaultLanguage").val(response.artistDetaileInfoBean.defaultLanguage);	
	 					$("#idFirstName").val(response.artistDetaileInfoBean.firstName);
	 					$("#idLastName").val(response.artistDetaileInfoBean.lastName);
	 					$("#idSearchName").val(response.artistDetaileInfoBean.searchName);
	 			} else {
	 				showError(response.retMsg);
	 			}
	 		}
	 	};
	 	// 发送请求
	 	$.myajax(param);
	 }
});