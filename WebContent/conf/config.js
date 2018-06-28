/**
 * 地图服务对象(map)、图层(layer)、地图服务(URL)、图层名称(NAME)、标记图层(MARKERLAYER)
 */
var map;
var layer;
var URL = "http://192.168.1.115:8090/iserver/services/map-harbin/rest/maps/Harbin";
var NAME = "Harbin";
var MARKERLAYER = new SuperMap.Layer.Markers("markerLayer");
/**
 * 数据地址(DATA_URL)、数据源名(DATASOURCE_NAME)
 */
var DATA_URL = "http://192.168.1.115:8090/iserver/services/data-City-Harbin/rest/data";
var DATASOURCE_NAME = "Harbin";

