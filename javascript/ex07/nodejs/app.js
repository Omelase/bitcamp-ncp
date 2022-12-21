// express라이브러리 로딩하기
const express = require('express');

// HTTP 요청을 다루는 라이브러리 로딩하기
const request = require('request'); // request 모듈을 로딩해 request에 할당

// POST 요청으로 보낸 payload를 분석하는 라이브러리 로딩하기
// const bodyParser = require('body-parser');

const port = 3000; // 웹서버 포트 번호

// express()를 호출하여 웹서버를 준비한다.
const app = express();

// POST 요청으로 보낸 payload 데이터를 분석할 객체를 지정하기
// => Content-Type: application/x-www-form-urlencoded 형식으로 된 payload 처리
//    ex) name=hong&age=20

// let options = new Object();
// options.extended = true;

// let options = {
//   extended: true
// };

app.use(express.urlencoded({ extended: true }));

// 클라이언트 요청에 대해 호출될 메서드를 등록
app.get(
  // GET 요청이 들어왔을 때 호출될 메서드 지정
  '/exam01-1', // 요청 URL
  (req, res) => {
    // 요청 핸들러: 요청이 들어왔을 때 호출되는 메서드
    res.set('Access-Control-Allow-Origin', '*'); // CORS 문제 해결
    res.set('Content-Type', 'text/plain; charset=UTF-8');
    res.send('Hello!(이예찬)');
  }
);

// app.js에서 사용하는 명령어들은 서버에서 사용하는 것. 브라우저에서 실행 안 됨

// 백엔드 프로그램이 잘 돌아가는지 먼저 확인
// http://localhost:3000/exam02-1?name=aaa&age=20
app.get('/exam02-1', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/plain; charset=UTF-8');

  var payload = `이름: ${req.query.name}\n`;
  payload += `나이: ${req.query.age}\n`;
  res.send(payload);

  //   res.send(`이름: ${req.query.name}\n
  // 나이: ${req.query.age}`); // res.send는 한 번만 사용가능. 보내고 끝내기 때문
});

app.post('/exam02-2', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/plain; charset=UTF-8');

  var payload = `이름: ${req.body.name}\n`;
  payload += `나이: ${req.body.age}\n`;
  res.send(payload);
});

app.get('/exam03-1', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/plain; charset=UTF-8');

  setTimeout(() => {
    res.send('Hello!');
  }, 15000);
});

app.get('/exam03-4', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/plain; charset=UTF-8');

  let a = parseInt(req.query.a);
  let b = parseInt(req.query.b);
  res.send(`${a + b}`);
});

app.get('/header', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/html; charset=UTF-8'); // text/plain쓰면 태그까지 문자로 인식해 출력

  res.send('<h1>비트캠프 네이버 클라우드 AIaaS 개발자 양성 과정</h1>');
});

app.get('/footer', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/html; charset=UTF-8');

  res.send('<address>비트캠프 서초캠프@2022</address>'); // 백틱쓰면 속도느려짐
});

app.get('/exam04-3', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/html; charset=UTF-8');

  let arr = [
    { no: 1, title: '제목11111111111', writer: '홍길동', viewCnt: 19 },
    { no: 2, title: '제목222222222', writer: '임꺽정', viewCnt: 312 },
    { no: 3, title: '제목33333333333', writer: '유관순', viewCnt: 31 },
    { no: 4, title: '제목4444444444444', writer: '안중근', viewCnt: 100 },
    { no: 5, title: '제목5555555555555', writer: '윤봉길', viewCnt: 200 },
  ];

  // 배열 객체를 JSON 문자열로 변환하여 클라이언트에게 보낸다.
  // => serialization (직렬화)
  res.send(JSON.stringify(arr));
});

// 클라이언트 요청을 다른 서버에게 보낸다.
app.get('/proxy', (req, res) => {
  // console.log(req.query.url);  // 명령프롬프트에 나옴

  // const options = new Object();
  // options.uri = req.query.url;

  // const options = {};
  // options.uri = req.query.url;

  // const options = {
  //   uri: req.query.url
  // };
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/plain; charset=UTF-8');

  request.get({ uri: req.query.url }, (error, response, body) => {
    console.log('네이버에서 응답받았음!');
    // console.log(body);
    res.send(body);
  });

  // res.send('Hello, proxy!');
});

// http 기본포트번호: 80
// https 기본포트번호: 433

app.get('/proxy2', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'application/json; charset=UTF-8');

  let openApiUrl =
    'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?' +
    'serviceKey=O1UV%2F2uPlcdCj4cUaAuks17N6Nj0CTeU3GT0osfKD3n3iyWZPzwe9BeMBDnGWWVkH%2FG6nu%2FYHdtZTvK%2FPi3eGQ%3D%3D' +
    '&pageNo=1' +
    '&numOfRows=1000' +
    '&dataType=JSON' +
    '&base_date=' +
    req.query.base_date +
    '&base_time=0600' +
    '&nx=' +
    req.query.nx +
    '&ny=' +
    req.query.ny;

  request.get({ uri: openApiUrl }, (error, response, body) => {
    res.send(body);
  });

  // res.send('Hello, proxy!');
});

app.post('/login', (req, res) => {
  res.set('Access-Control-Allow-Origin', '*');
  res.set('Content-Type', 'text/plain; charset=UTF-8');

  var payload = `이메일: ${req.body.email}\n`;
  payload += `암호: ${req.body.password}\n`;
  
  res.send(payload);
});

// 웹서버 실행하기
app.listen(
  3000, // 포트 번호 지정
  () => {
    // 서버가 시작되었을 때 호출될 함수 = 리스너 = 이벤트 핸들러
    console.log(`${port}번 포트에서 서버 시작했음!`);
  }
);

// console.log('서버 시작했음!');

// node.js와 express 라이브러리
// app에 express 라이브러리를 장착하는 방법
// - app 퐅더에 라이브러리 다운로드

// npm(node package manager) : node.js용 라이브러리를 자동으로 다운로드

// nodejs application 구조

// 노드 app 디렉토리
// app.js : entry point (진입점, 프로그램 시작 파일)
// package.json  : nodejs app 설정파일
// node_modules : 다운로드받은 라이브러리 폴더들. npm install 명령을 실행할 때 자동생성됨
// - git에 백업하지 말라
// - 반드시 .gitignore파일에 등록할 것!

// npm install
// - 1) 작업 폴더에서 package.json 파일을 찾는다.
// - 2) package.json 파일에 등록된 라이브러리들을 모두 다운로드한다.
// - - node_modules 폴더가 없으면 생성한다.
// - - 라이브러리가 없으면 다운로드한다.
// - - - 설정된 조건에 따라 버전을 검사해 적절한 버전을 다운로드한다.

// npm install 라이브러리명
// 해당 이름을 가진 라이브러리만 다운로드한다.

// package.json만 있으면 이후 npm install만 쳐도 자동 다운로드됨

// npm 사용
// npm init : package.json 생성
// npm install 라이브러리 --save : package.json에 라이브러리 정보 등록하고 다운로드
// npm install : 이후엔 굳이 라이브러리명 안 쳐도 됨. git repo에서 프로젝트 가져온 후 한 번만 실행

// serialization과 deserialization

// serialization (encoding, 직렬화)
// 객체{name:"hong",age:20} -> JSON.stringify(객체) -> JSON 문자열"{"name":"hong","age":20}"
// 데이터덩어리를 알갱이로 만듦

// deserialization (decoding, 역직렬화)
// JSON 문자열 -> JSON.parse(JSON 문자열) -> 객체
