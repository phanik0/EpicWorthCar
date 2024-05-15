$(document).ready(function() {

	const daysElement = $('.days');
	const monthYearElement = $('#monthYear');
	const prevButton = $('#prevBtn');
	const nextButton = $('#nextBtn');
	let startDate = null;
	let endDate = null;

	let currentDate = new Date();

	
	function generateCalendar(year, month) {
		daysElement.empty();
		monthYearElement.text(getMonthName(month) + ' ' + year);

		const firstDayOfMonth = new Date(year, month, 1);
		const lastDayOfMonth = new Date(year, month + 1, 0);
		const startingDay = firstDayOfMonth.getDay();

		for (let i = 0; i < startingDay; i++) {
			daysElement.append('<div class="day disabled"></div>');
		}

		for (let i = 1; i <= lastDayOfMonth.getDate(); i++) {
			const dayElement = $('<div class="day" id="day"></div>');
			const labelElement = $('<label name = "day">' + i + '</label>'); // <label> 요소 생성
			dayElement.append(labelElement);
			dayElement.on('click', function() {
				console.log(startDate);
				console.log(endDate);
				if (!startDate) {
					startDate = new Date(year, month, i);
					dayElement.addClass('selected');
					dayElement.attr('id', 'startDay');
					labelElement.attr('name', 'startDay');
					const formatStartDate = formatDate(startDate);
					$('#startDayInput').val(formatStartDate);
				} else if (!endDate) {
					endDate = new Date(year, month, i);
					if (startDate >= endDate) {
						alert('종료일은 시작일 이후여야 합니다.');
						endDate = null;
						return;
					}
					dayElement.addClass('selected');
					dayElement.attr('id', 'endDay');
					labelElement.attr('name', 'endDay');
					const formatEndDate = formatDate(endDate);
					$('#endDayInput').val(formatEndDate);
					console.log('Selected range:', startDate, '-', endDate);

					// 여기서 선택한 날짜로 무언가를 하실 수 있습니다.
				} else {
					// 이미 시작일과 종료일이 선택되어 있는 경우, 선택을 초기화합니다.
					startDate = new Date(year, month, i);
					endDate = null;
					$('#startDay').attr('id', 'day');
					$('#endDay').attr('id', 'day');
					$('.day').removeClass('selected');
					dayElement.addClass('selected');
					dayElement.attr('id', 'startDay');
					labelElement.attr('name', 'startDay');
					const formatStartDate = formatDate(startDate);

					$('#startDayInput').val(formatStartDate);

				}
			});
			daysElement.append(dayElement);
		}
	}
	function formatDate(date) {
    const year = date.getFullYear();
    const month = padZero(date.getMonth() + 1); // 월은 0부터 시작하므로 1을 더해줍니다.
    const day = padZero(date.getDate());
    return `${year}-${month}-${day}`;
}

function padZero(num) {
    return num < 10 ? '0' + num : num; // 한 자리 수일 경우 앞에 0을 붙여 두 자리로 만듭니다.
}
	function getMonthName(month) {
		const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
		return months[month];
	}

	generateCalendar(currentDate.getFullYear(), currentDate.getMonth());

	prevButton.on('click', function() {
		currentDate.setMonth(currentDate.getMonth() - 1);
		generateCalendar(currentDate.getFullYear(), currentDate.getMonth());
	});

	nextButton.on('click', function() {
		currentDate.setMonth(currentDate.getMonth() + 1);
		generateCalendar(currentDate.getFullYear(), currentDate.getMonth());
	});
	  $('form').on('submit', function(e) {
       
            e.preventDefault(); // form 제출 방지
        
        });
});
