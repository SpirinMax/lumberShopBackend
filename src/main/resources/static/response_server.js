
function serializeForm(formNode) {
	return new FormData(formNode)
}

async function handleFormSubmit(event) {
	event.preventDefault();
	console.log('Отправка!')


	const data = serializeForm(event.target);
	console.log(Array.from(data.entries()))
	const response = await sendData(data);

	if (response.status === 401) {
		alert("Неверный логин или пароль");
	}

	if (response.status === 200) {
		window.location.href = '/goMain';
		//goToMain();
	}

}

function goToMain() {
	var main_page_url = "/main?user=" + "11";
	window.location.href = main_page_url;
	//return fetch('/main?user=1', {method: 'GET'});
}

async function sendData(data) {
	return await fetch('/auth', {
		method: 'POST',
		//headers: { 'Content-Type': 'multipart/form-data' },
		body: data
	});
}

const applicantForm = document.getElementById('auth_form');
applicantForm.addEventListener('submit', handleFormSubmit);
