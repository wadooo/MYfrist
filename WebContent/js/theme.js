/**
 * 专题图
 */

function addThemeRange() {
removeTheme();
var themeService = new SuperMap.REST.ThemeService(URL, {eventListeners:{"processCompleted": themeCompleted, "processFailed": themeFailed}}),
style1 = new SuperMap.REST.ServerStyle({
fillForeColor: new SuperMap.REST.ServerColor(137,203,187),
lineColor: new SuperMap.REST.ServerColor(0,0,0),
lineWidth: 0.1
}),
style2 = new SuperMap.REST.ServerStyle({
fillForeColor: new SuperMap.REST.ServerColor(233,235,171),
lineColor: new SuperMap.REST.ServerColor(0,0,0),
lineWidth: 0.1
}),
style3 = new SuperMap.REST.ServerStyle({
fillForeColor: new SuperMap.REST.ServerColor(135,157,157),
lineColor: new SuperMap.REST.ServerColor(0,0,0),
lineWidth: 0.1
}),
themeRangeIteme1 = new SuperMap.REST.ThemeRangeItem({
start: 0,
end: 500000000000,
style: style1
}),
themeRangeIteme2 = new SuperMap.REST.ThemeRangeItem({
start: 500000000000,
end: 1000000000000,
style: style2
}),
themeRangeIteme3 = new SuperMap.REST.ThemeRangeItem({
start: 1000000000000,
end: 3000000000000,
style: style3
}),
themeRange = new SuperMap.REST.ThemeRange({
rangeExpression: "SMAREA",
rangeMode: SuperMap.REST.RangeMode.EQUALINTERVAL,
items: [themeRangeIteme1,themeRangeIteme2,themeRangeIteme3]
}),
themeParameters = new SuperMap.REST.ThemeParameters({
datasetNames: ["保险公司P_1"],
dataSourceNames: ["Harbin"],
joinItems: null,
themes: [themeRange]
});

themeService.processAsync(themeParameters);
}

function themeCompleted(themeEventArgs) {
if(themeEventArgs.result.resourceInfo.id) {
themeLayer = new SuperMap.Layer.TiledDynamicRESTLayer("中国各省面积_分段专题图", URL, {cacheEnabled:false,transparent: true,layersID: themeEventArgs.result.resourceInfo.id}, {"maxResolution":"auto"});
themeLayer.events.on({"layerInitialized":addThemelayer});

}
}
function addThemelayer() {
map.addLayer(themeLayer);
}
function themeFailed(serviceFailedEventArgs) {
//doMapAlert("",serviceFailedEventArgs.error.errorMsg,true);
alert(serviceFailedEventArgs.error.errorMsg);
}

function removeTheme() {
if (map.layers.length > 1) {
map.removeLayer(themeLayer, true);
}
}