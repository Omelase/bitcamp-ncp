// express라이브러리 로딩하기
const express = require('express');
const port = 3000; // 웹서버 포트 번호

// express()를 호출하여 웹서버를 준비한다.
const app = express();

// 클라이언트 요청에 대해 호출될 메서드를 등록
app.get(                            // GET 요청이 들어왔을 때 호출될 메서드 지정
  '/exam01-1',                      // 요청 URL
  (req, res) => {                   // 요청 핸들러: 요청이 들어왔을 때 호출되는 메서드
    res.set('Access-Control-Allow-Origin', '*');  // CORS 문제 해결
    res.set('Content-Type', 'text/plain; charset=UTF-8');
    res.send('Hello!');
  } 
); 

// http 기본포트번호: 80
// https 기본포트번호: 433


// 웹서버 실행하기
app.listen(
  3000,                            // 포트 번호 지정
  () => {                          // 서버가 시작되었을 때 호출될 함수 = 리스너 = 이벤트 핸들러
    console.log(`${port}번 포트에서 서버 시작했음!`);
  } 
);

console.log('서버 시작했음!');

// node.js와 express 라이브러리
// app에 express 라이브러리를 장착하는 방법
// - app 퐅더에 라이브러리 다운로드

// npm(node package manager) : node.js용 라이브러리를 자동으로 다운로드

// nodejs application 구조

// 노드 app 디렉토리
// app.js : entry point (진업점, 프로그램 시작 파일)
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
// npm install : 이후엔 굳이 라이브러리명 안 쳐도 됨. git repo에서 프로젝트 가져온 후 한 번만 실
