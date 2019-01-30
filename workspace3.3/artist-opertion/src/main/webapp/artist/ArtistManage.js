$(function (){
	
	 // 加载表格
    var oTable = new TableInit();
    oTable.Init();
  
	searchFormValidator();
	/**
	 * 初始化下拉框
	 * @param data 参数
	 * @param uri 请求uri
	 * @param selectId 下拉框id
	 * @param defaultSelect 默认选择
	 * @param id 下拉框取的id
	 * @param name 下拉框取的名称
	 * @param funCallBack 回调函数
	 */
	initSelectOpt('PROFESSION','/queryDataDic','idArtistType','作家','dicitemNameZh','dicitemNameZh');
	initSelectOpt('NATIONALITY','/queryDataDic','idNationAlity','中国','dicitemNameZh','dicitemNameZh');
    
//	initSelect();
	  // 查询事件
    $("#btnSearch").click(function(){
       var bootstrapValidator = $("#searchform").data('bootstrapValidator');
   	   // 开启验证
   	   bootstrapValidator.validate();
   	   // 校验通过
   	   if(!bootstrapValidator.isValid()){
   		   return false;
   	   }
        var paramData={
        		"data":{
            			"artistCode":$("#idArtistCode").val(),
               			"name":$("#idName").val(),
               			"alias":$("#idAlias").val(),   
               			"foreignName":$("#idForeignName").val(),
               			"homeTown":$("#idHomeTown").val(),
               			"nationAlity":$("#idNationAlity").val(),
               			"artistType":$("#idArtistType").val(),
               			pageNumber:1
            		}
        }
   	   $('#artistTable').bootstrapTable('refresh',paramData.data );
    });
	    // 清空查询条件button
	    $("#btnClear").click(function(){
	    	$("#idArtistCode").val("");
	    	$("#idName").val("");
	    	$("#idAlias").val("");
	    	$("#idForeignName").val("");
	    	$("#idHomeTown").val("");
	    	$("#idNationAlity").val("");
	    	$("#idArtistType").val("");
	    	
	        document.getElementById("searchform").reset();
	    	// 清空提示
	        $("#searchform").data('bootstrapValidator').destroy();
	        $('#searchform').data('bootstrapValidator', null);
	        searchFormValidator();
	        $("#idArtistType").selectpicker('refresh');
	        $('#idArtistType').selectpicker('render');
	        $("#idNationAlity").selectpicker('refresh');
	        $('#idNationAlity').selectpicker('render');
	    });
	    
	    
	    
	   
	    
	    
	    // 新增模板
	    $("#btnNew").click(function(){
	    	window.location.href=rootPath+"/artist/addArtist.html";
	    });
});



