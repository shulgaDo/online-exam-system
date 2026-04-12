### **学生端**

****

|         功能         |         描述(字段)         | API                          |
| :------------------: | :------------------------: | :--------------------------- |
|         登录         |         学号、密码         | /api/auth/login              |
|       忘记密码       |    手机、验证码、新密码    | /api/auth/forgot-password    |
|         注册         |         学号、密码         | /api/auth/register           |
|         登出         |                            | /api/auth/logout             |
| 课后练习(不限制时间) |      选项、图片、答句      | /api/student/practices/class |
|         考试         |      选项、图片、答句      | /api/student/exam/class      |
|       查看消息       |       内容、详细描述       | /api/student/message/{id}    |
|        错题本        | 题目、选项、正确答案、解析 | /api/student/wrong-questions |
|     历次考试成绩     |      学科、分数、排名      | /api/student/exam/rank       |
|                      |                            |                              |





