let gids = [];
function checkChanged(checkbox,gid){
    if (checkbox.checked){
        gids.push(gid);
    }
    else{
        gids = $.grep(gids, function(value) {
            return value != gid;
        });
    }
    console.log(gids);
}

function batchDelete(){
    if (gids.length == 0)   return;
    $.ajax({
        url: '/batchDeleteGoods',
        type: 'POST',
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(gids),
        async:false,
        success: function() {

        },
        error: function() {

        }
    });
    $(location).attr('href', '/goods_admin');
}

