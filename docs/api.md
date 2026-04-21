# API设计文档

> 统一返回格式：

```json
{
  "code": 200,
  "message": "success",
  "data": {}
}
```

## 1. 用户模块

### 1.1 用户登陆

接口地址：

* POST /api/auth/login

请求体：

* Content-Type：application/json

请求参数：

| 参数名     | 类型   | 必选 | 说明     |
| ---------- | ------ | ---- | -------- |
| student_id | String | 是   | 学生学号 |
| password   | String | 是   | 登录密码 |

```json
{
  "studentId": "194300408",
  "password": "913812291021SM"
}
```

响应体：

```json
{
  "code":200,
  "message":"登陆成功",
  "data":{
    “token”:"xx",
    "user":{
      "id": 1,
      “studentId”:"194300408"
      "username": "zhangsan",
      "role": "STUDENT"
    }
  }
}
```

### 1.2 用户登出

接口地址：

* POST /api/auth/logout

请求头：

* Authorization: Bearer <token>

响应体：

```json
{
  "code": 200,
  "message": "登出成功"
}

```

### 1.2 查看用户信息

接口地址：

* GET /api/auth/me

请求头：

* Authorization: Bearer <token>

响应体：

```json
{
  "code": 200,
  "message": "请求成功",
  "data":{
    "userId":1,
    "username":"194300408",
    "gender":“MALE”,
    "name":"李白",
    "department":{
      "id": 1,
      "name": "计算机学院"
    },
    "role":"STUDENT"
    "avatar":"https://example.com/avatar.jpg"
  }
}

```

### 1.3 修改用户信息

接口地址：

* PATCH /api/auth/me

请求头：

* Authorization: Bearer <token>

请求参数：

| 参数名       | 类型   | 必选 | 说明     |
| ------------ | ------ | ---- | -------- |
| gender       | Enum   | 可选 | 性别     |
| avatar       | String | 可选 | 头像     |
| departmentId | String | 可选 | 院系     |
| nickname     | String | 可选 | 昵称     |
| signature    | String | 可选 | 个性签名 |

```json
{
  "gender": "MALE",
  "avatar": "https://xxx.com/avatar.jpg",
  "departmentId":3,
  "nickname":"Mooker",
  "signature":"我天下无敌"
}
```

响应体：

```json
{
  "code": 200,
  "message": "用户信息更新成功",
  "data": {
    "userId": 1,
    "username": "194300408",
    "name": "李白",
    "nickname": "Mooker",
    "gender": "MALE",
    "departmentId": 3,
    "departmentName": "音乐学院",
    "avatar": "https://example.com/avatar.jpg",
    "signature": "我天下无敌"
  }
}
```

### 1.4 修改密码

接口地址：

* PATCH /api/auth/password

请求头：

* Authorization: Bearer <token>

请求参数：

| 参数名      | 类型   | 必选 | 说明     |
| ----------- | ------ | ---- | -------- |
| newPassword | String | 是   | 新密码   |
| rePassword  | String | 是   | 确认密码 |
| oldPassword | String | 是   | 旧密码   |

```json
{
  "oldPassword": "old123456",
  "newPassword":"1940342815Jacksm",
  "rePassword":"1940342815Jacksm"
}
```

响应体：

```json
{
  "code":200,
  "message": "密码修改成功",
  "data":{
    "updateAt":"2026-04-01 12:11:11"
  }
}
```



## 2. 考试模块

GET /api/exams 

GET /api/exams/{id} 

POST /api/exams/{id}/start 

POST /api/exams/{id}/submit

## 3. 题目模块

GET /api/questions 

POST /api/questions 

PUT /api/questions/{id} 

DELETE /api/questions/{id}

## 4. 试卷模块

GET /api/papers 

POST /api/papers

## 5. 成绩模块

GET /api/results 

GET /api/results/{examId}

## 6. 错题模块

GET /api/wrong-questions 

POST /api/wrong-questions/retry

## 7. 收藏模块

POST /api/favorites 

DELETE /api/favorites