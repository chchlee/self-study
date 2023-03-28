
## 정규표현식 검사

- `java.util.regex.Pattern` 을 사용해서 `Pattern.matcher()` 함수를 사용한다.

1. `Pattern.compile(String 문자열)` 문자열을 받아서 Pattern 객체를 반환한다.

2. `Matcher Pattern.matcher(검열할 문자열)` 정규표현식 패턴에 검열할 문자열을 넣은 Matcher 객체를 반환한다.

3. `boolean Matcher.matches` Matcher 객체에 있는 패턴과 검열할 문자열의 검열설공 여부를 반환한다.


<div align="center">
    <table style= "text-align:center">
        <tr>
            <td>표현식</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>^</td>
            <td>문자열의 시작</td>
        </tr>
        <tr>
            <td>$</td>
            <td>문자열의 종료</td>
        </tr>
        <tr>
            <td>.</td>
            <td>임의의 한 문자( '\'를 제외한 임의의 한 문자 )</td>
        </tr>
        <tr>
            <td>*</td>
            <td>앞 문자가 없을 수도 무한정 많을수도 있음.</td>
        </tr>
        <tr>
            <td>+</td>
            <td>앞 문자가 하나 이상</td>
        </tr>
        <tr>
            <td>?</td>
            <td>앞 문자가 없거나 하나 있음</td>
        </tr>
        <tr>
            <td>[]</td>
            <td>문자의 집합이나 범위를 나타내며 두 문자 사이는 '-' 기호로 범위를 나타낸다. <br /> []내에서 ^가 선행존재하면 not을 나타낸다.</td>
        </tr>
        <tr>
            <td>{}</td>
            <td>횟수 또는 범위를 나타낸다.</td>
        </tr>
        <tr>
            <td>()</td>
            <td>소괄호 안의 문자를 하나의 문자로 인식</td>
        </tr>
        <tr>
            <td>|</td>
            <td>패턴 안에서 or 연산을 수행할 때 사용</td>
        </tr>
        <tr>
            <td>\s</td>
            <td>공백 문자</td>
        </tr>
        <tr>
            <td>\S</td>
            <td>공백 문자가 아닌 나머지 문자</td>
        </tr>
        <tr>
            <td>\w</td>
            <td>알파벳이나 숫자</td>
        </tr>
        <tr>
            <td>\W</td>
            <td>알파벳이나 숫자가 아닌 나머지 문자</td>
        </tr>
        <tr>
            <td>\d</td>
            <td>숫자 [0-9]와 동일</td>
        </tr>
        <tr>
            <td>\D</td>
            <td>숫자를 제외한 모든 문자.</td>
        </tr>
        <tr>
            <td>\</td>
            <td>정규표현식 역슬래시(\)는 확장 문자 <br /> 역슬래시 다음에 일반 문자가 오면 특수문자로 취급하고 역슬래시 다음에 특수문자가 오면 그 문자 자체를 의미</td>
        </tr>
        <tr>
            <td>(?i)</td>
            <td>앞 부분에 (?i) 라는 옵션을 넣어주면 대소문자를 구분하지 않음.</td>
        </tr>
    </table>
</div>

```java

class RegexExample {
    public static void main(String[] args)  {

        String pattern = "^[0-9]*$"; //숫자만
        String val = "123456789"; //대상문자열
        boolean p = Pattern.matches(pattern, val);
        // 위식은 아래식과 정확히 같다.//
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher k = pattern1.matcher(val);
        boolean a = k.matches();
        // 위식은 아래식과 정확히 같다.//
        boolean s = Pattern.compile(pattern).matcher(val).matches();

        boolean regex = Pattern.matches(pattern, val);
        System.out.println(regex);
    }
}
```