var operatorType={};
//function initSelect(){
//	$("#idNationAlity").append("<option value='' selected=’selected'>---请选择---</option>");
//	var param = {async:false,data:{}, url:"/country", callback:function(response){
//	if(response.retCode==0 ){
//		for(var index =0;index<response.rows.length;index++){
////			operatorType[response.rows[index].namezh]=response.rows[index].namezh;
//			console.log("ssss"+operatorType);
//			$("#idNationAlity").append("<option value='"+response.rows[index].id+"'>"+response.rows[index].nameZh+"</option>");
//		}
//		$("#idOperType").selectpicker('refresh');
//	}else{
//		swal( {title: "加载数据失败",  text:response.msg,   type:"error" ,confirmButtonColor: "#FF3251", confirmButtonText: "确认"});
//	}
//}};
//// 提交
//$.myajax(param);
//}

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
	        	artistCode: {
	        		 message: '艺人编号不规范',
	                validators: {
	                    stringLength: {
	                        min: 0,
	                        max: 64,
	                        message: '长度必须小于64个字符'
	                    },
	                    regexp: {
	                        regexp:  "^[a-zA-Z0-9]*$", 
	                        message: '只能输入字母、数字'
	                    }
	                }
	            },
	            name : {
	            	message : '艺人名称格式不正确',
	            	validators : {
						 stringLength: {
		                        min: 0,
		                        max: 128,
		                        message: '艺人名称长度不能超过128位'
		                    },
		                    regexp: {
		                        regexp:  "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$",
		                        message: '只能输入汉字，字母，数字'
		                    }
					}
				},
				 foreignName: { 	
					 message: '外文名格式不正确',
					 validators: {
		        
		            	 stringLength: {
		                        min: 0,
		                        max: 128,
		                        message: '外文名长度不能超过128位'
		                    },
		            	 regexp: {
		            		regexp:  "^[ a-zA-Z0-9]*$",
		          		    message: '外文名只能输入字母,数字，空格'
		             	 }
		             }
		         },
		         homeTown: {
		        	 message: '出生地不规范',
	                validators: {
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
	            alias: {
	            	  message: '别名不规范',
	                validators: {  
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
	            }
	        }
	    });
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
    	$('#artistTable').bootstrapTable('destroy').bootstrapTable({
            url: rootPath+'/queryArtistList', //请求后台的URL（*）
            method: 'POST',                     //请求方式（*）
            dataType:"json",      
            contentType:"application/json;charset=utf-8",
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pagination: true, //启动分页 
            pageSize: 10,  //每页显示的记录数  
            pageNumber:1, //当前第几页  
           
            pageList: [10, 20, 50, 100],        //可供选择的每页的行数（*）
            toolbar: '#toolbar', //此处  统一风格，界面多个DIV行
            columns: [ {
                field: 'artistCode',
                title: '艺人编号',
                
            }, {
                field: 'name',
                title: '艺人名称',
                
            }, {
            	field : 'foreignName',
        		title : '外文名'
        	},{
        		field : 'alias',
        		title : '别名'
        	}, {
        		field : 'homeTown',
        		title : '出生地'
        	}, {
        		field : 'artistType',
        		title : '职业'
        	}, {
        		field : 'nationAlity',
        		title : '国籍'
            }, {
            	 field: 'operate',
                 title: '操作',
                 align: 'center',
                 events: operateEvents,
                 formatter: operateFormatter
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var queryParam={
        		"data":{
		        		pageSize: params.limit,   //页面大小
		            	offset: params.offset,  
		               "artistCode":$("#idArtistCode").val(),
		               "name":$("#idName").val(),
                       "foreignName":$("#idForeignName").val(),
                       "alias":$("#idAlias").val(),
                       "homeTown":$("#idHomeTown").val(),
                       "artistType":$("#idArtistType").val(),
                       "nationAlity":$("#idNationAlity").val()
                     }
	   	   };
    	//初始化公共参数
    	initPublicParam(queryParam.data);
    	
        return JSON.stringify(queryParam.data);
    };
    return oTableInit;
};

function operateFormatter(value, row, index) {
	return [
		'<a class="detaile" style="cursor: pointer;">查看</a>',
		'&nbsp;|&nbsp;',
		'<a class="modify" style="cursor: pointer;">编辑</a>',
		'&nbsp;|&nbsp;',
		'<a class="del" style="cursor: pointer;">删除</a>'
		]
		.join('');
}
/**
 * 操作项
 */
window.operateEvents = {
        'click .modify': function (e, value, row, index) {
        	 window.location.href = encodeURI('./modifyArtist.html?artistCode='
       				+ row.artistCode);
         },
         'click .del': function (e, value, row, index) {
        	 swal({title: "确认删除 ?",text: "", type: "warning",  showCancelButton: true,   
        			confirmButtonColor: "#FF3251", confirmButtonText: "确认", cancelButtonText:"取消",
        			closeOnConfirm: false }, 
        			function(){
        				deleteArtistInfo(row,"/deleteArtistInfoList");
        	       });
        	 
          },
          'click .detaile': function (e, value, row, index) {
        	  window.location.href = encodeURI('./detailArtist.html?artistCode='
      				+ row.artistCode);
           }
};
	//删除用户
	function deleteArtistInfo(row,urlString){
		var param = {data:{"async":false,"artistCode":row.artistCode }, url:urlString, callback:function(response){
			if(response.retCode==0 ){
				swal({title: "操作成功", text: "", type: "success",confirmButtonColor: "#FF3251", confirmButtonText: "确认" },function(){
					// 刷新表格,如果删除的是最后一页的最后一条数据，则显示第一页的数据
					var rows = $('#artistTable').bootstrapTable('getData', {useCurrentPage:true});
					if(rows.length == 1){
						$('#artistTable').bootstrapTable('refreshOptions',{pageNumber:1});	
					}else{
						$('#artistTable').bootstrapTable('refresh');
					}
               } );
			}else{
				swal( {title: "操作失败",  text:response.retMsg,   type:"error" ,confirmButtonColor: "#FF3251", confirmButtonText: "确认"});
			}
		}};
		// 提交
		$.myajax(param);
	}
//修改艺人信息
function editArtistInfo(row,urlString){
	var param = {data:{"data":{"artistCode":row.artistCode} }, url:urlString, callback:function(response){
		if(response.retCode==0 ){
			new Clipboard('.confirm', {text: function(trigger) {return response.userPwd;}});
			swal({title: "操作成功", text: "", type: "success",confirmButtonColor: "#FF3251", confirmButtonText: "确认" } );
			
		}else{
			swal( {title: "操作失败",  text:response.retMsg,   type:"error" ,confirmButtonColor: "#FF3251", confirmButtonText: "确认"});
		}
	}};
	// 提交
	$.myajax(param);
}