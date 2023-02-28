#### 사전지식
컴퓨터 구조 기본과 운영체제에 대한 공부를 해야할듯.
- CPU의 동작 원리
    - Cache Memory
    - Program Counter
    - Register
    - ALU
- OS의 동작 원리

## 디렉토리와 폴더
- 파일의 정보를 가지고 있는 파일이라 생각하자.
- 실제 데이터가 담겨 있는 것이 아닌 파일의 구조화된 속성 정보를 담아 하위 디렉토리 또는 파일과 연계해주는 특수한 형태의 파일
- 실제 데이터를 저장하는 것이 아니라 하위 디렉토리와 파일들의 포인터 정보

## 유닉스 디렉토리

## 유닉스 기본 명령어
- ls : list of directory, 디렉토리의 파일 목록 조회
- pwd : current path, 현재 디렉토리, 위치
- cd : change directory
- mkdir : make directory
- cp : copy
- mv : move
- rm : remove
- cat : catalogue 파일의 내용을 화면에 출력
- dd : 블록 단위로 파일을 복사하거나 파일 변환을 할 수 있는 명령어
- expr : bash 창에서 연산을 할 수 있게 함. `$ expr 1 + 5 (공백을 반드시 입력해야 한다.)
- launchctl : 시스템 전체나 사용자 단위로 적용되는 daemon/agent를 관리하는 launchd를 설정할 수 있는 인터페이스 명령어.
- echo : 유닉스 및 유닉스 계열 운영체제에서 지정한 문자열 또는 텍스트를 출력하는 명령어.
- df : 마운트된 파일 시스템의 크기와 용량을 보여주는 명령어로 전체 파일 시스템의 사용 현황을 한눈에 볼 수 있음.
- test : 파일 존재유무 / 타입 / 권한을 체크할 때 사용하는 명령어.
- csh : cshell
- wait4path : 주어진 명령어가 namespace에 도달할 때 까지 기다린다.
- unlink : 파일과 링크를 제거하기 위해 사용한다.
- sleep : 프로그램의 실행을 일시적으로 정지 할 수 있다. `$ sleep 시간`
- stty : 터미널 장치 인터페이스에 옵션을 설정할 때 사용한다.
- date : 시간과 날짜를 표시
- realpath : 물리적인 경로 반환
- ps : process status
- link : link file
- tcsh : C shell with file name completion and command line editing
- hostname : 현재 사용자 명 출력
- dash : 우분투 6.06버전에 사용되는 쉘
- sync : force completion of pending disk writes


#### 명령어의 기본 형식
`$<commnad> <option> <file or directory>`

#### ll 명령어 사용하기
```zsh
$ echo "alias ll='ls -lGaf'" >> ~/.bash_profile
$ source ~/.bash_profile
```
## 표준 스트림
- 유닉스 계열 운영체제에서 프로세스와 주변 장치 사이에 미리 연결된 통로
- 물리적으로 연결된 시스템 콘솔의 키보드와 모니터 연결을 추상화

## 파이프
- 유닉스 계열 운영체제에서 프로세스와 주변 장치 사이에 미리 연결된 통로
    - 한 프로세스가 쓰고, 다른 프로세스가 읽는 선입순철 형태의 Queue

파이프는 데이터가 한 프로세스에서 다른 프로세스로 전달되도록 한다.

## I/O 리다이렉션
- 유닉스 계열 운영체제에서 제공되는 표준 스트림 재지정
    - 명령은 리다이렉션을 통해 파일로부터 입력 받을 수 있고, 파일로 출력할 수 있음.

## 프로세스
- 실행 중에 있는 프로그램을 의미
- 프로그램을 실행하면, 프로그램이 메모리이 할당이 이루어지고 할당된 메모리 공간으로 바이너리 코드가 적재됨. 이 순간부터 프로세스 라 불림.

## 스레드(Thread)
