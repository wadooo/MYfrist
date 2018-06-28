/**
 * 初始化
 */
	function init() {
		/**
		 * 地图加载
		 */
		map = new SuperMap.Map("map");
		//创建分块动态REST图层，该图层显示iserver 8C 服务发布的地图,
		//其中"world"为图层名称，url图层的服务地址，{transparent: true}设置到url的可选参数
		layer = new SuperMap.Layer.TiledDynamicRESTLayer(NAME, URL,
				null, {
					maxResolution : "auto"
				});
		
		layer.events.on({
			"layerInitialized" : addLayer
		});
		/**
		 * 添加图层、设置中心点、缩放级别
		 */
		function addLayer() {
			//将Layer图层加载到Map对象上
			map.addLayer(layer);
			map.addLayer(MARKERLAYER);
			//出图，map.setCenter函数显示地图
			map.setCenter(new SuperMap.LonLat(14257829.1217519995,5715902.0880247001), 2);
		}
		
		/**
		 * 页面尺寸大小
		 */
		var fixed_height = document.getElementById("titleheader").clientHeight;
		var height = document.documentElement.clientHeight - fixed_height;
		// document.getElementById("map").style.height=height+"px";
		$("#map").css({
			"height" : document.documentElement.clientHeight - fixed_height
		});
		
		CloseAllPanel();
		RegisterDataGridEvent();
		RegisterPanelEvent();

	}