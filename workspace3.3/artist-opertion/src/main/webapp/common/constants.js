if (typeof (Constants) == 'undefined') {
	Constants = {};
}
(function() {
	var mConstants = {
			upgradeMethod : {
				"0" : "静默升级",
				"1" : "标准升级"
			},
			YesNo : {
				"0" : "否",
				"1" : "是"
			}
	};

	$.extend(Constants, mConstants, true);
})();
