document
	.getElementById("imageUpload")
	.addEventListener("change", function(event) {
		var image = document.getElementById("previewImage");
		image.src = URL.createObjectURL(event.target.files[0]);
	});
function previewImage(event) {
	var image = document.getElementById('previewImage');
	image.src = URL.createObjectURL(event.target.files[0]);
}

document.getElementById("editButton").addEventListener("click", function() {
	// Bỏ disabled của các trường
	document.getElementById("title").removeAttribute("disabled");
	document.getElementById("author").removeAttribute("disabled");
	document.getElementById("description").removeAttribute("disabled");
	document.getElementById("releaseDate").removeAttribute("disabled");
	document.getElementById("pageCount").removeAttribute("disabled");
	document.getElementById("category").removeAttribute("disabled");
	document.getElementById("imageUpload").removeAttribute("disabled");
	document.getElementById("previewImage").removeAttribute("disabled");

	// Hiển thị nút "Save" và ẩn nút "Edit"
	document.getElementById("editButton").style.display = "none";
	document.getElementById("saveButton").style.display = "inline-block";
});

function toggleEditSave() {
	var editButton = document.getElementById("editButton");
	var saveButton = document.getElementById("saveButton");
	var titleField = document.getElementById("title");
	var authorField = document.getElementById("author");
	var descriptionField = document.getElementById("description");
	var releaseDateField = document.getElementById("releaseDate");
	var pageCountField = document.getElementById("pageCount");
	var categoryField = document.getElementById("category");

	if (editButton.style.display === "none") {
		// Hiển thị nút Edit và vô hiệu hóa nút Save
		editButton.style.display = "inline";
		saveButton.style.display = "none";

		// Vô hiệu hóa các trường
		titleField.disabled = true;
		authorField.disabled = true;
		descriptionField.disabled = true;
		releaseDateField.disabled = true;
		pageCountField.disabled = true;
		categoryField.disabled = true;
	} else {
		// Ẩn nút Edit và hiển thị nút Save
		editButton.style.display = "none";
		saveButton.style.display = "inline";

		// Cho phép chỉnh sửa các trường
		titleField.disabled = false;
		authorField.disabled = false;
		descriptionField.disabled = false;
		releaseDateField.disabled = false;
		pageCountField.disabled = false;
		categoryField.disabled = false;
	}
}

function validateDate(input) {
	var dateValue = input.value;
	var dateParts = dateValue.split('-');
	var year = parseInt(dateParts[0]);
	var month = parseInt(dateParts[1]);
	var day = parseInt(dateParts[2]);


	if (month < 1 || month > 12 || day < 1 || day > 31) {
		input.setCustomValidity('Ngày không hợp lệ');
	} else if (month == 2 && day > 28) {
		input.setCustomValidity('Ngày không hợp lệ');
	} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
		input.setCustomValidity('Ngày không hợp lệ');
	} else {
		input.setCustomValidity('');
	}


}

function validateForm() {
	var authorInput = document.getElementById("author");
	var errorMessage = document.getElementById("error-message");

	if (authorInput.value === "") {
		errorMessage.style.display = "block";
		return false;
	}

	return true;
}

function confirmAddBook() {
	var result = confirm("Bạn có muốn thêm sách không?");
	if (result) {
		return true; // Nếu chọn "OK", tiếp tục xóa
	} else {
		return false; // Nếu chọn "Cancel", không thực hiện xóa
	}
}
