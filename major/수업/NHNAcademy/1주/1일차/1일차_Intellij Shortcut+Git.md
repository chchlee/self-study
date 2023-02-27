## 1. Intellij 단축키 익히기
1. Command + 1
    - Project 창 띄우기/감추기

2. Shift + Shift
    - 검색 창 띄우기

3. Ctrl + Space
    - 자동완성 안내

4. Option + ↑
    - 선택 확장

5. Command + D
    - Line 복제

6. Option + Shift + ↓
    - 라인 내리고 올리기(위치 바꾸기)

7. Command + -
    - 메서드, 클래스 등 요약하기

8. Command + Option + T / Command + Option + Del
    - 추천 키워드로 감싸고 풀기

9. Control + G
    - Multiple Selections

10. Control + Space
    - 자동완성

11. Command + Shift + Enter
    - 구문 자동완성

12. F6 + Enter
    - 해당 이름 자동 리팩터링

13. Command + Option + V
    - 변수 추출

14. Command + Option + M
    - 메서드 추출

15. Control + T
    - 리팩터링 메뉴

16. 마우스 우측 - 로컬 기록


17. 코드 서식 - Command + Option + L / 다시 지정 Command + Option + Shift + L

18. Command + P
메서드 시그니처 확인

19. Command + F12
파일 구조 확인

20. Command + B
메서드 선언 이동

21. Option + F7
선언 위치의 세부 정보

22. /**
Javadoc 생성

23. 래핑 후 Option + Enter
Javadoc 생성

## 2. 개발환경 세팅

### 2.1 CheckStyle-IDEA
- 작성된 코드가 코딩 컨벤션(Coding Convention)을 잘 따르고 있는 지 체크하는 도구
- 파일, 프로젝트 단위로 체크 가능
- commit 시 연동 가능

#### 참고

코딩 컨벤션 (Coding Convention)
- 어떤 프로그래밍 언어를 사용해서 코드를 작성할 때 추천되는 프로그래밍 스타일에 대한 가이드라인
- 사람이 코드를 읽기 좋도록 하고 유지보수를 용이하게 하기 위해 최대한 가이드를 따를 것을 권장함
- 들여쓰기, 주석(comment), 공백 갯수, 네이밍 컨벤션 등의 내용을 포괄함

<div>
<img src="https://user-images.githubusercontent.com/97272787/221495748-00ae1f20-5a15-46b1-a131-25f4e2d16162.png"></div>

<div>
<img src="https://user-images.githubusercontent.com/97272787/221496493-d344ddce-ae2f-4944-a416-544bd1b06bd9.png">
</div>

- Preferences -> Tools -> CheckStyle -> '+' 클릭 후 추가하고 싶은 Style 추가

- Missing a Javadoc comment ?
    - google_check.xml MissingJavadocType 을 default 처리해주면 이 경고는 발생하지 않는다.

- 특정 영역 CheckStyle default

```java
// CHECKSTYLE:OFF

/* 소스 코드 */
//CHECKSTYLE:ON
```

#### 참고
- 적용이 안될 경우
    - Style 파일에
```html
    <module name="SuppressCommentFilter"/>
    코드 입력 하면 CHECKSTYLE이 적용된다.
```

#### 저장시 자동으로 코드 포매팅 적용
- 파일 저장시 지정되어 있는 코딩 컨벤션에 맞게 수정해 줌.
- Preferences -> Tools -> Actions on Save -> Reformat code 클릭

<div>
<img src="https://user-images.githubusercontent.com/97272787/221496814-6957c9d4-726c-4d8a-91eb-07342aaedc59.png">
</div>

### 2.2 SonarLint
- 코드 작성시 품질 문제를 정적으로 탐지하고 해결하는데 도움을 주는 플러그인
<div>
<img src="https://user-images.githubusercontent.com/97272787/221497482-08f8c334-17f7-4c94-9e05-afdad40c018d.png">
</div>

<div>
<img src="https://user-images.githubusercontent.com/97272787/221497762-7db80ca9-fca5-4fc1-b571-7de1b9ac3d12.png">
</div>

- Preferences -> Tools - SonarLint -> Rule -> Java
- 특정 규칙에 대해 적용 가능