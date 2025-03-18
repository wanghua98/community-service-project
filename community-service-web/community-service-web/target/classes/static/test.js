// 获取按钮
const btn = document.getElementById('btn');
// 获取用户名和密码的输入框
const username = document.getElementById('username');
const password = document.getElementById('password');

// 给按钮添加点击事件
btn.addEventListener('click', async function () {
    // 获取用户名和密码的值
    const usernameValue = username.value;
    const passwordValue = password.value;

    // 判断用户名和密码是否为空
    if (usernameValue === '' || passwordValue === '') {
        alert('用户名和密码不能为空');
        return;
    }

    try {
        // 发送POST请求给http://localhost:8080/user
        const response = await fetch('http://localhost:8080/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: usernameValue,
                password: passwordValue
            })
        });

        const data = await response.json();

        // 判断注册是否成功
        if (data.code === 1) {
            alert('注册成功');
        } else {
            alert('注册失败');
        }
    } catch (error) {
        console.error('请求失败:', error);
        alert('请求失败，请稍后重试');
    }
});