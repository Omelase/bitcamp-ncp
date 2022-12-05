// console.log("Hello!")
//어떤 문법은 세미콜론없어도 실행가능
//다 다르기 때문에 그냥 세미콜론붙이는게 편함

const express = require('express');
const app = express();
const port = 3000;

// const delay = async () => {
//   console.log('====> 잠들다!');
//   await sleep(5000);
//   console.log('====> 깨어나다!');
// };
// const sleep = (ms) => {
//   return new Promise((resolve) => {
//     setTimeout(resolve, ms);
//   });
// };
// function handleHello(req, res) {
//   res.send('Hello!');
// }아예 함수를 파라미터에 집어넣을 수도 있음. 집어넣으면 굳이 이름(handleHello)필요없음

// function execute(resolve, reject) {
//   console.log('작업수행!');
//   reject();
// }

// function success() {
//   console.log('success!');
// }

// function fail() {
//   console.log('fail!');
// }

// function final() {
//   console.log('completed!');
// }

app.get('/hello', async (req, res) => {
  //이 함수 안에 순차 실행이 아니라 병렬 실행(비동기작업)하는 코드가 있다.
  //이 밑 함수는 서포터가 실행
  await new Promise(function (resolve, reject) {
    //새 약속을 만든 후 약속 다 이행될 때까지 기다려라
    setTimeout(resolve, 5000);
    // function () {
    // console.log('5초 지났다!');
    // resolve();
    //resolve지워버리면 약속이 다 이행 안 되기 때문에 브라우저에서 무한 로딩
    // }, 5000);
    //5초(5000ms) 후에 함수 호출 예약
    // console.log('작업수행!');
    // reject();
    // resolve();
  });
  //새로운 약속(계약서) 작성
  //등록된 것 다 호출
  // p1.then(function () {
  //   console.log('success!');
  // });
  // //성공했을 때 실행
  // // p1.catch(fail);
  // // //실패했을 때 실행
  // p1.finally(() => {
  //   console.log('completed!');
  // });
  //어떤 상황이든 실행
  //이 아래 함수들은 main이 실행
  console.log('Hello!');
  //콘솔창 출력
  res.send('Hello!');
  //웹브라우저 출력
});
//arrow function은 function()과 같은 기능
app.get('/exam05_1', async (req, res) => {
  // await new Promise((resolve, reject) => {
  //   setTimeout(resolve, 10000);
  // });
  await new Promise((resolve) => setTimeout(resolve, 10000));
  //10초 후에 resolve가 호출되도록 예약, 예약 이행할 때까지 기다려
  //파라미터가 하나면 괄호 생략가능, 함수 하나면 중괄호 생략 가능
  // delay();
  // for (var i = 0; i < 100000; i++) {
  //   var r = Math.random() * Math.random();
  //   console.log(r);
  // }
  // res.header("Access-Control-Allow-Origin", "*");
  res.send('console.log("exam05_1 ok!");');
});
//루트로 get요청이 들어오면 이 문장을 보낸다.

app.get('/exam05_2', (req, res) => {
  // res.header("Access-Control-Allow-Origin", "*");
  // res.send('exam05_2 ok!');
  res.send('console.log("exam05_2 ok!");');
});

app.get('/exam05_x', async (req, res) => {
  await new Promise((resolve, reject) => {
    setTimeout(resolve, 10000);
  });
  // delay();
  // for (var i = 0; i < 100000; i++) {
  //   var r = Math.random() * Math.random();
  //   console.log(r);
  // }
  // res.header("Access-Control-Allow-Origin", "*");
  res.send('var rate = 30000;');
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

//터미널에 node app.js입력 (나가는법은 ctrl+c)
//주소창에 http://localhost:3000/ 입력

//함수 안 맨끝 문장은 세미콜론 안 붙여도 되지만 구글에선 붙이는 것 권장
