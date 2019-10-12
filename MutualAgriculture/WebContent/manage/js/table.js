/**
 * 
 */

$(document).ready(function() {
	$('#example').DataTable({
    	"oLanguage": {
                "oAria": {
                    "sSortAscending": " - click/return to sort ascending",
                    "sSortDescending": " - click/return to sort descending"
                },
                "sLengthMenu": "显示 _MENU_ 记录",
                "sZeroRecords": "对不起，查询不到任何相关数据",
                "sEmptyTable": "没有相关数据",
                "sLoadingRecords": "正在加载数据-请等待...",
                "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
                "sInfoEmpty": "当前显示0到0条，共0条记录",
                "sInfoFiltered": "（数据库中共为 _MAX_ 条记录）",
                "sProcessing": "正在加载数据...",
                "sSearch": "模糊查询：",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": " 上一页 ",
                    "sNext": " 下一页 ",
                    "sLast": " 尾页 "
                },
                //多语言配置
                // set the initial value
                "fnCreatedRow": function(nRow, aData, iDataIndex) {
                    $('td:eq(0)', nRow).html("<span class='row-details row-details-close' data_id='" + aData[1] + "'></span>&nbsp;" + aData[0]);
                }
          }
    });
})
		