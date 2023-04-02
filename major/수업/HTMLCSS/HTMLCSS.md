## 내가 모르는 내용 정리

- 대부분 사이트는 전체 레이아웃이 `위-아래`로 스크롤 하여 사용

- 레이아웃을 구성할 때 가장 많이 사용하는 요소(Elements)들이 기본적으로 블록(Block) 개념으로 표시(Display)되며 이느 (View)에 수직(위에서 아래로) 쌓이기 때문에 수직 구성은 상대적으로 쉽게 만들 수 있다.

- 그러나 수평 구조를 만드는 속성은 명확하지 않았기 때문에 `table`, `float`, `inline-block` 등의 도움을 받았다. 그러나 이러한 방법들은 차선책일 뿐이기 떄문에 `Flex`라는 명확한 속성들로 레이아웃을 쉽게 구성할 수 있게 되었다.

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-base.jpg">
</div>

- `Container` : `display`, `flex-flow`, `justify-content` 등의 속성을 가질 수 있다.
- `Items` : `orders`, `flex`, `align-self` 등의 속성을 가지고 있다.

### Flex Container

|속성|의미|
|--|--|
|display|Flex Container를 정의|
|flex-flow|`flex-direction`과 `flex-wrap`의 단축 속성|
|flex-direction|Flex Items의 주 축(main-axis)을 설정|
|flex-wrap|Flex Items의 여러 줄 묶음 설정|
|justify-content|주 축(main-axis)을 설정|
|align-content|교차 축(cross-axis)의 정렬 방법을 설정(2줄 이상)|
|align-content|교차 축(cross-axis)의 정렬 방법을 설정(2줄 이상)|
|align-items|교차 축(croxx-axis)에서 Items의 정렬 방법을 설정(1줄)|

### display

- display 속성으로 Flex Container를 정의한다.
- 보통 `display: block;` `display:inline-block;` 혹은 `display: none;`과 같이 사용
- 그러나 `Block`이나 `Inline`이 아닌 Flex `display: flex`, `display: inline-flex`로 정의

`flex` 는 Block요소와 같이 수직 쌓임
`inline-flex`는 수평 쌓임

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-display.jpg">
</div>

### flex-flow

- 이 속성은 단축 속성으로 Flex Items의 주 축(main-axis)을 설정하고 Items의 여러 줄 묶음(줄 바꿈)도 설정

```css
.flex-container{
  flex-flow: row-reverse wrap;
}
```

|값|의미|기본값|
|--|--|--|
|flex-direction|Items의 주 축을 설정|row|
|flex-wrap|Items의 여러 줄 묶음 설정|nowrap|

### flex-direction

- Items의 주 축(main-axis)을 설정

|값|의미|기본값|
|--|--|--|
|row|Items를 수평축으로 표시|row|
|row-reverse|Items를 row의 반대축으로 표시|
|column|Items를 수직축으로 표시|
|column-reverse|Items를 column의 반대 축으로 표시|

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-direction.jpg">
</div>

### 주 축(main-axis)과 교차 축(croxx-axis)

`row`는 Items를 수평축으로 표시하므로, 이 때는 주 축이 수평이며 교차 축은 수직이 된다.

`columns`은 Items를 수직축으로 표시하므로 주 축은 수직이며 교차 축은 수평이 된다.

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-direction-main-axis.jpg">
</div>

### 시작점(flex-start)과 끝점(flex-end)

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-direction-main-start.jpg">
</div>
<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-direction-cross-start.jpg">
</div>

### flex-wrap

- Items의 여러 줄 묶음(줄 바꿈)을 설정

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-wrap.jpg">
</div>

### justify-content

주 축(main-axis)의 정렬 방법을 설정

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-justify-content.jpg">
</div>

### align-content

- 교차 축(cross-axis)의 정렬 방법을 설정
- Items가 여러 줄이고 여백이 있을 경우에 사용

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-align-content.jpg">
</div>

### align-items

- Items가 한 줄일 경우 사용한다.
- 주의할 점은 Items가 `flex-wrap`을 통해 여러 줄일 경우에는 `align-content` 속성을 사용
- 따라서, `align-items`를 사용하려면 `align-content`  속성을 기본값(strech)으로 설정해야 함.

<div align="center">
<img src="https://heropy.blog/images/screenshot/css-flexible-box/flex-align-items.jpg">
</div>