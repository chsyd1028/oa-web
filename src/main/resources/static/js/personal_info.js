var vm = new Vue({
    el : '#personal_info',
    data : {
        personalInfo : {},
        departmentInfo : {}
    },
    methods : {
        getInfo : getInfo,
        getDepartmentInfo : getDepartmentInfo
    },
    created : getAdmin()

})

function getAdmin() {
    getInfo();
    getDepartmentInfo();
}

function getInfo() {
    jQuery.ajax({
        type: "POST",
        url: "/personal/info",
        //data: {username:$("#username").val(), content:$("#content").val()},
        //dataType: "json",
        success: function(result){
            vm.personalInfo = result.value;
        }
    });
}

function getDepartmentInfo() {
    jQuery.ajax({
        type: "POST",
        url: "/personal/departmentInfo",
        //data: {username:$("#username").val(), content:$("#content").val()},
        //dataType: "json",
        success: function(result){
            vm.departmentInfo = result.value;
        }
    });
}