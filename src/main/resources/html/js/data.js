var vis;
var vm = new Vue({
    name: "data",
    el: "#app",
    data: function () {
        return {
            title: "抬头",
            message: "",
            selected: "",
            options: [
                { id: "", name: "请选择" }
            ],
            tableArr: [
                { id: 1, title: "text", name: "name", phone: "phone" },
                { id: 2, title: "text2", name: "name2", phone: "phone2" }
            ]
        }
    },
    mounted: function () {
        vis = this;
        vis.getArea();
    },
    methods: {
        // 获取地区
        getArea: function () {
            $.ajax({
                type: "get",
                url: "http://localhost:8080/listAreas",
                data: {},
                cache: false,//不读缓存
                dataType: 'json',
                beforeSend: function (XMLHttpRequest) {
                    //ShowLoading();
                },
                success: function (data, textStatus) {
                    if(data.code == 200) {
                        data.results.forEach(element => {
                            vis.options.push(element);
                        });
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    //HideLoading();
                },
                error: function () {
                    //请求出错处理
                }
            });
        },
        // 获取菜单
        getTableData: function () {
            // $.ajax({
            //     type: "get",
            //     url: "",
            //     data: {},
            //     cache:false,//不读缓存
            //     dataType:'json',
            //     beforeSend: function(XMLHttpRequest){
            //         //ShowLoading();
            //     },
            //     success: function(data, textStatus){

            //     },
            //     complete: function(XMLHttpRequest, textStatus){
            //         //HideLoading();
            //     },
            //     error: function(){
            //         //请求出错处理
            //     }
            // });
        },
    },

    filters: {
        cutstr: function (str, aount) {
            var str_length = 0;
            var str_len = 0;
            var len = aount;
            var str_cut = new String();
            str_len = str.length;
            for (var i = 0; i < str_len; i++) {
                var a = str.charAt(i);
                str_length++;
                if (escape(a).length > 4) {
                    //中文字符的长度经编码之后大于4
                    str_length++;
                }
                str_cut = str_cut.concat(a);
                if (str_length >= len) {
                    str_cut = str_cut.concat("...");
                    return str_cut;
                }
            }
            //如果给定字符串小于指定长度，则返回源字符串；
            if (str_length < len) {
                return str;
            }
        }
    }
})
