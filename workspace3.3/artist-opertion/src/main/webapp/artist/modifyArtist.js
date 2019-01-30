$(function (){
	
//	initSelectOpt('','/user/queryUserType.do','idOperType','','userType','userTypeName',false,null);
	initSelectOpt('SEX','/queryDataDic','idSex','','dicitemNameZh','dicitemNameZh',false,null);
	initSelectOpt('PROFESSION','/queryDataDic','idArtisttype','','dicitemNameZh','dicitemNameZh',false,null);
	initSelectOpt('CONSTELLATION','/queryDataDic','idConstellation','','dicitemNameZh','dicitemNameZh',false,null);
	initSelectOpt('BLOOD_TYPE','/queryDataDic','idBloodgroup','','dicitemNameZh','dicitemNameZh',false,null);
	initSelectOpt('MOTHERTONGUE','/queryDataDic','idMothertongue','','dicitemNameZh','dicitemNameZh',false,null);
	initSelectOpt('NATIONALITY','/queryDataDic','idNationality','','dicitemNameZh','dicitemNameZh',false,null);
	initSelectOpt('MARRIAGE','/queryDataDic','idMarriage','','dicitemCode','dicitemNameZh',false,null);
	initSelectOpt('ISTEAM','/queryDataDic','idIsteam','','dicitemCode','dicitemNameZh',false,null);
	
	searchFormValidator();
	

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
    
    //设置日期时间控件
    $(".form_datetime").datetimepicker({
		 format: "yyyy-mm-dd",
		 autoclose: true,
		 todayBtn: true,
		 todayHighlight: true,
		 showMeridian: true,
		 pickerPosition: "bottom-left",
		 clearBtn:true,
		 language: 'zh-CN',//中文，需要引用zh-CN.js包
		 minView: "month",//设置只显示到月份
//		 startView: 2,//月视图
//		 minView: 1//日期时间选择器所能够提供的最精确的时间选择视图
	});
	$(".form_datetime").datetimepicker("disable").attr("readonly","readonly");
	
	  // 提交用户
    $("#btnSubmit").click(function(){
       var bootstrapValidator = $("#searchform").data('bootstrapValidator');
   	   // 开启验证
   	   bootstrapValidator.validate();
   	   // 校验通过
   	   if(!bootstrapValidator.isValid()){
   		   return false;
   	   }
   	   
   
   	   var paramData={
   			"data":{
//   				"artistInfoBean":{
   					"artistCode":$("#idArtistCode").val(),
   	       			"sex":$("#idSex").val(),
   	       			"birthday":$("#idBirthday").val(),
   	       			"nationAlity":$("#idNationality").val(),
   	       			"bloodGroup":$("#idBloodgroup").val(),
   	       			"constellation":$("#idConstellation").val(), 
   	       			"isTeam":$("#idIsteam").val(),
   	       			"height":$("#idHeight").val(),
   	       			"weight":$("#idWeight").val(),
   	       			"zone":$("#idZone").val(),
   	       			"companyName":$("#idCompanyName").val(), 
   	       			"buildTime":$("#idBuildTime").val(),
   	       			"joinInTime":$("#idJoinintime").val(),
   	       			"education":$("#idEducation").val(),
   	       			"favorite":$("#idFavorite").val(),
   	       			"motherTongue":$("#idMothertongue").val(), 
   	       			"marriage":$("#idMarriage").val(),
   	       			"artistType":$("#idArtisttype").val(),
   	       			"defaultLanguage":$("idDefaultLanguage").val(),
   	       			"firstName":$("#idFirstName").val(), 
   	       			"lastName":$("#idLastName").val(),
   	       			"searchName":$("#idSearchName").val(),
//   				},
    		    "artistI18nBeans":[{
            		"artistCode":$("#idArtistCode").val(),
           			"name":$("#idName").val(),
           			"foreignName":$("#idForignName").val(),
           			"alias":$("#idAlias").val(),
           			"homeTown":$("#idHomeTown").val(),
           			"des":$("#idDes").val(),
           			"lang":$("#hide").val()
               },{
           		"artistCode":$("#idArtistCode1").val(),
          			"name":$("#idName1").val(),
          			"foreignName":$("#idForignName1").val(),
          			"alias":$("#idAlias1").val(),
          			"homeTown":$("#idHomeTown1").val(),
          			"des":$("#idDes1").val(),
          			"lang":$("#show").val()
              }]
   	      }
   	   }
   	   
        
        var param = {data:paramData.data, url:"/editArtistInfos", callback:function(response){
			if(response.retCode==0 ){
				swal({title: "操作成功", text: "", type: "success",confirmButtonColor: "#FF3251", confirmButtonText: "确认" }, 
						function(){
//					window.history.back();
					window.location.href=rootPath+"/artist/ArtistManage.html" ;
               } );
			}else{
				swal( {title: "操作失败",  text:response.retMsg,   type:"error" ,confirmButtonColor: "#FF3251", confirmButtonText: "确认"});
			}
		}};
		// 提交
		$.myajax(param);
		
    });
	    // 取消
	    $("#btnCancel").click(function(){
	    	window.history.back();
	    });
});

