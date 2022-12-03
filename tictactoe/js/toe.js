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
//X플레이어부터 시작
let xTurn = true;
let count = 0;

//모든 버튼 숨기기
const disableButtons = () => {
    btnRef.forEach((element) => (element.disabled = true));
    //enable popup
    popupRef.classList.remove("hide");
};
//disableButtons : 버튼이 사라지는 이벤트 리스너
//=> : function()대신 사용가능
//forEach : 함수를 배열 요소 각각에 실행
//새 게임 또는 다시하기일 때 모든 버튼보여짐
const enableButtons = () => {
    btnRef.forEach((element) => {
        element.innerText = "";
        element.disabled = false;
    });
    //팝업숨기기
    popupRef.classList.add("hide");
};

//이길 때
const winFunction = (letter) => {
    disableButtons();
    if (letter == "X") {
        msgRef.innerHTML = "X 승리!";
    } else {
        msgRef.innerHTML = "O 승리!";
    }
};

//무승부일때
const drawFunction = () => {
    disableButtons();
    msgRef.innerHTML = "무승부!";
};

//새 게임
newgameBtn.addEventListener("click", () => {
    count = 0;
    enableButtons();
});
restartBtn.addEventListener("click", () => {
    count = 0;
    enableButtons();
});

//승리조건
const winChecker = () => {
    //모든 승리패턴 반복
    for (let i of winningPattern) {
        let [element1, element2, element3] = [
            btnRef[i[0]].innerText,
            btnRef[i[1]].innerText,
            btnRef[i[2]].innerText,
        ];
        //요소가 다 채워질 경우 체크
        //빈 요소 3개가 동일하고 승리를 가져올 경우
        if (element1 != "" && (element2 != "") & (element3 != "")) {
            if (element1 == element2 && element2 == element3) {
                //3개의 버튼이 모두 같은 값이면 winFunction에 값 전달
                winFunction(element1);
            }
        }
    }
};

//클릭할 때 O 또는 X 보여줌
btnRef.forEach((element) => {
    element.addEventListener("click", () => {
        if (xTurn) {
            xTurn = false;
            //X보임
            element.innerText = "X";
            element.disabled = true;
        } else {
            xTurn = true;
            //O보임
            element.innerText = "O";
            element.disabled = true;
        }
        //클릭할 때마다 카운트 증가
        count += 1;
        if (count == 9) {
            drawFunction();
        }
        //클릭할 때마다 승리조건 확인
        winChecker();
    });
});
//버튼 활성화 및 페이지 로드 시 팝업 비활성화
window.onload = enableButtons;