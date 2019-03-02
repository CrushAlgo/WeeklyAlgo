## AC
https://www.acmicpc.net/problem/5430

~~~ 
Comming soon
~~~ 

***

## CountNumber (숫자의 개수)
https://www.acmicpc.net/problem/2577

문제 요약
> 숫자 N 이 주어지면 '0~9' 까지의 숫자가 각각 몇개씩 들어있는지 카운트 하는 문제

풀이
~~~
배열의 인덱스를 이용해서 숫자에 해당하는 인덱스의 수를 늘려주면서 체크
~~~

알고리즘 분류
* 구현

***

## SevenDwarf (일곱 난쟁이)
https://www.acmicpc.net/problem/2309

문제 요약
> 9명의 난쟁이 중에서 진짜 일곱 난쟁이를 찾아라
>> 일곱 난쟁이의 키의 합은 '100'.

풀이
~~~
모든 경우의 수를 다 따져 보아야한다.
1명을 고정하고 다른 1명을 돌려가면서 조건에 맞는지 확인한다.  
~~~

알고리즘 분류
* 브루트 포스

## SortInside (소트인사이드)
https://www.acmicpc.net/problem/1427

문제 요약
> 주어진 숫자의 각 요소를 내림차순으로 정렬하라

풀이
~~~
선택정렬
~~~

알고리즘 분류
* 정렬

***

## WordSorting (단어 정렬)
https://www.acmicpc.net/problem/1181

문제 요약
> N 개의 단어를 조건에 맞게 정렬
>> 1. 길이가 짧은 것 부터
>> 2. 길이가 같으면 사전 순으로

풀이
~~~
피지컬로 풀면, 길이가 같은 경우를 처리하기가 까다로워 진다.
순서대로 출력해 나가다가 길이가 같은 경우를 전부 모아서 다시 정렬을 해야한다.
~~~

~~~
- 'word' 와 'length' 를 필드로 하는 객체 정렬. (WordSorting)
- Collections 정렬 오버라이드. (WordSorting2)
~~~ 

알고리즘 분류
* 스택

참고 사이트

[Comparable vs Comparator](https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html)

***