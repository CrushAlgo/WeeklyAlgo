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
### CompititionOrIntern (대회 or 인턴)
https://www.acmicpc.net/problem/2875

문제 요약
> 대회에 나가는 인원과 인턴을 나가는 인원을 적절하게 분배해야 한다.
>> 1. 대회는 팀을 이뤄 나가는데 여성 2명, 남성 1명이 한 팀이다.  
>> 2. 인턴을 나가는 인원 수가 주어지고, 총 인원에서 무조건 인턴 수 만큼은 빠져야 한다.  
>> 3. 한 줄에 '6 3 2' -> '여성 남성 인턴' 으로 주어진다.

풀이
~~~
팀을 이루는 수 만큼 씩 각 성별에서 빼주면서 팀의 갯수를 카운트 한다.
  
1. 팀을 이루기 위해서 여성 최소 2명 + 남성 최소 1명이 필요하다.
2. 남은 사람의 수는 인턴의 수 보다 작으면 안된다.
~~~

유형
* 그리디 알고리즘

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
