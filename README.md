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
    전혀 해결방안은 떠올리지 못한 문제... 다중for문에 취약함 gg
    가로로 즉 학생별로 비교를 하는 걸 생각해야한다.
    또한 같은 경우를 생각해서 최대치인 학생을 앞에서 부터 찾는데
    찾자마자 바로 break해준다. 그래야 맨번호가 나옴
    
### 2-12 멘토링
    n명의 학생과 m번의 시험을 보면서 멘토 멘티가 가능한 쌍을 구한다.
    멘토는 m번의 시험 전부에서 멘티보다 높은 등수여야한다.
    정말 많이 헤맨 문제.... 다중 for문으로 넘어갈수록 머리가 안돌아간다.gg
    n명의 학생이 있기 때문에 경우의 수는 n*n 쌍이 생긴다. n*n쌍을 만들고
    멘토가 될 학생과 멘티가 될 학생의 테스트 등수를 비교해서 
    멘토가 등수가 더 크면 false를 반환하여 멘토자격X
    되면 true를 반환한뒤 n*n쌍를 1로만든다.
</details>

<details>
<summary>03 Two pointers, Sliding window</summary>

### 3-1 두 배열 합치기
    오름차순으로 정렬된 두 배열을 오름차순으로 다시 하나의 배열로 합치기
    두개의 cnt 값을 설정하고 while문을 통해 루프하면서 add 해준다.
    for문 만 생각했었는데 while문 쓰는거 까먹지말자
### 3-2 공통원소 구하기
    두 집합에서 공통원소를 추출하여 오름차순으로 출력해라
    처음엔 이중 for문 으로 해봤는데 당연히 시간초과 나왔고
    cnt를 두개 설정해서 while문을 통해 도는 방식으로 했다.
    다만 두 집합을 Arrays.sort()로 미리 오름차순으로 정렬했다.
    1. 미리정렬 2. 2개의 포인터로 while문 순회 3.조건만족시 add
    이런식으로 생각해야되는것같다.
### 3-3 최대 매출
    n일중 연속된k일간의 최대 매출액 구하기
    이중 for문으로 생각했는데 시간초과 떠버림
    sliding window라는 기법 사용, 길이가k인 창문을 생각해서 계속 미는형식
    최초엔 k크기만큼의 창문 구하고 그담부턴 다음인덱스를 더하고 맨뒤 인덱스를 빼는형식으로 창문유지
    max+= (arr[i]-arr[i-k]); 이런식으로
    max가 answer변수보다 클때 초기화해주는 형식으로 구하자
### 3-4 연속 부분수열
    n개의 수로 이루어진 수열에서 연속된 부분수열의 합이m이 되는경우 구하기
    나는 2개의 포인터를 이용하여 원하는수보다 커지면 인덱스를+1 해서 진행했는데
    강사는 2개 포인터와 sliding window 를 섞어서 씀. 굳이?
### 3-5 연속된 자연수의 합
    양의 정수 n을 연속된 자연수의 합으로 가능한 가짓수 출력
    나는 n을 n개의 int[]로 만들어서(ex n=5  arr= 1 2 3 4 5)
    포인터를 2개써서 확인하는 방식으로 했다. (3-4 참고)
    강사는  ex) n=15 일때  2개로 나뉘어 지려면 1+2=3을 빼고 15-3=12
    12/2 =6  1+6 , 2+6 이렇게 나누어지면 가능하다 방식을 사용했다.
### 3-6 최대 길이 연속부분수열
    0과 1로 구성된 수열에서 최대 k번 만큼 0을 1로 변경가능할때 최대 1부분길이
    어떻게 풀어야할지 감을 못잡음 gg
    포인터 2개와 sliding window로 푸는데 rt가 움직이는데 1일때는 지나가고
    0일때는 cnt를 올린다. cnt가 k보다 커질때는 lt를 움직여서 0을 1로 바꾼걸
    다시 0으로 돌리면서 cnt를 줄여준다.rt-lt+1로 길이를 구하고 
    answer보다 커질때 answer를 초기화해준다.
</details>
<details>
<summary>04 HashMap, TreeSet</summary>

