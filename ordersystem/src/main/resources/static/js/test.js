$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    // 开启校验
    searchFormValidator();

    // 查询事件
    $("#btnSearch").click(function () {
        var bootstrapValidator = $("#searchform").data('bootstrapValidator');
        // 开启验证
        bootstrapValidator.validate();
        // 校验通过
        if (!bootstrapValidator.isValid()) {
            return false;
        }
        var paramData = {
            "userName": $("#idUserName").val(),
            "phone": $("#idPhone").val(),
            "sex": $("#idSex").val(),
            pageNumber: 1
        }
        $('#userTable').bootstrapTable('refresh', paramData);
    });
    // 清空查询条件button
    $("#btnClear").click(function () {
        $("#idUserName").val("");
        $("#idPhone").val("");
        $("#idSex").val("");
        document.getElementById("searchform").reset();

        // 清空提示
        $("#searchform").data('bootstrapValidator').destroy();
        $("#searchform").data('bootstrapValidator', null);
        searchFormValidator();
    });

});

function searchFormValidator() {
    //查询条件校验设置
    $('#searchform').bootstrapValidator({
        message: '请检查参数的合法性',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                message: '用户名格式不正确',
                validators: {
                    stringLength: {
                        min: 0,
                        max: 128,
                        message: '用户名长度不能超过20位'
                    },
                    regexp: {
                        regexp: "^[a-zA-Z0-9\u4E00-\u9FA5|\\d]+$",
                        message: '只能输入汉字，字母，数字'
                    }
                }
            },
            phone: {
                message: '电话不规范',
                validators: {
                    stringLength: {
                        min: 0,
                        max: 11,
                        message: '长度不能大于11位'
                    },
                    regexp: {
                        regexp: "^[0-9]*$",
                        message: '只能输入数字'
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
        $('#userTable').bootstrapTable({
            method: 'POST',
            url: "/userManager/getAll",//请求路径
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            cache: false,
            striped: true, //是否显示行间隔色
            pageNumber: 1, //初始化加载第一页
            pagination: true,//是否分页
            sidePagination: 'server',//server:服务器端分页|client：前端分页
            queryParams: oTableInit.queryParams,//传递参数（*）
            pageSize: 5,//单页记录数
            pageList: [5, 10, 20, 30],//可选择单页记录数
            toolbar: '#toolbar',
            //加载成功时执行
            onLoadSuccess: function (data) {
                console.log("加载成功");
            },
            //加载失败时执行
            onLoadError: function (status) {
                console.log("加载数据失败" + status);
            },
            columns: [{
                title: '用户名',
                field: 'userName',
                sortable: true,
                valign: 'middle'
            }, {
                title: '密码',
                field: 'userPwd',
                sortable: true,
                valign: 'middle'
            }, {
                title: '手机号',
                field: 'phone',
                valign: 'middle'
            }, {
                title: '性别',
                field: 'sex',
                valign: 'middle'
                // formatter: formatSex,//对返回的数据进行处理再显示
            }, {
                title: '头像',
                field: 'pic',
                formatter: formatPic,//对返回的数据进行处理再显示
            }, {
                title: '操作',
                field: 'id',
                valign: 'middle',
                formatter: operation,//对资源进行操作
            }]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, // 每页显示数量
            offset: params.offset, // 页码
            "userName": $("#idUserName").val(),
            "phone": $("#idPhone").val(),
            "sex": $("#idSex").val()
        };
        return JSON.stringify(temp);
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};

//value代表该列的值，row代表当前对象
function formatSex(value, row, index) {
    // return value == 1 ? "男" : "女";
    //或者 return row.sex == 1 ? "男" : "女";
}

//value代表该列的值，row代表当前对象
function formatPic(value, row, index) {
    var picture;
    if (row.pic != null) {
        var url = "/upload/" + row.pic;
        picture = '<a  href="javascript:void(0)"><img style="width:80px;height:70px;"  src="' + url + '" /></a>';
    }
    return picture;
}

//删除、编辑操作
function operation(value, row, index) {
    return [
        '<div class="btn-group operation">' +
        '<button id="btn_edit" type="button" class="btn bg-info">' +
        '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改 </button>',
        '<button id="btn_delete" type="button" class="btn btn-success">' +
        '<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除 </button>' +
        '</div>'
    ]
        .join('');
}

//查询按钮事件
$('#search_btn').click(function () {
    $('#mytab').bootstrapTable('refresh', {
        url: 'user/getUserListPage'
    });
})

