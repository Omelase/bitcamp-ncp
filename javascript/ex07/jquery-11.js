// 1. 태그 찾기
// 2. 태그 만들기
// 3. append()
// 4. 리팩토링
// 5. html()
// 6. on()
// 7. appendTo()
// 8. Method Chaining
// 9. click()
// 10. 리팩토링
// 11. ajax()
function jQuery(selector) {
  return new ElementBox(selector);
} // 오리지널 객체가 들어있는 element 배열 리턴

function ElementBox(selector) {
  this.el = []; // 생성한 태그나 찾은 태그를 담는 배열

  if (selector.startsWith('<')) {
    this.el[0] = document.createElement(
      selector.substring(1, selector.length - 1)
    ); // 꺽쇠 안 문자열만 추출
  } else {
    let nodeList = document.querySelectorAll(selector);
    for (let e of nodeList) {
      this.el.push(e);
    }
  }
}

ElementBox.prototype.append = function (childBox) {
  // 자식 태그를 복제해서 각 부모 태그에 붙인다.
  for (let parent of this.el) {
    // 자식들이 들어있는 상자에서 자식을 한 개씩 꺼내 복제하여 각 부모의 자식으로 붙인다.
    for (let child of childBox.el) {
      parent.appendChild(child.cloneNode(true));
    }
  }
  // 자식 태그는 제거한다.
  for (let child of childBox.el) {
    // createElement로 생성한 태그는 부모가 없으므로 제외
    if (child.parentElement != null || child.parentElement != undefined) {
      child.parentElement.removeChild(child);
    }
  }

  return this;
};

ElementBox.prototype.appendTo = function (parentBox) {
  // 자식 태그를 복제해서 각 부모 태그에 붙인다.
  for (let parentTag of parentBox.el) {
    // parents가 배열이 아니므로 그냥 parents쓰면 오류!
    // 자식들이 들어있는 상자에서 자식을 한 개씩 꺼내 복제하여 각 부모의 자식으로 붙인다.
    for (let child of this.el) {
      parentTag.appendChild(child.cloneNode(true));
    }
  }
  // 자식 태그는 제거한다.
  for (let child of this.el) {
    // createElement로 생성한 태그는 부모가 없으므로 제외
    if (child.parentElement != null || child.parentElement != undefined) {
      child.parentElement.removeChild(child);
    }
  }

  return this; // 함수를 호출할 때 만든 주소가 this에 들어감
};

ElementBox.prototype.html = function (content) {
  for (let e of this.el) {
    e.innerHTML = content;
  }

  return this; // 함수가 받은 주소값을 리턴
};

ElementBox.prototype.on = function (eventName, listener) {
  for (let e of this.el) {
    e.addEventListener(eventName, listener);
  }

  return this; // 세 함수가 같은 객체에 대해 작업 수행
};

ElementBox.prototype.click = function (handler) {
  return this.on('click', handler);
  // for (let e of el) {
  //   e.addEventListener('click', handler);
  // }
};

jQuery.ajax = function (settings) {
  var xhr = new XMLHttpRequest();

  xhr.onreadystatechange = () => {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {
        let result;
        if (settings.dataType == 'json') {
          // json string ---> javascript object (deserialize)
          result = JSON.parse(xhr.responseText);
        } else {
          result = xhr.responseText;
        }
          settings.success(result);
      } else {
        settings.error();
      }
    }
  };

  xhr.open(settings.method, settings.url, settings.async);
  xhr.send();
};

// 생성자가 초기화시킨 객체 = 인스턴스
// 이전엔 객체 안에 함수를 담았음
// 지금은 객체 안에 배열만 있음
// 함수는 생성자 프로토타입에 저장
// 매번 객체를 만들 때마다 함수를 만들 필요없어짐
var $ = jQuery;
// 다른 특수문자는 안되는데 $만 변수명으로 사용가능 (js만 그럼)
// 제이쿼리는 언어가 아니라 라이브러리 이름

// $(selector)쓰면 html에서 주어진 선택자를 찾음
// $(selector).append(content); 쓰면 주어진 선택자 태그 안에 주어진 content를 추가
// $(selector).append($(selector2)); 쓰면 html에서 주어진 선택자2를 찾아 주어진 선택자 태그 안에 복제해 옮김. 기존 태그는 제거
