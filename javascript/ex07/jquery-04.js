// 1. 태그 찾기
// 2. 태그 만들기
// 3. append()
// 4. 리팩토링
function jQuery(selector) {
  let el = []; // 생성한 태그나 찾은 태그를 담는 배열
  if (selector.startsWith('<')) {
    el[0] = document.createElement(selector.substring(1, selector.length - 1)); // 꺽쇠 안 문자열만 추출
  } else {
    let nodeList = document.querySelectorAll(selector); // 노드리스트
    // console.log(nodeList);
    for (let e of nodeList) {
      el.push(e); // el 배열에 노드리스트 안 값들을 하나씩 넣는다.
    }
  }
  
  el.append = function(childBox) {
    // 자식 태그를 복제해서 각 부모 태그에 붙인다.
    for (let parent of el) { // dd
      // 자식들이 들어있는 상자에서 자식을 한 개씩 꺼내 복제하여 각 부모의 자식으로 붙인다.
      for (let child of childBox) { // p1
        // console.log(child);
        parent.appendChild(child.cloneNode(true)); // dd에 p1복제본을 자식으로 추가
      }
    }
    // 자식 태그는 제거한다.
    for (let child of childBox) { // p1, childBox는 함수 안에서 불변함. 복제된 p1은 해당되지 않고 원본만 해당
      // createElement로 생성한 태그는 부모가 없으므로 제외
      if (child.parentElement != null || child.parentElement != undefined) {
        child.parentElement.removeChild(child); // body가 null이 아니거나 undefined가 아니면 body에서 p1을 제거
      }
    }
  };

  return el; 
} // 오리지널 객체가 들어있는 element 배열 리턴

var $ = jQuery;
// 다른 특수문자는 안되는데 $만 변수명으로 사용가능 (js만 그)
// 제이쿼리는 언어가 아니라 라이브러리 이름

// $(selector)쓰면 html에서 주어진 선택자를 찾음
// $(selector).append(content); 쓰면 주어진 선택자 태그 안에 주어진 content를 추가
// $(selector).append($(selector2)); 쓰면 html에서 주어진 선택자2를 찾아 주어진 선택자 태그 안에 복제해 옮김. 기존 태그는 제거