### 4-1 학급 회장
    후보중 가장 많이 선택된 후보를 출력
    배열로 받아서 그냥 갯수 세려했는데 해쉬를 써봐야될것같아서
    HashMap을 사용해서 풀어봄. containsKey로 있는거면 그냥 value값을 +1해주고
    없는거면 새로운 후보니까 put해줌, 최대값은 key를 순회하며 초기화하는 방식으로함
    강사는 map.put(x,getOrDefault(x,0)+1)을 사용해서 좀더 간편하게 map세팅을함
    size로 key갯수를 알수있다. remove로 제거가능. keySet으로 순회하는거 중요
### 4-2 아나그램
    anagram은 알파벳의 나열순서는 다르지만 그 구성이 일치할 경우를 의미한다.
    ex) apple  ppela
    입력받은 두 문자열이 아나그램인지 YES NO로 판별한다.(대소문자 구분)
    난 HashMap을 사용하여 풀었다. getOrDefault로 처음 문자열을 받고
    그 다음 문자열을 받을때 getOrDefault로 같은게 있으면 value값을 -1하는 방식
    그리고 value를 돌면서 0이 아닌값이 있으면 아나그램이 아니라고 생각한다.
### 4-3 매출액의 종류
    n일간의 매출기록중 연속된 k구간 매출액의 종류를 모두반환한다.
    처음엔 HashSet을 이용해서 중복제거를 하려고했는데... 이걸 이용하자니
    이중for문을 써야해서 시간 초과~
    원하는대로 HashMap의 size() 즉 key갯수와 sliding window를 결합해서 풀었다.
    여기서 생각해야되는점이 value값이 0이되면 해당 key를 remove해줘야 size()할때 포함이안된다는점
    형태 자체는 문제3-3의 변형느낌으로 품
    강사도 유사하게 푼듯? 다만 굳이 lt rt를 할이유가 있나 싶음
### 4-4 모든 아나그램 찾기
    S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하라
    s 와 t 로 map 2개 만들어서 비교하는 방식
    lt와 rt로 sliding window를 돌면서 확인
    isEqual메소드를 만들어서 두map이 같은지 확인했다.
    나는 isEqual를 따로 만들었는데 map.equals()로 간편하게 확인가능함...
### 4-5 k번쨰 큰 수
    1~100 사이 숫자 n장을 가지고있는데 미리 뽑아둠
    이 n장에서 3번 뽑아서(중복허용X) 더한 값 중 k번째로 큰값찾기, 없으면 -1 return
    삼중 for문으로 하면 시간초과 나려나? 했는데 n이 최대100이라 n^3의 상황에서도 1000ms안쪽
    삼중 for문으로 경우 다 구하고 HashSet에 집어넣어서 중복은 다 제거함
    ArrayList에 넣고 sort하는데 Collections.sort(answer,Collections.reverseOrder());
    내림차순으로 정렬함
    answer.size()가 k-1보다 클때 answer.get(k-1)로 값 리턴해주고 작으면 -1리턴
    강사는 TreeSet을 이용해서 set의 중복제거와 자동으로 정렬되게 했다.
    TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder));
    TreeSet에는 first 와 last 메소드가 있는데 각각 맨앞 맨뒤 값을 가져온다.
</details>
<details>
<summary>05 Stack,Queue</summary>

### 5-1 올바른 괄호
    괄호가 올바르게 입력되면YES 아니면 NO
    Stack을 이용해서 (가 입력되면 스택에 집어넣고 아니면 즉 )면pop하는데
    Stack 내부에 아무것도 없을때 pop하려하면 바로 false를 리턴한다.
    stack.pop()
    stack.add()
    stack.push()
    stack.empty()
