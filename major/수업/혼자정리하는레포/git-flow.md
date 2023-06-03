
## Git Flow란?

- Git Flow 전략은 소스코드를 관리하고 출시하기 위한 강력한 브랜치 관리 전략 중 하나이다.

- Git Flow에 사용되는 브랜치의 종류는 5가지 이며 크게 항상 유지되는 메인 브랜치(master(main), develop)와 일정 기간 유지되는 보조 브랜치(feature, release, hotfix)로 나뉜다.

    - master(main)  : 제품으로 출시될 수 있는 브랜치
    - develop : 다음 출시 버전을 개발하는 브랜치
    - feature : 기능을 개발하는 브랜치
    - release : 이전 출시 버전을 준비하는 브랜치
    - hotfix : 출시 버전에서 발생한 버그를 수정하는 브랜치

<div align="center">
<h2>Git Flow의 브랜치 전략</h2>
<img src="https://user-images.githubusercontent.com/97272787/226171772-afdec662-6c50-48e7-8a14-c9baaa0c4dca.png">
</div>

## Git - Flow 설치하기

### 1. git-flow-avh 설치

1. 우선 터미널에 들어가 git-flow-avh를 설치한다.

```zsh
$ brew search git-flow-avh
$ brew install git-flow-avh
```

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226173005-235e09f6-7ee4-47e8-a58a-1a27b7289aa0.png">
</div>

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226173094-fb68972d-933a-40e4-a8ea-d46c626a579c.png">
</div>

</br>

### 2. IntelliJ 플러그인 설치

1. Settings - Plugin - `Git Flow Integration Plus` 설치


<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226173279-e4266b65-a3b0-44d8-aab1-8b717b55c176.png">
</div>

2. 레포지토리를 clone을 한다.
상단탭 - VCS - Get from Version Control - 레포지토리 url 입력 - clone

<div align="center">
<img src= "https://user-images.githubusercontent.com/97272787/226173486-7b87bac0-4ddb-4abc-9d74-c6adb13d0a9f.png">
</div>

<div align="center">
<img src= "https://user-images.githubusercontent.com/97272787/226173499-99dfff2e-c3cf-415e-9e01-fc5f0aa71ecd.png">
</div>

<div align="center">
<img src= "https://user-images.githubusercontent.com/97272787/226173531-11a1c346-1f30-40ea-9692-e2b6b94fd331.png">
</div>

#### 다른 방법 - git clone 명령어를 이용

```zsh
$ git clone url
```

명령어 실행 후 IntelliJ에서 해당 레포지토리를 프로젝트 디렉토리를 열면 IntelliJ에서의 과정과 똑같다.

### 3. 테스트

클론한 레포지토리를 로컬 상태에서 IntelliJ로 잘 클론했다면 하단 탭에서 `No Gitflow`를 클릭하고 `Gitflow Actions`에서 Init Repo를 클릭한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226174121-1e8ca838-79ef-4a07-9b6f-aac752fc667c.png">
</div>

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226174158-71e2a230-5b67-4dcc-98ad-e7f94830cf17.png">
</div>

정상적으로 진행되었다면 `Options for gitflow init`에서 `Use non-default configuration`을 클릭하고 `Branch name for "next release" development`에 develop을 입력하고 `OK`를 클릭해서 git flow를 생성한다.

#### Feature 브랜치 시작

1. 하단 `Gitflow` 를 클릭하고 `Start Feature`를 클릭한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226175177-57bd7216-56ca-4bb4-965f-69822aa2d96d.png">
</div>

2. 생성할 다른 브랜치 명을 입력하고 `Branch from...`에서 `develop(default)`가 되어있는 걸 확인하고 `OK`를 누른다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226175220-15f24e6f-7571-4736-bc8e-2aa8fa1105d7.png">
</div>

3. 하단 바에서 `Git` 버튼을 클릭하고 브랜치가 잘 생성되었는지 확인한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226175280-c4851263-6042-42f8-85ed-62038d4efce9.png">
</div>

4. 생성된 레포지토리에 테스트를 해보기 위해 하단 브랜치에 생성한 브랜치로 checkout이 잘 되어 있는지 확인하고, staging 상태로 변경 후 해당 브랜치에 임의의 파일을 생성해 테스트 커밋을 한다.

