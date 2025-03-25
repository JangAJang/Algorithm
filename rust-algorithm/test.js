
function requestChannelLicenseSetDialog(selectedRowData, dataGrid) {
	const channelId = selectedRowData.channelId;
	const channelSeq = selectedRowData.channelSeq;
	const originDomainLicenseSet = selectedRowData.licenseSet;
	const originCheckMenu = selectedRowData.checkMenu;
	const originAnalysisWeight = selectedRowData.analysisWeightSet;
	const originAnalysisResultDisplay = selectedRowData.analysisResultDisplay;

	console.log('channel checkMenu=' + originCheckMenu.toString())

	// dialog 초기화
	const dialog = $('#license-set-edit-dialog');
	dialog.empty();

	// 다이얼로그 내용 업데이트
	dialog.dialog({
		title: `라이선스 설정(채널ID: ${channelId}, 채널SEQ: ${channelSeq})`,
		autoOpen: false, // 초기에는 자동으로 열리지 않음
		modal: true, // 모달 다이얼로그로 설정
		closed: true
	});

	// 라이선스 설정 메뉴얼 다이얼로그에 append
	dialog.append(licenseManual);

	// 라이선스 타입 아이템 radio 버튼 append
	const licenseTypeWrap = $("<div class='license-set-type-wrap'></div>");

	_.each(licenseTypeItems, function (licenseType) {
		let label = $("<label></label>");

		let inputRadio;
		if (licenseType.value === originDomainLicenseSet?.licenseType) {
			inputRadio = $(`<input class='license-set-radio' type='radio' name='license-type' value='${licenseType.value}' checked>`);
		} else {
			inputRadio = $(`<input class='license-set-radio' type='radio' name='license-type' value='${licenseType.value}'>`);
		}

		let licenseTypeNameSpan = $(`<span>${licenseType.text}</span>`);

		label.append(inputRadio);
		label.append(licenseTypeNameSpan);
		licenseTypeWrap.append(label);
	});
	// 라이선스 타입 항목 다이얼로그에 append
	dialog.append($("<h3>라이선스 타입</h3>"));
	dialog.append(licenseTypeWrap);

	// 프리즘 검사항목 checkbox append
	const checkMenuCheckBoxWrap = $("<div class='checkMenu-checkbox-wrap'></div>");

	_.each(prismCheckMenuItems, function (prismCheckMenu) {
		let label = $("<label></label>");
		let inputCheckbox;
		if (originCheckMenu.includes(prismCheckMenu.value)) {
			inputCheckbox = $(`<input class='checkMenu-checkbox' type='checkbox' name='checkMenu' value='${prismCheckMenu.value}' checked>`);
		} else {
			inputCheckbox = $(`<input class='checkMenu-checkbox' type='checkbox' name='checkMenu' value='${prismCheckMenu.value}'>`);
		}

		let checkMenuNameSpan = $(`<span>${prismCheckMenu.text}</span>`);

		label.append(inputCheckbox);
		label.append(checkMenuNameSpan);

		checkMenuCheckBoxWrap.append(label);
		checkMenuCheckBoxWrap.append($("<br/>"));
	});
	// 프리즘 검사항목 다이얼로그에 append
	dialog.append($("<br/><h3>프리즘 검사항목</h3>"));
	dialog.append(checkMenuCheckBoxWrap);

	// 프리즘 분석 가중치 textArea append
	if (selectedRowData.requiredRecruit) {
		addPrismAnalysisWeight(dialog, originAnalysisWeight);
	}

	// 프리즘 결과 표기여부 checkbox append
	addPrismResultDisplay(dialog, selectedRowData, originAnalysisResultDisplay);

	// 적용 버튼
	const confirmButton = $("<button id='license-set-confirm-button'>적용</button>");
	dialog.append(confirmButton);


	dialog.dialog("open");

	confirmButton.on('click', () => {
		const selectedLicenseType = $("input[name='license-type']:checked").val();

		const selectedCheckMenuCheckBoxes = $("input[name='checkMenu']:checked");
		const selectedCheckMenuValues = Array.from(selectedCheckMenuCheckBoxes).map(checkbox => checkbox.value);

		console.log('selectedCheckMenuValues=', selectedCheckMenuValues);

		const requestBody = {
			licenseSet: {
				licenseType: selectedLicenseType,
			},
			prismRoomInfo: {
				checkMenu: selectedCheckMenuValues
			},
			analysisWeightSet: getAnalysisWeightSet(),
			analysisResultDisplay: getAnalysisResultDisplay()
		};

		console.log('requestBody:', JSON.stringify(requestBody, null, 2));

		// 라이선스 v1: 업데이트 요청
		Ajax.request(`/api/admin/v1/channels/${channelSeq}/license-set`,
			'patch',
			requestBody,
			(response) => {
				if (response.data.status && response.data.status !== 200) {
					alert(response.data.message);
					return;
				}
                
				alert(`채널ID: ${channelId} 채널의 라이선스를 설정하였습니다.`);
				dataGrid.reload();
				dialog.dialog("close");
			},
			(error) => {
				alert(error.message);
			}
		);
	});
}