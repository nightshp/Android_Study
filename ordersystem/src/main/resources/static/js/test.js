$(function () {


    $('#mytab').bootstrapTable({
        method: 'POST',
        url: "/userManager/getAll",//请求路径
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        cache: false,
        striped: true, //是否显示行间隔色
        pageNumber: 1, //初始化加载第一页
        pagination: true,//是否分页
        sidePagination: 'server',//server:服务器端分页|client：前端分页
        pageSize: 5,//单页记录数
        pageList: [5, 10, 20, 30],//可选择单页记录数
        toolbar: '#toolbar',
        showRefresh: true,//刷新按钮
        queryParams: function (params) {//上传服务器的参数
            var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                pageSize: params.limit, // 每页显示数量
                offset: params.offset, // SQL语句起始索引
                // pageNum: (params.offset / params.limit) + 1, //当前页码
                // Name : $('#search_name').val(),
                // Tel : $('#search_tel').val()
            };
            return JSON.stringify(temp);
        },
        columns: [{
            title: '用户名',
            field: 'userName',
            sortable: true
        }, {
            title: '密码',
            field: 'userPwd',
            sortable: true
        }, {
            title: '手机号',
            field: 'phone',
        }, {
            title: '性别',
            field: 'sex',
            // formatter: formatSex,//对返回的数据进行处理再显示
        }, {
            title: '头像',
            field: 'pic',
            formatter: formatPic,//对返回的数据进行处理再显示
        }, {
            title: '操作',
            field: 'id',
            formatter: operation,//对资源进行操作
        }]
    });


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
            picture = '<a  href="javascript:void(0)"><img style="width:40px;height:30px;"  src="' + url + '" /></a>';
        }
        return picture;
    }

//删除、编辑操作
    function operation(value, row, index) {
        return [
            '<a class="detaile" style="cursor: pointer;">查看</a>',
            '&nbsp;|&nbsp;',
            '<a class="modify" style="cursor: pointer;">编辑</a>',
            '&nbsp;|&nbsp;',
            '<a class="del" style="cursor: pointer;">删除</a>'
        ]
            .join('');
    }

//查询按钮事件
    $('#search_btn').click(function () {
        $('#mytab').bootstrapTable('refresh', {
            url: 'user/getUserListPage'
        });
    })

});
