let vis;
let vm = new Vue({
    name: "data",
    el: "#app",
    data: function () {
        return {
            title: '',
            insertType: false,
            updateType: false,
            dialogVisible: false,
            dialogFormVisible: false,
            pageSizes: [10, 20, 30, 40, 50],
            total: 0,
            options: [
                { areaCode: "", areaName: "请选择" }
            ],
            tableData: [],
            form: {
                title: '',
                areaCode: '',
                page: 1,
                pageSize: 10
            },
            add_form: {
                recordId: '',
                areaCode: '',
                title: '',
                name: '',
                phone: '',
                address: '',
                amount: 0,
                picture: '',
                effectiveTime: ''
            },
            fileList: [],
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
                        vis.tableData = response.data.results.list;
                        vis.total = response.data.results.total;
                    }
                });
        },
        // 查看
        handleClick(picture) {
            vis.pictures = [];
            vis.dialogVisible = true;
            picture.split(',').forEach(element => {
                if (element != '') {
                    let pic = { "picture": '../static/images/upload' + element};
                    vis.pictures.push(pic);
                }
            });
        },
        // 新增
        insertRecord() {
            let reg = new RegExp("^[0-9]+(.[0-9]{1,3})?$");
            if (!reg.test(vis.add_form.amount)) {
                vis.warn('金额请输入数字');
                return;
            }
            axios.post('http://localhost:8080/insertRecord', vis.add_form)
                .then(response => {
                    if (response.data.code == 200) {
                        vis.success('新增成功');
                        vis.dialogFormVisible = false;
                        vis.getTableData();
                    } else if (response.data.code == 500) {
                        vis.warn(response.data.msg);
                    } else {
                        vis.error('新增失败');
                    }
                });
        },
        // 编辑
        updateRecord() {
            let reg = new RegExp("^[0-9]+(.[0-9]{1,3})?$");
            if (!reg.test(vis.add_form.amount)) {
                vis.warn('金额请输入数字');
                return;
            }
            axios.post('http://localhost:8080/updateRecord', vis.add_form)
                .then(response => {
                    if (response.data.code == 200) {
                        vis.success('修改成功');
                        vis.dialogFormVisible = false;
                        vis.getTableData();
                    }
                });
        },
        // 删除
        deleteRecord(recordId) {
            this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                axios.delete('http://localhost:8080/deleteRecord', {
                    params: {
                        recordId: recordId
                    }
                }).then(response => {
                    if (response.data.code == 200) {
                        this.$message({
                            type: 'success',
                            message: '删除成功'
                        });
                        vis.getTableData();
                    }
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        },
        handleRemove(file, fileList) {
            let pictureUrl = "";
            fileList.forEach(file => {
                if (file.response == 200) {
                    pictureUrl += file.response.results + ",";
                }
            });
            vis.add_form.picture = pictureUrl;
        },
        uploadSuccess(response, file, fileList) {
            let pictureUrl = "";
            fileList.forEach(file => {
                if ("response" in file) {
                    if (file.response.code == '200') {
                        pictureUrl += file.response.results + ",";
                    }
                } else {
                    pictureUrl += file.url.split('upload')[1] + ",";
                }
            });
            vis.add_form.picture = pictureUrl;
        },
        // 新增窗
        showForm() {
            vis.title = '新增记录';
            vis.fileList = [];
            vis.add_form = {};
            vis.updateType = false;
            vis.insertType = true;
            vis.dialogFormVisible = true;
        },
        // 编辑窗
        showUpdateForm(record) {
            vis.fileList = [];
            vis.title = '修改记录';
            vis.insertType = false;
            vis.updateType = true;
            vis.add_form = record;
            if (record.picture != '') {
                record.picture.split(',').forEach(pic => {
                    let addPic = {
                        name: '',
                        url: ''
                    };
                    if (pic != '') {
                        addPic.url = "../static/images/upload" + pic;
                        vis.fileList.push(addPic);
                    }
                })
            }
            vis.dialogFormVisible = true;
        },
        // 修改pageSize
        handleSizeChange(val) {
            vis.form.pageSize = val;
            vis.getTableData();
        },
        // 上一页下一页
        handleCurrentChange(val) {
            vis.form.page = val;
            vis.getTableData();
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                })
                .catch(_ => { });
        },
        warn(message) {
            this.$notify({
                title: '警告',
                message: message,
                type: 'warning'
            });
        },
        success(message) {
            this.$notify({
                title: '成功',
                message: message,
                type: 'success'
            });
        },
        error(message) {
            this.$message.error(message);
        }
    },
    filters: {
        cutstr: function (str, aount) {
            let str_length = 0;
            let str_len = 0;
            let len = aount;
            let str_cut = new String();
            str_len = str.length;
            for (let i = 0; i < str_len; i++) {
                let a = str.charAt(i);
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
