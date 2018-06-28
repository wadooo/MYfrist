/**
 * 
 */

// 实时定位表添加行
function ssdwdgAddRow() {
	$('#ssdwdg').datagrid('appendRow', {
		name : '000',
		state : '000'
	});
	rows = $('#ssdwdg').datagrid('getRows');
	
}

// 实时定位表双击事件
function ssdwdgDblClickRow(rowIndex, rowData) {
	alert(rowIndex + "\n" + rowData.name + "\n" + rowData.state);
}

var rows;
// 实时定位表查询
function ssdwdgSelect(name) {
	if (rows == null) {
		rows = $('#ssdwdg').datagrid('getRows');
	}
	var rst = [];
	for (var i = 0; i < rows.length; i++) {
		if (rows[i].name.indexOf(name)!=-1)
			rst.push(rows[i]);
	}
	$('#ssdwdg').datagrid('loadData', rst);
	
}

// 实时定位表清空
function ssdwdgClear() {
	$('#ssdwdg').datagrid("loadData", {
		total : 0,
		rows : []
	});
	rows = $('#ssdwdg').datagrid('getRows');

}