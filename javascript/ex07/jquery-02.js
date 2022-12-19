// 1. 태그 찾기
// 2. 태그 만들기
function jQuery(selector) {
  if (selector.startsWith('<')) {
    return document.createElement(selector.substring(1, selector.length - 1)); // 꺽쇠 안 문자열만 추출
  } else {
    return document.querySelectorAll(selector);
  }
}

var $ = jQuery;
// 다른 특수문자는 안되는데 $만 변수명으로 사용가능 (js만 그)
// 제이쿼리는 언어가 아니라 라이브러리 이름