- IntelliJ에선 Git staging 이 설정되어 있지 않아 `Settings - Version Control - Git에서 Enable`상태로 로 변경 해야한다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226176080-ed95e620-c896-4019-bee7-468888d32d9f.png">
</div>

- stage 상태로 변경

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226176155-2c1034d3-e42c-423d-8746-b71f7cd86c6d.png">
</div>


- 커밋 확인

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226176198-2fb50193-4bd7-4700-9dcd-4c069f0e9d0c.png">
</div>

다시 develop 브랜치로 checkout 하고, 새로운 기능을 위한 `add-file2` 브랜치를 Start feature를 이용해 추가한다. test2 라는 임의의 파일을 생성하고 커밋을 진행해 준 뒤 Gitflow의 'Finish Feature' 라는기능을 마무리 했다는 항목을 선택해 준다.

기능을 마무리 한 결과로는 `feature/add-file2`의 브랜치가 삭제되고, develop 브랜치에 병합이 되는 것을 확인할 수 있다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226176871-1217f297-8b0a-4149-a568-beb22f6ad717.png">
</div>

<div>
<img src="https://user-images.githubusercontent.com/97272787/226176650-ddd8c0c5-b490-4191-a2cf-ad885881fc2d.png">
</div>

<div>
<img src="https://user-images.githubusercontent.com/97272787/226176999-8f435182-18c2-4383-aa74-232bf3b973dd.png">
</div>

마찬가지로 `feature/add-file1` 브랜치도 `Finish Feature`로 해당 브랜치를 삭제함과 동시에 `develop` 브랜치로 merge 해준다.

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226177112-0b424bca-3fa1-44b1-8e90-0c1f4ae433cd.png">
</div>

잘 처리된 것을 볼 수 있다.

다음으로 처리해야하는 것은 `release`이다. `release`는 주로 버전을 입력해준다. 해당 브랜치에서 테스트를 진행해보고 테스트가 정상적으로 끝났으면 그걸 main 브랜치에도 merge 해준다. 이를 위해 `Finish Release` 항목을 선택해준다.

<div align="center">
<img src=https://user-images.githubusercontent.com/97272787/226177231-e458a2ca-d686-48e2-b38c-1dabb7851de2.png">
</div>

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226177253-d5d2543f-2760-455e-8b86-f675fb2a2f48.png">
</div>

`Finish Release` 에서 tag message 는 배포할 때 브랜치 이름 대신 사용할 수 있다.

### 4. PR(Pull Request)

테스트를 한 환경에서 develop 브랜치를 push 해준다. `feature/add-file3`라는 이름의 브랜치를 새로 생성해준다. 위와 동일하게 새로운 파일을 생성해주고 커밋을 해준다.

1. develop push

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226177449-70a432f2-5724-4b93-8e4e-5f2a746f7fbc.png">
</div>


<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226177476-42ac0115-51c3-4986-adf6-b0dbd90a4c73.png">
</div>

2. `feature/add-file3` 브랜치 생성, 임의의 파일 생성 후 commit & push

3. `feature/add-file` 브랜치와 develop 브랜치를 merge 하려고 할 때, Github의 Pull Request 기능을 이용한다.

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226178018-7976d103-6d5b-4e18-83cd-f8da828b9b2e.png">
</div>

4. `Pull requests` 항목에 들어가 `New pull request`를 선택한다.

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226178078-dd56bc20-850e-4c1e-ab6a-ea1758904952.png">
</div>

5. 그리고 무엇을 어디에 merge 시킬지에 대한 설정을 해준다. `feature/add-file3`에서 `develop`으로

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226178131-d17f5977-59cb-4d87-951c-819280b17fe0.png">
</div>

6. `Create Pull Request`를 입력하면 `Open a pull reqeust` 화면이 나오게 되는데, 여기서 리뷰를 할 사람과 누가 합병을 할 수 있는지에 대한 정보를 넣어준다.

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226178168-71bf815f-5d9d-40a9-9cc1-d75b251db535.png">
</div>

7. 그 결과로 Open 상태와 어디에서 어디로 합병이 되는지에 대한 정보를 확인할 수 있다. 여기서 Pull Request에 대해서 해줄 수 있는 액션이 크게 두 가지가 존재한다.

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226178266-d75c4911-e0ac-4f4d-8415-a8d8ddc5f4b6.png">
</div>

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226178339-c0c6c1f2-27be-4eeb-a8fe-96dbd5730549.png">
</div>

