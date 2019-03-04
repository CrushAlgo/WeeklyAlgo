## Calendar (2007)
https://www.acmicpc.net/problem/1924

문제 요약
> 2007년 달력에서 주어지는 '월', '일'을 가지고 '요일'을 알아내라.
>> 1. 1월 1일은 월요일.
>> 2. '1,3,5,7,8,10,12월'은  31일 까지, '4,6,9,11월'은 30일 '2월'은 28일 까지.

풀이
~~~
날짜(일)을 7로 나눈 나머지는 '0~6'까지의 주기를 띈다.
각 달에 해당하는 날짜를 더해주면서 합한 일수를 7로 나누면 요일이 나온다.
~~~

랩업

___List Initializing (java)___

`List<Object> fixList = Arrays.asList('obj1', 'obj2', ...);`
> 초기화를 해버려서 list 고정된다.

`List<Object> changeableList = new ArraysList<>(Arrays.asList('obj1', 'obj2', ...));`
> 변경 가능한 list.

`List<Object> list = new ArrayList<>();`
`Collections.addAll(list, 'obj1', 'obj2', ...);`
> Collections 사용

`List<String> streamList = Stream.of("Buenos Aires", "Córdoba", "La Plata").collect(Collectors.toList())`;

`ArrayList<String> places = Stream.of("Buenos Aires", "Córdoba", "La Plata").collect(Collectors.toCollection(ArrayList::new));`
> Stream 사용

분류
* 구현

***

## ClimbingStair (계단 오르기)

~~~
Comming soon
~~~

***

## StringRepeat (문자열 반복)
https://www.acmicpc.net/problem/2675

문제 요약
> 숫자와 문자열을 나란히 입력 받는다. 입력 받은 숫자 만큼, 문자열의 각 문자를 반복해서 출력한다.
>> ex, '3 ABC' -> 'AAABBBCCC'

풀이
~~~
그대로 구현하면 된다.
~~~

분류
* 구현

***