### 5-2 괄호문자제거
    입력된 문자열중 소괄호 사이에 있는 모든 문자 제거 후 남은 문자 출력
    제대로 입력했다는 가정이 전제인듯?
    stack에 push하는데 만약 ')'면 peek로 스택맨위 검사하면서 (일때까지 다 pop해버리는 방식으로 품
    강사도 같은 방식인데 나는 peek로 확인하고 pop했는데 강사는 그냥 바로 pop해버림
    if(x==')') while(stack.pop()!='(') 이렇게 넘어감. 간편한듯?
    나는 향상된 for문으로 char가져왔는데 stack.get으로 하나씩 가져올수도있다.
### 5-3 크레인 인형뽑기(카카오)
    크레인으로 하나씩 뽑고 바구니에서 맨위에 있는것과 같으면 인형이 터지는 방식,터진인형갯수 return
    풀이에 앞서서 머리속 생각을 바로 옮기지않고 메모장에 정리한뒤 작성함.
    이렇게 하니까 어렵지 않게 풀이가능했음.
    이차원배열 arr[n][k]라 했을때 n을 돌면서 0이면 continue로 넘어가고 아니면 그값을
    pick으로 가져온뒤 가져온 pick값이 현재 스택의 peek와 같으면 pop한뒤 answer+2하고 pick다시0
    0보다 클때(즉 같지않을때) push해서 스택에 넣어주고pick0. 이때 스택에 암것도 없을때peek시 
    exception이 발생하기 때문에 empty()할때는 그냥 바로 push해주고pick0.
    알아둘점은 k에 move의 칸-1이 들어간다는 점
    강사도 비슷한 방식인듯 다만 push하고 pop하는 조건문세울때 좀더 깔끔한듯하다<- &&같은 조건을 나는 자꾸 잊는듯...
### 5-4 후위식 연산(postfix)
    후위연산자를 연산한 결과 출력,후위식연산? ex)3*(5+2)-9 -> 352+*9- 이런식으로 변경
    스택을 이용해서 숫자면 push 연산자가 나오면 pop() 두번해서 해당연산자에 맞는 연산하게 한뒤
    그 결과값을 다시 push하는 형식으로 구현했다.
    여기서 char로 숫자를 받아오는데 이걸 int로 바꾸는 방법은 다양하니 알아두자
    //stack.push(Integer.parseInt(String.valueOf(x)));
    //stack.push(Character.getNumericValue(x));
    //stack.push(x-48);
### 5-5 쇠막대기
    괄호로 이루어진 문자열에서 () 경우만 레이저이고 나머지는 (로시작해서 )로 끝나는 막대기
    레이저로 잘린 총 막대기의 조각수를 구해라
    처음에 보고 이게뭐지 싶었던 문제 고심끝에 생각한 방법은
    일단 ()인 경우를 L로 만든다음 순회하면서 L일때는 스택에 쌓인 size만큼 더해주고
    )일때는 막대기의 끝이니까 1를 더해준뒤 pop해준다.
    근데 ()를 L로 만드는걸 순회하면서 하려했더니 index에러가 났다.
    그래서 그냥 String의 replace 메소드를 사용해서 바꾸니 편하고 좋았다.
    String replaceStr = str.replace("()","L");
    강사와 생각하는건 비슷했는데 강사는 str를 i로 순회하면서 i-1값을 통해 막대기인지 레이저인지
    판단하는 방식을 사용했다.
### 5-6 공주 구하기
    n명의 사람중 k번째 때마다 사람을 뺀다. 마지막으로 남은 사람 return
    queue를 이용해서 구현했다. 큐의 size가 1이 되기전까지 돌면서
    cnt 값이k일때마다 remove하고 아니면 poll로 제거한뒤 다시 queue로 넣는다.
    Queue<Integer> queue =new LinkedList<>(); 자바에서 큐는 linkedlist로 생성해야한다.
    queue.offer() add와같은기능
    queue.add()
    queue.poll() 맨앞에걸뽑고(제거하고) 반환함
    queue.remove() 제거
    queue.size()
### 5-7 교육과정 설계
    처음에 꼭들어야하는 수업 순서가 있다(선수과목같은)
    다음으로 입력받는 자신이 짠 수업순서가 올바르면 YES 아니면 NO 반환
    큐를 만들고 짠수업에서 같은 값이 나오면 큐에서 제거하고 만약 큐가 비었다면 제대로 만든거로 판단
    강사는 contains로 일단 값이 존재하나 찾고 그담에 poll로 뽑은걸 비교해서 같지않으면 바로no리턴하는 방식
    이렇게하면 중간에 순서가 잘못된순간 바로 알수있어서 좋다. 내방식은 다 돌아봐야 알수있어서 별로인듯
</details>