- Pull Request를 잘못 보냈을 경우, 하단의 `Close Pull Request`를 선택하는 액션
- Pull Request를 잘못 merge 하는 경우 `Merge Pull request` 하는 액션


우선 Meerge를 진행하고, 다시 IntelliJ로 돌아와 develop 브랜치로 돌아가 `Update Project` 선택 후 Pull을 받아준다.

<div algin="center">
<img src="https://user-images.githubusercontent.com/97272787/226178358-c2f85f7f-0100-4196-82d0-3812667b414e.png">
</div>

____

Merge Pull Request에도 3가지 방법이 존재한다.

- Merge
    - a, b, c를 refer 하는 m 커밋노드를 생성한다. m은 parent로 init, c를 가진다.
    - 커밋 m에서부터 뒤로 되돌아가면서 부모를 모두 찾아 브랜치를 구성한다. 커밋 m은 부모로 c와 init을 가지고 있으며 c는 b를, b는 a를, a는 init을 다시 부모로 가진다. 이 형상을 모두 backtrace 하여 `init - a - b - c - m`의 구조를 만들고 이 구조가 모두 히스토리에 남는다.

- Squash and Merge
    - a, b, c를 합쳐 새로운 커밋으로 만들고, 합병 대상 브랜치에 추가한다. 'a,b,c' 커밋은 parent를 init 하나만 가진다.
    - 커밋 a,b,c는 init만을 부모로 가진 단일 커밋이다. 작업했던 a,b,c, 커밋들은 합병 후의 메인 브랜치 커밋 init과 'a,b,c'와 아무런 연관을 가지지 않는다.

- Rebase and Merge
    - a,b,c를 심리스 하게 합병 대상 브랜치로 추가한다. 각 커밋들은 모두 parent를 하나씩만 가진다.
    - 커밋 a,b,c의 관계를 그대로 유지한 채 메인 브랜치에 그대로 추가한다. 커밋 a는 부모로 커밋 e를 가진다. Rebase and Merge 작업 후에는 작업했던 브랜치의 a,b,c 커밋들은 합병 후의 메인 브랜치의 init, d,e,a,b,c 커밋들과 연관 관계를 가지지 않는다.


`develop-feature` 브랜치 간의 합병에는 `Squash and Merge`가 유용하다. 지저분한 feature의 히스토리를 모두 묶어 완전한 새로운 커밋으로 develop 브랜치에 추가하여 develop 브랜치에 독자적으로 관리할 수 있기 때문이다. 일반적으로 합병 후에 feature 브랜치를 삭제하는 경우, feature 브랜치의 커밋 히스토리를 모두 develop 브랜치에 직접 연관 지어 남길 필요가 없다.

`master-develop` 브랜치간의 합병에는 `Rebase and Merge`가 유용하다. develop의 내용을 master에 추가할 때에는 별도의 새로운 커밋을 생성할 이유가 없기 때문이다.

`hotfix-develop`, `hotfix-master` 브랜치 간의 합병은 `merge` 또는 `Squash and Merge` 모두 유용하다. hotfix 브랜치 작업의 히스토리가 모두 남아야하는 경우 Merge를, 필요 없는 경우 Squash and Merge를 사용한다.


### 5. Commit 수정


위와 동일한 과정으로 `feature/add-file4` 브랜치를 생성하여 파일을 생성해준다. 그리고 커밋을 해주는데, 만약 커밋 메시지를 잘못 입력 했을 경우 IntelliJ 그래프에서 'Undo Commit'항목을 선택하면 된다.

<div align="center">
<img src="https://user-images.githubusercontent.com/97272787/226182891-7e615062-8bdf-49b8-86b7-6244f179f14e.png">
</div>

____

#### 출처

<p>1. <a href="https://ozofweird.tistory.com/entry/Git-%EC%9B%90%EB%8D%B0%EC%9D%B4-Git-flow">나의 개발 기록, [Git 원데이] Gitflow</a></p>
<p>2. <a href="https://velog.io/@seongwon97/Git-Git-Flow-%EA%B0%9C%EB%85%90-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0">seongwon98.log - [Git] Git Flow 개념 이해하기</a></p>