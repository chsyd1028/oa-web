var vm = new Vue({
    el : '#member',
    data : {
        memberList : [],
    },
    methods : {
        getList : getList
    },
    created : getList()
})

function getList() {
    $.ajax({
        type: "POST",
        url: "/member/memberList",
        //data: {username:$("#username").val(), content:$("#content").val()},
        //dataType: "json",
        success: function(result){
            vm.memberList = result.value;
        }
    });
}