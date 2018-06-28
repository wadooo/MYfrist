/**
 * 举报定位
 */
// 举报定位表查询
function Select(Query) {
	$('#Report_list').empty();
	if(Query==""){
		return;
	}
	
	var getFeatureParam, getFeatureBySQLService, getFeatureBySQLParams;

//SuperMap获取数据
	getFeatureParam = new SuperMap.REST.FilterParameter({
	name: "Harbin",
	attributeFilter: "NAME like '%"+Query+"%'"
	});
	getFeatureBySQLParams = new SuperMap.REST.GetFeaturesBySQLParameters({
	queryParameter: getFeatureParam,
	datasetNames:["Harbin:高等院校P_1","Harbin:保险公司P_1","Harbin:餐饮服务P_1","Harbin:地铁站点P_1","Harbin:公司企业P_1","Harbin:普通医院P_1","Harbin:火车站P_1","Harbin:五星级宾馆P_1","Harbin:银行P_1"]
	});
	getFeatureBySQLService = new SuperMap.REST.GetFeaturesBySQLService(DATA_URL, {
	eventListeners: {"processCompleted": processCompleted, "processFailed": processFailed}});

	getFeatureBySQLService.processAsync(getFeatureBySQLParams);

//	var rst = [];
//	for (var i = 0; i < rows.length; i++) {
//		if (rows[i].name.indexOf(name)!=-1)
//			rst.push(rows[i]);
//	}
//	var data = "";
	function processCompleted(getFeaturesEventArgs) {
		var i, len, features, feature, result = getFeaturesEventArgs.result;
		if (result && result.features) {
		features = result.features
		
		for (i=0, len=features.length; i<len; i++) {
				$('#Report_list').append("<li><a href=\"javascript:;\" onclick=clickaction("+features[i].data.SMX+","+features[i].data.SMY+","+"/"+features[i].data.CTYPE+"/"+")>"+features[i].data.NAME+"</a></li>");
		}
		}
		}
	function processFailed(e) {
		alert(e.error.errorMsg);
		}

}

/**
 * 举报定位 定位
 * @param x 经度
 * @param y 纬度
 * @param text 内容
 */
function clickaction(x,y,text){
	
	var lonLat = new SuperMap.LonLat(x,y);
	map.panTo(lonLat);
	map.zoomTo(5);
	
	var size = new SuperMap.Size(43,49);
	var offset = new SuperMap.Pixel(-(size.w/2), -size.h);
	var icon = new SuperMap.Icon("img/weizhi-原版.png", size, offset);
	var marker = new SuperMap.Marker(lonLat,icon) ;
	//注册 click 事件,触发 mouseClickHandler()方法
	marker.events.on({"click":mouseClickHandler,
	"touchstart":mouseClickHandler //假如要在移动端的浏览器也实现点击弹框，则在注册touch类事件
	});
	//清除Popup
	map.removeAllPopup();
	//清除之前的marker
	MARKERLAYER.clearMarkers();	
	//将markerlayer添加到map中
	MARKERLAYER.addMarker(marker);
	
	var infowin = null;
	//定义mouseClickHandler函数，触发click事件会调用此函数
	function mouseClickHandler(event){
	closeInfoWin();
	//气泡显示内容
	var contentHTML = "<div style='width:80px; font-size:12px;font-weight:bold ; opacity: 0.8'>"; 
	contentHTML += text;
	contentHTML += "</div>"; 
	//初始化Anchored类
	popup = new SuperMap.Popup.Anchored(
	"chicken",
	marker.getLonLat(),
	null,
	contentHTML,
	icon,
	true,
	null,
	true
	);

	infowin = popup;
	//添加弹窗到map图层
	map.addPopup(popup);
	}
	
	function closeInfoWin(){
		if(infowin){
		try{
		infowin.hide();
		infowin.destroy();
		}
		catch(e){}
		}
		}

}

