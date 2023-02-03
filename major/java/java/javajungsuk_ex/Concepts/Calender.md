## ✅ Date와 Calender간의 변환
Calender가 새로 추가되면서 Date는 대부분의 메서드가 'deprecated'되었으므로 잘 사용되지 않는다. 그럼에도 불구하고 여전히 Date를 필요로 하는 메서드들이 있기 때문에 Calender를 Date 또는 그 반대로 변환할 일이 생긴다. 그럴 때는 다음과 같이 하자.

```java
// 1. Calender를 Date로 변환
Calender cal = Calender.getInstance();

...

Date d = new Date(cal.getTimeMillis()); // Date(long date)

// 2. Date를 Calendar로 변환
Date d = new Date();

...

Calender cal = Calender.getInstance(); 
cal.setTime(d);
```

## ✅ 형식화 클래스
- DecimalFormat
```java
double number = "1234567.89";
DecimalFormat df = new DecimalFormat("#.#EO");
String result = df.format(number);
```

- SimpleDateFormat 
     - Date와 Calender를 사용해서 날짜 데이터를 원하는 형태로 다양하게 출력하는 것은 불편하다. 그러나 SimpleDateFormat을 이용하면 이러한 문제들이 간단히 해결된다.

```java
Date today = new Date();

SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

System.out.println(sdf1.format(today));
```

- ChoiceFormat
     - 특정 범위에 속하는 값을 문자열로 변환해준다.
```java
import java.text.ChoiceFormat;

class Test{
    public static void main(String[] args) {
        double[] limits = {60,70,80,90};
        String[] grades = {"D","C","B","A"};

        int[] scores = {100,95,88,70,52,60,70};

        ChoiceFormat form = new ChoiceFormat(limits,grades);

        for(int i=0;i<scores.length;i++){
            System.out.println(scores[i]+":"+form.format(scores[i]));
        }
    }
}
```

- MessageFormat
    - 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
```java
import java.text.MessageFormat;

class Test{
    public static void main(String[] args) {
        String msg = "Name : {0} \nTel : {1} \nAge : {2} \nBirthday : {3}";

        Object[] arguments = {
                "이자바", "02-123-1234", "27", "07-09"
        };

        String result = MessageFormat.format(msg,arguments);
        System.out.println(result);
    }
}
```