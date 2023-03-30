window.addEventListener("DOMContentLoaded", function () {
    'use strict';

    const form = document.getElementById('register-form');
    const userIdInput = document.getElementById('userId');
    const userNameInput = document.getElementById('userName');
    const password1Input = document.getElementById('password1');
    const password2Input = document.getElementById('password2');
    const checkDuplicateBtn = document.getElementById('check-duplicate-btn');
    const registerBtn = document.getElementById('register-btn');

    let isUserIdValid = false;
    let isUserNameValid = false;
    let isPassword1Valid = false;
    let isPassword2Valid = false;
    let isUserIdAvailable = false;


    function validateUserId() {
        const value = userIdInput.value.trim();
        if (value === '') {
            userIdInput.classList.add('error');
            document.getElementById('userId-error').textContent = '아이디를 입력해주세요.';
            isUserIdValid = false;
        } else {
            userIdInput.classList.remove('error');
            document.getElementById('userId-error').textContent = '';
            isUserIdValid = true;
        }
    }

    function validateUserName() {
        const value = userNameInput.value.trim();
        if (value === '') {
            userNameInput.classList.add('error');
            document.getElementById('userName-error').textContent = '이름을 입력해주세요.';
            isUserNameValid = false;
        } else {
            userNameInput.classList.remove('error');
            document.getElementById('userName-error').textContent = '';
            isUserNameValid = true;
        }
    }

    function validatePassword1() {
        const value = password1Input.value.trim();
        if (value === '') {
            password1Input.classList.add('error');
            document.getElementById('password1-error').textContent = '비밀번호를 입력해주세요.';
            isPassword1Valid = false;
        } else {
            password1Input.classList.remove('error');
            document.getElementById('password1-error').textContent = '';
            isPassword1Valid = true;
        }
    }

    function validatePassword2() {
        const value = password2Input.value.trim();
        if (value === '') {
            password2Input.classList.add('error');
            document.getElementById('password2-error').textContent = '비밀번호를 입력해주세요.';
            isPassword2Valid = false;
        } else if (value !== password1Input.value.trim()) {
            password2Input.classList.add('error');
            document.getElementById('password2-error').textContent = '비밀번호가 일치하지 않습니다.';
            isPassword2Valid = false;
        } else {
            password2Input.classList.remove('error');
            document.getElementById('password2-error').textContent = '';
            isPassword2Valid = true;
        }
    }

    function checkDuplicate() {
        const userId = userIdInput.value.trim();
        if (userId === '') {
            return;
        }
        fetch(`http://133.186.144.236:8100/api/users/${userId}/exist`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(data => {
                if (data.result === true) {
                    userIdInput.classList.add('error');
                    document.getElementById('userId-error').textContent = '이미 사용중인 아이디입니다.';
                    isUserIdAvailable = false;
                    alert('이미 사용중인 아이디입니다.');
                    console.log('hi');
                } else {
                    userIdInput.classList.remove('error');
                    document.getElementById('userId-error').textContent = '';
                    isUserIdAvailable = true;
                    alert('사용 가능한 아이디입니다.');
                    console.log('중복확인이 완료되었습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
            })
            .finally(() => {
                if (isUserIdAvailable) {
                    alert('중복된 아이디가 아닙니다!');
                }
            });
    }

    function register() {
        const userId = userIdInput.value.trim();
        const userName = userNameInput.value.trim();
        const password = password1Input.value.trim();

        fetch('http://133.186.144.236:8100/api/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                userId: userId,
                userName: userName,
                userPassword: password
            })
        })
            .then(response => {
                if (response.ok) {
                    alert('회원가입이 완료되었습니다.');
                } else {
                    alert('회원가입에 실패하였습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('회원가입에 실패하였습니다.');
            });

    };

    form.addEventListener('submit', event => {
        event.preventDefault();

        validateUserId();
        validateUserName();
        validatePassword1();
        validatePassword2();

        if (isUserIdValid && isUserNameValid && isPassword1Valid && isPassword2Valid && isUserIdAvailable) {
            register();
        }
    });

    checkDuplicateBtn.addEventListener('click', checkDuplicate);

    userIdInput.addEventListener('input', () => {
        isUserIdAvailable = false;
    });

})
