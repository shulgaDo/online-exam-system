# 在线考试系统数据库设计

## 一、用户模块

### users（用户表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| username | varchar(50) | 用户名（唯一） |
| password | varchar(255) | 密码 |
| role | enum | 角色（student/teacher/admin） |
| email | varchar(100) | 邮箱 |
| phone | varchar(20) | 手机号 |
| status | tinyint | 状态 |
| created_at | datetime | 创建时间 |
| updated_at | datetime | 更新时间 |

---

### student_profile（学生信息表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK(users.id) |
| real_name | varchar(50) | 真实姓名 |
| class_name | varchar(50) | 班级 |
| student_no | varchar(50) | 学号 |

---

### login_logs（登录日志）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK(users.id) |
| login_time | datetime | 登录时间 |
| ip | varchar(50) | IP地址 |

---

## 二、题库模块

### questions（题目表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| title | text | 题目内容 |
| type | enum | 题型 |
| options | json | 选项 |
| answer | text | 答案 |
| analysis | text | 解析 |
| created_by | bigint | 创建人 |
| created_at | datetime | 创建时间 |

---

### question_favorites（收藏表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK |
| question_id | bigint | FK |
| created_at | datetime | 收藏时间 |

---

## 三、试卷模块

### papers（试卷表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| name | varchar(100) | 试卷名称 |
| type | enum | 类型（exam/unit） |
| total_score | int | 总分 |
| duration | int | 时长（分钟） |
| created_by | bigint | 创建人 |
| created_at | datetime | 创建时间 |

---

### paper_questions（试卷题目表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| paper_id | bigint | FK |
| question_id | bigint | FK |
| score | int | 分值 |
| sort_order | int | 排序 |

---

## 四、考试模块

### exams（考试表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| paper_id | bigint | FK |
| name | varchar(100) | 考试名称 |
| start_time | datetime | 开始时间 |
| end_time | datetime | 结束时间 |
| status | enum | 状态 |
| created_at | datetime | 创建时间 |

---

### exam_records（考试记录）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| exam_id | bigint | FK |
| user_id | bigint | FK |
| start_time | datetime | 开始时间 |
| end_time | datetime | 结束时间 |
| score | decimal(5,2) | 总分 |
| status | enum | 状态 |

---

### exam_answers（答题记录）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| record_id | bigint | FK |
| question_id | bigint | FK |
| answer | text | 用户答案 |
| is_correct | boolean | 是否正确 |
| score | decimal(5,2) | 得分 |

---

## 五、错题本

### wrong_questions（错题表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK |
| question_id | bigint | FK |
| last_wrong_time | datetime | 最近错误时间 |
| wrong_count | int | 错误次数 |

---

## 六、成绩模块

### scores（成绩表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK |
| exam_id | bigint | FK |
| total_score | decimal(5,2) | 总分 |
| ranking | int | 排名 |
| created_at | datetime | 创建时间 |

---

### paper_downloads（试卷下载）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK |
| paper_id | bigint | FK |
| downloaded_at | datetime | 下载时间 |

---

## 七、消息模块

### messages（消息表）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| title | varchar(100) | 标题 |
| content | text | 内容 |
| type | enum | 类型 |
| created_at | datetime | 创建时间 |

---

### user_messages（用户消息）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK |
| message_id | bigint | FK |
| is_read | boolean | 是否已读 |
| read_time | datetime | 阅读时间 |

---

## 八、认证模块

### password_resets（密码重置）
| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | bigint | PK |
| user_id | bigint | FK |
| token | varchar(255) | 重置token |
| expire_time | datetime | 过期时间 |

---

## 九、设计说明

- 核心高并发表：exam_answers（建议分表）
- 建议按 user_id 分片
- Redis缓存热点数据（用户、试卷、排行榜）
- 避免跨表 join，提升性能
