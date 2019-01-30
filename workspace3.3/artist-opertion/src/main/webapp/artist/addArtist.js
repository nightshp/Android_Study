$(function (){
	searchFormValidator();

	initSelectOpt('SEX','/queryDataDic','idSex','','dicitemNameZh','dicitemNameZh');
	initSelectOpt('PROFESSION','/queryDataDic','idArtisttype','','dicitemNameZh','dicitemNameZh');
	initSelectOpt('CONSTELLATION','/queryDataDic','idConstellation','','dicitemNameZh','dicitemNameZh');
	initSelectOpt('BLOOD_TYPE','/queryDataDic','idBloodgroup','','dicitemNameZh','dicitemNameZh');
	initSelectOpt('MOTHERTONGUE','/queryDataDic','idMothertongue','','dicitemNameZh','dicitemNameZh');
	initSelectOpt('NATIONALITY','/queryDataDic','idNationality','','dicitemNameZh','dicitemNameZh');
	initSelectOpt('MARRIAGE','/queryDataDic','idMarriage','','dicitemCode','dicitemNameZh');
	initSelectOpt('ISTEAM','/queryDataDic','idIsteam','','dicitemCode','dicitemNameZh');

	 //用于生成uuid
    function S4() {
        return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    function guid() {
        return (S4()+S4()+S4());
    }
    
    var uuid = guid();
    
//    $("#idArtistCode").attr("id",uuid);
//    $("#idArtistCode1").val(uuid)==$("#idArtistCode").val(uuid);
    $("#idArtistCode").val(uuid);
//控制中英文切换
    $(document).ready(function(){
    	  $("#hide").click(function(){
          $("#idArtistCode").val(uuid);
    	  $("#div1").show();
    	  $("#div2").hide();
    	  $("#hide").attr("class","btn btn-success ");
    	  $("#show").attr("class","btn btn-default ");
    	  });
    	  $("#show").click(function(){
          $("#idArtistCode1").val(uuid)
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
//       				"artistInfoBean":{
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
       	       			"firstName":$("#idFirstName").val(), 
       	       			"lastName":$("#idLastName").val(),
       	       			"searchName":$("#idSearchName").val(),
       	       	
//       				},
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
        var param = {data:paramData.data, url:"/addAristInfos", callback:function(response){
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



function searchFormValidator(){
	//查询条件校验设置
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
	                        message: '只能输入汉字，字母，数字,空格'
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
