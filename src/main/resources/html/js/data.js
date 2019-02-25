var vis;
var vm = new Vue({
    name: "data",
    el: "#app",
    data: function () {
        return {
            dialogVisible: false,
            dialogFormVisible: false,
            options: [
                { id: "", name: "请选择" }
            ],
            tableData: [{
                recordId: '1',
                region: '',
                title: '',
                name: '王小虎',
                phone: '',
                address: '上海市普陀区金沙江路 1518 弄',
                amount: '',
                picture: ''
            }, {
                recordId: '2',
                region: '',
                title: '',
                name: '王小虎',
                phone: '',
                address: '上海市普陀区金沙江路 1517 弄',
                amount: '',
                picture: ''
            }],
            form: {
                title: '',
                region: ''
            },
            add_form: {
                recordId: '',
                region: '',
                title: '',
                name: '',
                phone: '',
                address: '',
                amount: 0,
                picture: ''
            },
            pictures: [],
            formLabelWidth: '120px'
        }
    },
    mounted: function () {
        vis = this;
        vis.getArea();
        vis.getTableData();
    },
    methods: {
        // 获取地区
        getArea() {
            axios.get('http://localhost:8080/listAreas')
                .then(response => {
                    if (response.data.code == 200) {
                        response.data.results.forEach(element => {
                            vis.options.push(element);
                        });
                    }
                });
        },
        // 获取表格数据
        getTableData() {
            axios.post('http://localhost:8080/listRecords', vis.form)
                .then(response => {
                    if (response.data.code == 200) {
                        vis.tableData = response.data.results;
                    }
                });
        },
        // 查看
        handleClick(picture) {
            picture.split(',').forEach(element => {
                var pic = { "picture": element };
                vis.pictures.push(pic);
            });
        },
        // 新增
        insertRecord() {
            var reg = new RegExp("^[0-9]+(.[0-9]{1,3})?$");
            if (!reg.test(vis.add_form.amount)) {
                vis.warn();
            }
            axios.post('http://localhost:8080/insertRecord', vis.add_form)
                .then(response => {
                    if (response.data.code == 200) {
                        vis.success();
                    }
                });
            vis.dialogFormVisible = false;
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => { });
        },
        warn() {
            this.$notify({
                title: '警告',
                message: '金额请输入数字',
                type: 'warning'
            });
        },
        success() {
            this.$notify({
                title: '成功',
                message: '新增成功',
                type: 'success'
            });
        }
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