//获取界面传递述职id
artistCode = getQueryString("artistCode");
if (artistCode) {
	// 根据id查询数据并且赋值
	queryArtistInfo(artistCode);
} 
	
//根据id查询数据并且赋值
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
 					$("#idSex").selectpicker('refresh');
 				    $("#idSex").selectpicker('render'); 
// 					$("#idSex").val(response.artistDetaileInfoBean.sex);
 					
 				    $("#idNationality").val(response.artistDetaileInfoBean.nationAlity);
 				    $("#idNationality").selectpicker('refresh');
				    $("#idNationality").selectpicker('render'); 
				    
				    
 				    $("#idBloodgroup").val(response.artistDetaileInfoBean.bloodGroup);
 				    $("#idBloodgroup").selectpicker('refresh');
				    $("#idBloodgroup").selectpicker('render'); 
				    
 				    $("#idConstellation").val(response.artistDetaileInfoBean.constellation);
 				    $("#idConstellation").selectpicker('refresh');
				    $("#idConstellation").selectpicker('render');  
				    
 				 
 				   $("#idIsteam").val(response.artistDetaileInfoBean.isTeam);
 				   $("#idIsteam").selectpicker('refresh');
				   $("#idIsteam").selectpicker('render'); 
 				   $("#idMothertongue").val(response.artistDetaileInfoBean.motherTongue);
 				   $("#idMothertongue").selectpicker('refresh');
				   $("#idMothertongue").selectpicker('render'); 
				   
 				
 				   $("#idMarriage").val(response.artistDetaileInfoBean.marriage);
 				   $("#idMarriage").selectpicker('refresh');
				   $("#idMarriage").selectpicker('render');
				   
 				   $("#idArtisttype").val(response.artistDetaileInfoBean.artistType);
 				   $("#idArtisttype").selectpicker('refresh');
				   $("#idArtisttype").selectpicker('render');
 					
 					if(response.artistDetaileInfoBean.height==null){
 						$("#idHeight").val("");
 					}else{
 						$("#idHeight").val(response.artistDetaileInfoBean.height);
 					}
 					

 					if(response.artistDetaileInfoBean.weight==null){
 						$("#idHeight").val("");
 					}else{
 						$("#idWeight").val(response.artistDetaileInfoBean.weight);
 					}
 					
 					$("#idZone").val(response.artistDetaileInfoBean.zone);
 					$("#idCompanyName").val(response.artistDetaileInfoBean.companyName);
 					$("#idBuildTime").val(response.artistDetaileInfoBean.buildTime);
 					$("#idJoinintime").val(response.artistDetaileInfoBean.joinInTime);
 					$("#idEducation").val(response.artistDetaileInfoBean.education);
 					$("#idFavorite").val(response.artistDetaileInfoBean.favorite);
// 					$("#idDefaultLanguage").val(response.artistDetaileInfoBean.defaultLanguage);	
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

