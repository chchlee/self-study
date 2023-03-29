
## JS 헷갈리는 내용 정리

- 배열을 사용할 때는 `[]` 브라켓을 사용한다.
- 객체를 저장할 때는 `{}` 중괄호를 사용한다.
- 그렇다면 객체 배열을 저장할 때는 `[{}, {}, {}, {}, {}, {}, {}, {}, {}]` 이런식으로 저장하면 된다.

```javascript
var allProducts = [{
    name: '농구공',
    description: '농구 황제 마이클 조던이 사용한 농구공입니다',
    price: 100000,
}, {
    name: '축구공',
    description: '축구 황제 메시가 사용한 축구공입니다',
    price: 50000
}, {
    name: '야구공',
    description: '박찬호가 던졌던 야구공입니다.',
    price: 75000
}]

function getExpensiveProducts(products){
 var newProducts = [];
 for(var i = 0; i < products.length ;i++){
  var product = products[i]; //i+1 번째의 객체를 product에 저장한다.
  var price = product.price; //product의 가격을 price에 저장한다.
  if(price >= 60000){ //가격이 60000원 이상이면
    newProducts.push(product) //newProducts에 해당 product를 넣는다.
  }
 }
 return newProducts; //리턴한다.
}

const expensiveProducts = getExpensiveProducts(allProducts);
console.log(expensiveProducts);
```

### 콜백함수

```javascript

function sayHello(){
    console.log('안녕ㅎ~');
}

function getHuman(callback) {
    callback();
}

getHuman(sayHello);
```

```javascript
//fetch 함수를 실행하면 Promise 객체를 반환해요.
var result = fetch('https://jsonplaceholder.typicode.com/todos/1')
//result에는 Promise 객체가 들어있습니다.

console.log('네트워크 통신이 끝날 떄 까지 기다리지 않고 바로 실행되요 1');
result.then(function(response){
 console.log('이 코드는 네트워크 통신이 끝나고 나서 실행되요.')
}).catch(function(error){
 console.log('이 코드는 에러가 났을 때 실행되요')
})
console.log('네트워크 통신이 끝날 떄 까지 기다리지 않고 바로 실행되요 2');
```

```javascript
fetch('URL주소')
.then(function(response){

})
.catch(err = > {

})
```
