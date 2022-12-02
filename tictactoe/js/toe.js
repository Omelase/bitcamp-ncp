let btnRef = document.querySelectorAll(".button-option");
//주어진 선택자와 일치하는 모든 요소를 리스트로 리턴
let popupRef = document.querySelector(".popup");
//주어진 선택자와 일치하는 문서내 첫번째 요소 리턴
let newgameBtn = document.getElementById("new-game");
//주어진 id와 일치하는 요소를 가리키는 변수 리턴
let restartBtn = document.getElementById("restart");
let msgRef = document.getElementById("message");
//let함수는 변수 중복선언 불가하지만 재할당은 가능
let winningPattern = [
    [0, 1, 2],
    [0, 3, 6],
    [2, 5, 8],
    [6, 7, 8],
    [3, 4, 5],
    [1, 4, 7],
    [0, 4, 8],
    [2, 4, 6],
];//승리패턴. 좌상단부터 우방향으로 숫자셈
//Player 'X' plays first
let xTurn = true;
let count = 0;

//Disable All Buttons
const disableButtons = () => {
    btnRef.forEach((element) => (element.disabled = true));
    //enable popup
    popupRef.classList.remove("hide");
};
//disableButtons : 버튼이 사라지는 이벤트 리스너
//=> : function()대신 사용가능
//forEach : 함수를 배열 요소 각각에 실행
//Enable all buttons (For New Game and Restart)
const enableButtons = () => {
    btnRef.forEach((element) => {
        element.innerText = "";
        element.disabled = false;
    });
    //disable popup
    popupRef.classList.add("hide");
};

//This function is executed when a player wins
const winFunction = (letter) => {
    disableButtons();
    if (letter == "X") {
        msgRef.innerHTML = "X 승리!";
    } else {
        msgRef.innerHTML = "O 승리!";
    }
};

//Function for draw
const drawFunction = () => {
    disableButtons();
    msgRef.innerHTML = "무승부!";
};

//New Game
newgameBtn.addEventListener("click", () => {
    count = 0;
    enableButtons();
});
restartBtn.addEventListener("click", () => {
    count = 0;
    enableButtons();
});

//Win Logic
const winChecker = () => {
    //Loop through all win patterns
    for (let i of winningPattern) {
        let [element1, element2, element3] = [
            btnRef[i[0]].innerText,
            btnRef[i[1]].innerText,
            btnRef[i[2]].innerText,
        ];
        //Check if elements are filled
        //If 3 empty elements are same and would give win as would
        if (element1 != "" && (element2 != "") & (element3 != "")) {
            if (element1 == element2 && element2 == element3) {
                //If all 3 buttons have same values then pass the value to winFunction
                winFunction(element1);
            }
        }
    }
};

//Display X/O on click
btnRef.forEach((element) => {
    element.addEventListener("click", () => {
        if (xTurn) {
            xTurn = false;
            //Display X
            element.innerText = "X";
            element.disabled = true;
        } else {
            xTurn = true;
            //Display Y
            element.innerText = "O";
            element.disabled = true;
        }
        //Increment count on each click
        count += 1;
        if (count == 9) {
            drawFunction();
        }
        //Check for win on every click
        winChecker();
    });
});
//Enable Buttons and disable popup on page load
window.onload = enableButtons;