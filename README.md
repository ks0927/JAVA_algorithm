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
### 1-9 숫자만 추출
    문자열 속에서 숫자만 추출하여 순서대로 자연수 생성
    x>=48 && x<= 57 일때 a = a*10 +(x-48) 로 아스키 번호 활용한 방법1
    Character.isDigit(x)으로 숫자판별해서 누적하는 방법2
    Integer.parseInt로 string을 int로 변환해주자
    나는 str = str.replaceAll("[^0-9]",""); replaceAll의 정규식을 활용했음
### 1-10 가장 짧은 문자거리
    문자열과 문자가 주어졌을때 해당 문자열에서 문자와 주어진 문자사이의 최소거리 출력
    ex)student t  = 1012210
    생각하기 어려운 문제 같다...
    처음 거리를 주어진 길이인 100보다 크게 둔다 ex)1000
    정답 문자열인 answer를 만들고 입력 문자열을 왼쪽부터 끝까지 돌면서
    같은 문자일경우 0을 answer에 집어넣는다.
    계속돌면서 같은 문자가 아닐경우 +1를 해서 집어 넣는다.
    이렇게 한바퀴를 돈뒤에 오른쪽부터 왼쪽으로 문자열을 도는데
    거리를 다시 1000으로 시작하고 전과 같은 방식으로 하되
    answer 문자열에 집어 넣을때 answer의 숫자값과 현재 계산한 값을 서로 비교한다.
    비교해서 더 작은 값으로 answer를 교체 한다.
    Math.min으로 작은값 리턴 가능하다.
### 1-11 문자열 압축
    문자열을 입력받고 연속으로 나오면 뒤에 숫자로 표기해준다. 단 한번일땐 생략
    ex) KKHSSSSSSSE -> K2HS7E
    answer=""로 시작해서 +로 채워나가는 방법으로 시작할건데
    이 알고리즘의 핵심은 int cnt=1를 정의해두고 현 문자와 다음문자가 같을때 cnt를 ++한뒤
    만약 다르면 현문자를 answer에 집어넣고(+=) cnt가1보다 크면 cnt도 집어넣는다(+=)
    여기서 주의해야할 점은 다음문자를 비교해야되는데 마지막 문자같은 경우는 다음문자가없어서
    에러가 나기때문에 미리 문자열을 받을때 빈공간을 하나 더 넣어주자
### 1-12 암호
    문자열이 #과 *로 이루어져서 입력 되는데 7의 배수만큼 입력된다
    #은 이진수의 1이고 *은 0이며 바꿔진 이진수를 7자리씩 십진수화한걸
    아스키코드로 변환하면 대문자 알파벳으로 변환되는 암호입니다.
    또 여기서도 answer=""로 시작해서 +로 채워나가는 방법으로 시작할건데
    substring을 이용해서 7개씩 자르는거 기억하자(substring(0,7))
    그리고 replace로 #은 1로 *은 0으로 바꾸고
    Integer.parseInt(tmp,2)를 사용해서 이진수를 십진수로 바꿀수있다
    바꿔진 십진수를 char로 casting해줘서 대문자 알파벳으로 표시한다.
    substring(7)로 계속 잘라주는것도 잊지말자
</details>
<details>
<summary>02 Array</summary>

### 2-1 큰 수 출력하기
    n개의 정수를 입력받아 바로 앞수 보다 큰수만 출력, 단 첫번째는 무조건출력
    ArrayList<Integer>에 정수들을 add해서 담는데 앞 인덱스와 비교해서 클때만 담자
### 2-2 보이는 학생
    n명의 학생이 일렬로 앉아있을때 선생님이 볼수있는 학생의 수 구하기
    단 학생들은 앞 학생들보다 클때 보이고, 작거나 같으면 보이지않는다.
    이중 for문으로 앞으로 다시가서 검사하려했더니 시간초과가 뜸...
    결국 max 변수를 만들어서 계속 초기화 해주는 방식으로 구현
### 2-3 가위 바위 보
    A와 B 둘이서 가위바위보를 하는데 1:가위, 2:바위, 3:보
    이긴 사람을 출력하고 비기면 D를 출력
    A과 이겼을때 비겼을때 그외(졌을때 = B가 이긴것)
    세가지 상황으로 분류하여 구현했다.
    강사는 return값이 string이어서 향상된 for을 쓸때 toCharArray()과정이 필요했다.
