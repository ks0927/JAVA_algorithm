# JAVA_algorithm
자바 알고리즘 공부   
<https://inf.run/f12S>
<details>
<summary>01 String</summary>

### 1-1 문자 찾기
    String으로 받은 내용 중 char로 받은 단어를 포함한 갯수 찾기
    charAt()으로 String의 특정 index 접근 ex)charAt(0)로 0번째 문자를 char로 가져온다
    향상된 for문에서는 배열이 들어가야하는데 그때 String.toCharArray()로 간편하게 배열생성가능
    str = str.toUpperCase(); 로 String을 대문자화
    c = Character.toUpperCase(c); 로 char를 대문자화
### 1-2 대소문자 변환
    String으로 받은 내용 중 대문자일경우 소문자로 소문자일 경우 대문자로 변환
    빈 String에 +=로 char를 추가한다는 생각을 떠올려보자
    Character.isLowerCase(x)로 소문자를 isUpperCase로 대문자를 판별할수있다.
    다른 방법으론 아스키 코드를 이용하는방법인데
    대문자의 아스키 코드범위는 65~90
    소문자의 아스키 코드범위는 97~122
    대문자와 소문자의 차이가 32나는걸 이용하는 방법도 존재한다.
### 1-3 문장 속 단어
    한 문장 속 가장 긴 단어 출력, 각 단어는 공백으로 구분된다.
    가장 긴 단어가 여러개일 경우 가장 앞쪽에 위치한 단어를 답으로 한다.
    방법 1
    현재 가장 긴 단어의 길이를 갱신하는 방식
    String[] s = str.split(" "); 로 split한 string들을 for문으로 돌면서 해결
    방법 2
    while문과 indexOf, substring를 이용하여 index기반으로 자르고 비교하는 방식
    while((pos= str.indexOf(' '))!= -1)
    String tmp = str.substring(0,pos); 
### 1-4 단어 뒤집기
    n개의 단어를 입력받고 뒤집어서 출력
    StringBuilder의 reverse를 이용하면 쉽게 가능하지만
    while(lt <rt) 를 이용하여 하면 제약이 걸린 상황에서도 문제없음
### 1-5 특정 문자 뒤집기
    알파벳과 특수문자로 구성된 문자열에서 알파벳만 뒤집고 특수문자는 자리유지
    1-4 문제와 비슷하다
    다만 Character.isAlphabetic()를 사용하여 알파벳 유무를 판별하고 
    lt가 특수문자일때, rt가 특수문자일때, 둘다 알파벳일때 3경우로 나누는걸 생각한다면 구현은 쉽다.
### 1-6 중복문자 제거
    문자열에서 먼저나온 문자의 중복이 나올경우 제거하는 문제
    (str.indexOf(str.charAt(i))==i 를 이용하는게 가장 핵심
    현 index와 현 알파벳이 최초로 발견된 index가 같을때 answer에 추가하는 방식
### 1-7 회문 문자열
    거꾸로 읽어도 같은 문자열을 회문 문자열이라 명하고 대소문자를 구분하지않는다.
    첫번째로 맨 앞과 맨뒤를 length/2번 비교하는 방식으로 확인가능하고
    두번째로 StringBuilder의 reverse로 문자열을 뒤집은뒤
    str.equalsIgnoreCase로 대소문자 구분없이 두 문자열을 비교하여 판별하는 방식이 있다.
### 1-8 유효한 팰린드롬
    회문을 팰린드롬이라고 한다. 알파벳만 가지고 검사하며 대소문자 구분하지않습니다.
    Character.isAlphabetic()로 알파벳 유무 판별해서 알파벳 뽑아낸뒤 1-7방식을 쓰려했는데
    강의에선 replaceAll 매소드에 정규표현식을 사용해서 알파벳을 제외한 문자들을 제거했다.
    str = str.toUpperCase().replaceAll("[^A-Z]","");
</details>
