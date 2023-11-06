let xValid = true, yValid = true, rValid = true;


const messages = document.getElementById('messages');

// document.addEventListener("DOMContentLoaded", function() {
//     // Получаем элементы кнопок и скрытого поля 'X'
//     var xButtons = document.querySelectorAll("#xBtn p\\:commandButton");
//     var xInput = document.querySelector("#X");
//
//     // Добавляем обработчики событий к каждой кнопке
//     xButtons.forEach(function(button) {
//         button.addEventListener("click", function(event) {
//             var value = event.target.value; // Получаем значение кнопки
//             xInput.value = value; // Устанавливаем значение в скрытое поле 'X'
//         });
//     });
// });

// X radio validation
let xInput = document.getElementById('form:X');
const xRadioInput = document.getElementById('xBtn');
const xRadioInputs = xRadioInput.querySelectorAll('button');
console.log(xRadioInput);
console.log(xRadioInputs);
xRadioInputs.forEach(button => {
    console.log(button.value);
    button.addEventListener('click', () => {
        xInput.value = button.textContent;
        xValid = true;
        toggleSubmitBtn();
    })
});

// // Y input field validation
// let yInput = document.getElementById('form:Y');
// yInput.addEventListener('input', () => {
//     yValid = yInput.value.length > 0;
//     toggleSubmitBtn();
// })
//
// R buttons validation
let rInput = document.getElementById('form:R');
const rRadioInput = document.getElementById('rRadio');
const rRadioInputs = rRadioInput.querySelectorAll('input');
rRadioInputs.forEach(radio => {
    radio.addEventListener('input', () => {
        rInput.value = radio.value;
        rValid = true;
        drawG(rInput.value);
        toggleSubmitBtn();
    })
});

const submitBtn = document.getElementById('form:submitBtn');
function toggleSubmitBtn() {
    // check X, Y, R validity
    submitBtn.disabled = !(xValid && yValid && rValid)
}

// xInput.value = '';
// yInput.value = '';
// rInput.value = '';
// toggleSubmitBtn()