### CakeDelibery (케익 배달) / ~~FAIL, 메모리 초과~~
https://www.acmicpc.net/problem/2159

문제 요약
> 좌표 상에 빵집과 고객의 집이 표시 되어있다. 고객 집의 좌표가 순서대로 주어질 때, 순서대로 배달 할 때 가장 적은 이동거리를 구해라.
>> 1. 고객의 집 상하좌우 반경 '1' 안에서 케익 배달을 할 수 있다.
>> 2. 입력 받는 순서대로 고객의 집에 배달해야 한다.

풀이
~~~
객체를 만들어서 풀었는데 메모리 초과가 난다.
각 구간 마다의 최소값을 구해, 그 구간들의 합을 구하는 식으로 접근.

DP 로 어떻게 풀어야 할 지 고민 해 봐야 할 듯.
~~~

유형
* 다이나믹 프로그래밍(Dynamic Programming)

---