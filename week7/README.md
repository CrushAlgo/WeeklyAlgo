## BinarySearchTree (이진 검색 트리) / ~~FAIL, runtime error~~
https://www.acmicpc.net/problem/5639

* 이진 트리  
: 트리의 모든 노드가 왼쪽 자식 노드와 오른쪽 자식 노드 만을 가지도 록 함으로써 트리의 차수가 2 이하가 되도록 제한한 트리
    * 특성  
    : 노드 수가 'N' 인 이진 트리의 간선 수는 'N-1' (단, 공백 이진 트리는 제외)  
    : 높이가 'h'인 이진 트리가 가질 수 있는 노드 수는 '(h+1) ~ (2^h+1 -1)'

    * 구현 방법  
        * 1차원 배열을 이용한 이진 트리 구현  
        : 높이가 'h'인 '포화 이진 트리'의 노드 번호를 배열의 인덱스로 사용.  
        : 트리의 높이에 따라, 노드의 갯수가 정해져 있기 때문에, 수식을 통해 파악 가능.
        : 편향 이진 트리일 경우, 메모리 낭비 심하고 트리 높이가 동적으로 변할 경우, 크기 변경이 어렵다.  
        
        * 연결 자료 구조  
        : 이진 트리의 모든 노드는 2개의 자식 노드를 갖으므로, 좌, 우 노드의 주소를 저장 할 수있는 노드를 만들면 된다.

문제 요약
> 트리를 전위 순회한 결과가 주어지면, 이를 후위 순회한 결과로 한 줄에 하나씩 출력해라.

풀이
~~~
연결 자료 구조로 노드 구현.
~~~

분류
* 트리
* 자료구조

***

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

`List<Object> streamList = Stream.of('obj1', 'obj2', ...).collect(Collectors.toList());`  
`ArrayList<Object> places = Stream.of('obj1', 'obj2', ...).collect(Collectors.toCollection(ArrayList::new));`
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