### 2-4 피보나치 수열
    입력받은 정수만큼 피보나치 수열을 출력한다.
    재귀방식도 생각해봤지만 빅오가 너무 커질거같아서 반복으로 풀이를 생각함
    입력받은 정수크기의 배열을 선언하고 1 1 을 미리 넣어둔뒤
    for문을 돌면서 뒤뒤에꺼 와 뒤에 꺼를 더해서 배열에 넣는 방식으로 풀이했다.
    다만 배열을 사용하지 않고 하려면 a=1 b=1 c 3개의 정수를 미리 선언하고
    c= a+b 를 한뒤 그다음엔 a가 b가되고 b가 c가 되기때문에 a=b, b=c를 해줘야한다.
### 2-5 소수(에라토스테네스 체)
    입력된 자연수까지의 소수의 개수 출력
    그냥 소수 구할때는 자기 자신하고 1 빼고 나눠지면 아니다로 판정하려했으나
    시간복잡도때문에 에라토스테네스의 체 사용
    2부터시작해서 입력받은 n까지 돌면서
    0일때 체크하고 그 배수들을 다 1로 초기화해서 pass
### 2-6 뒤집은 소수
    n개의 자연수를 입력받고, 각 자연수를 뒤집은뒤 소수면 출력
    강사는 숫자를 10으로 나누어서 일의 자리수부터 하나씩 뽑아내고
    뽑아낸 숫자를res=0, res = res * 10 + t 이런식으로 해서 숫자를 뒤집었다
    나는 string으로 받아서 이전에 lt와 rt로 뒤집고 int로 변환함
    소수판별 매서드를 하나따로 만들고 1과 자신을 제외한 숫자로 나뉘면 소수가 아니라고판별함
### 2-7 점수계산
    맞은 문제를 1점 틀린문제를 0점으로 하는데 연속으로 맞출시
    가산점을 부여하여 +1을 추가한다.
    tmp 변수를 사용하여 1일때 +1추가하고 0일때는 0으로 초기화 해주는게 포인트
### 2-8 등수구하기
    n명의 학생을 등수 매긴다. 단, 같은 점수는 같은등수로 동일처리
    cnt를 1로 두고 들어온 인덱스의 값을 전체와 비교해서
    다른 인덱스 값보다 작으면++를 해준다.
### 2-9 격자판 최대합
    입력된 n의 n*n크기의 격자판의 각행, 각열, 두 대각선의 합 중 가장큰값 출력
    나는 이차원 배열로 받은뒤 일일이 다 구해보고 가장큰값 찾았음
    강사도 비슷한 방식이지만 코드가 간결함, 다구하고 Math.max로 미리 정리해놓은등
### 2-10 봉우리
    격자판에서 가장자리는 0으로 초기화하고 자신의 상하좌우 숫자보다 큰곳은 봉우리다.
    같으면 봉우리 X
    이차원배열의 사방탐색을 사용했다. 미리 direction이라는 이차원배열에 사방이동을 저장해두고
    불러와서 쓰는 형식으로 구현했다.
    근데 항상 느끼지만 x y 이동이 [y][x] 이동이여서 맨날 헷갈린다.
    나는 indexOutOfRange가 나올까봐 미리 0으로 초기화된 배열을 만들었는데
    강사는 nx>=0 && nx<n 이런식으로 범위를 지정해둬서 회피했다.
### 2-11 임시반장 정하기
    1~5학년동안 n명의 학생들 중 같은반이었던 학생이 많은 학생이 반장이된다
    단 같은 경우엔 번호가 작은 학생이 반장이된다.
    세로로 학년별로 비교를 하려했으나 실패했다. 
    전혀 해결방안은 떠올리지 못한 문제... 다중for문에 취약함
    가로로 즉 학생별로 비교를 하는 걸 생각해야한다.
    또한 같은 경우를 생각해서 최대치인 학생을 앞에서 부터 찾는데
    찾자마자 바로 break해준다. 그래야 맨번호가 나옴
    
### 2-12 멘토링
    n명의 학생과 m번의 시험을 보면서 멘토 멘티가 가능한 쌍을 구한다.
    멘토는 m번의 시험 전부에서 멘티보다 높은 등수여야한다.
    정말 많이 헤맨 문제.... 다중 for문으로 넘어갈수록 머리가 안돌아간다.
    n명의 학생이 있기 때문에 경우의 수는 n*n 쌍이 생긴다. n*n쌍을 만들고
    멘토가 될 학생과 멘티가 될 학생의 테스트 등수를 비교해서 
    멘토가 등수가 더 크면 false를 반환하여 멘토자격X
    되면 true를 반환한뒤 n*n쌍를 1로만든다.
</details>
