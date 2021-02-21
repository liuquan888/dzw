var vm = new Vue({
				el: "#example",
				data: {
					arr: arrAll,
					prov: '北京',
					city: '北京',
					district: '东城区',
					cityArr: [],
					districtArr: []
				},
				methods: {
					updateCity: function() {
						for(var i in this.arr) {
							var obj = this.arr[i];
							if(obj.name == this.prov) {
								this.cityArr = obj.sub;
								break;
							}
						}
						this.city = this.cityArr[1].name;
					},
					updateDistrict: function() {
						for(var i in this.cityArr) {
							var obj = this.cityArr[i];
							if(obj.name == this.city) {
								this.districtArr = obj.sub;
								break;
							}
						}
						if(this.districtArr && this.districtArr.length > 0 && this.districtArr[1].name) {
							this.district = this.districtArr[1].name;
						} else {
							this.district = '';
						}
					}
				},
				beforeMount: function() {
					this.updateCity();
					this.updateDistrict();
				},
				watch: {
					prov: function() {
						this.updateCity();
						this.updateDistrict();
					},
					city: function() {
						this.updateDistrict();
					}
				}
			})