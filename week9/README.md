### Change (거스름 돈)
https://www.acmicpc.net/problem/5585

문제 요약
> 거스름 돈을 동전으로만 주어야 할 때, 동전의 갯수가 최소가 되도록 하라.
>> 1.  동전은 '500', '100', '50', '10', '5', '1' 원 단위.  
>> 2.  동전의 갯수는 무한히 많다.

풀이
~~~
동전의 갯수만 구하면 된다.
1. 가장 큰 동전으로 나눠 보고 나눠지는 나머지를 계속해서 동전으로 나눠 준다.
2. '1원' 단위 까지 있기 때문에 무조건 나누어 떨어진다.
~~~

유형  
* 그리디 알고리즘
* 기하 알고리즘
* 구현

---

### MinimumValues (최솟값) / ~~FAIL, 시간초과~~
https://www.acmicpc.net/problem/10868

* String[] to Integer[]
~~~
String[] strArr = {"123", "456", "789"};
~~~


_~ java 8_
~~~
for(int i=0; i<strArr.length; i++) {
    intArr[i] = Integer.parseInt(strArr[i]);
}
~~~


_java 8, stream_
~~~
Integer[] intArr = Arrays.asList(strArr).stream().mapToInt(Integer::parseInt).toArray();
~~~
