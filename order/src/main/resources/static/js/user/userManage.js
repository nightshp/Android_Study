$.ajax(
    {
        url: '/userInfo/user',     // 请求地址, 就是你的控制器, 如 test.com/home/index/index
        data:{},
        type: 'GET',   // 请求方式
        dataType: 'json', // 返回数据的格式, 通常为JSON
        contentType: 'application/json',
        success: function (data) {
            $.each(data, function(i, item) {
                $("#Id").val(item.uId);
                $("#Name").val(item.uName);
                $("#Password").val(item.uPassword);
            });
        },
        error: function () {
            console.log('Send Request Fail..'); // 请求失败时的回调函数
        }
    });