function searchFormValidator(){
	//参数校验设置
	 $('#searchform').bootstrapValidator({
	        message: '请检查参数的合法性',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            name: {
	                validators: {
	                	 notEmpty: {
	                		    message: '姓名不能为空'
	                	 },
	                    stringLength: {
	                        min: 0,
	                        max: 128,
	                        message: '长度必须小于128个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
	                        message: '只能输入汉字，字母，数字'
	                    }
	                }
	            }, 
	            foreignName: {
	               
	                validators: {
	                	notEmpty: {
                		    message: '外文名不能为空'
                	 },
	                    stringLength: {
	                        min: 0,
	                        max: 128,
	                        message: '长度必须小于128个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[ a-zA-Z0-9]*$", 
	                        message: '只能输入字母,数字,空格'
	                    }
	                }
	            },
	            alias: {
	               
	                validators: {
	                	notEmpty: {
                		    message: '别名不能为空'
                	 },
	              
	                    stringLength: {
	                        min: 0,
	                        max: 128,
	                        message: '长度必须小于128个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[ a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
	                        message: '只能输入汉字，字母，数字，空格'
	                    }
	                }
	            },
	            homeTown: {
	                
	                validators: {
	                	notEmpty: {
                		    message: '出生地不能为空'
                	 },
	                
	                    stringLength: {
	                        min: 0,
	                        max: 128,
	                        message: '长度必须小于128个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[ a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
	                        message: '只能输入汉字，字母，数字，空格'
	                    }
	                }
	            },
	            des: {
	                
	                validators: {
	                	notEmpty: {
                		    message: '简介不能为空'
                	 },
	         
	                    stringLength: {
	                        min: 0,
	                        max: 4096,
	                        message: '长度必须小于4096个字符'
	                    }
	                }
	            },
	           
	            height: {
	                
	                validators: {
	                    stringLength: {
	                        min: 0,
	                        max: 10,
	                        message: '长度必须小于10个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[0-9]*$", 
	                        message: '只能输入数字'
	                    }
	                }
	            },
	            weight: {
	               
	                validators: {
	                    stringLength: {
	                        min: 0,
	                        max: 10,
	                        message: '长度必须小于10个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[0-9]*$", 
	                        message: '只能输入数字'
	                    }
	                }
	            }, 
	            zone: {
	                
	                validators: { 
	                	stringLength: {
                        min: 0,
                        max: 256,
                        message: '长度必须小于256个字符'
                    },
	                    regexp: {
	                        regexp:  "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
	                        message: '只能输入汉字，字母，数字'
	                    }
	                }
	            }, 
	            companyName: {
	                
	                validators: {
	                    stringLength: {
	                        min: 0,
	                        max: 128,
	                        message: '长度必须小于128个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
	                        message: '只能输入汉字，字母，数字'
	                    }
	                }
	            },
	            education: {
	                
	                validators: {
	                    stringLength: {
	                        min: 0,
	                        max: 128,
	                        message: '长度必须小于128个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[小学|初中|高中|本科|专科|研究生|博士]+$", 
	                        message: '只能输入小学、初中、高中、本科、专科、研究生、博士中的一种'
	                    }
	                }
	            }, 
	            firstName:{
	            	validators: {
                    stringLength: {
                        min: 0,
                        max: 128,
                        message: '长度必须小于128个字符'
                    },
                    regexp: {
                        regexp:  "^[a-zA-Z\u4E00-\u9FA5|\\d]+$", 
                        message: '只能输入汉字，字母'
                    }
                }
            },
            lastName:{
	            	validators: {
                    stringLength: {
                        min: 0,
                        max: 128,
                        message: '长度必须小于128个字符'
                    },
                    regexp: {
                        regexp:  "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
                        message: '只能输入汉字，字母，数字'
                    }
                }
            },
            searchName:{
	            	validators: {
                    stringLength: {
                        min: 0,
                        max: 128,
                        message: '长度必须小于128个字符'
                    },
                    regexp: {
                        regexp:  "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
                        message: '只能输入汉字，字母，数字'
                    }
                }
            },
            zone:{
            	validators: {
                stringLength: {
                    min: 0,
                    max: 256,
                    message: '长度必须小于256个字符'
                },
                regexp: {
                    regexp:  "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$", 
                    message: '只能输入汉字，字母，数字'
                }
            }
        }
	            
	        }
	    });
	 
}
