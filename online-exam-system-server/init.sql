-- 用户表
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
--     role ENUM('student', 'teacher', 'admin') NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    status TINYINT DEFAULT 1,
    created_at DATETIME,
    updated_at DATETIME
);

-- 学生信息
CREATE TABLE student_profile (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    real_name VARCHAR(50),
    class_name VARCHAR(50),
    student_no VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 登录日志
CREATE TABLE login_logs (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    login_time DATETIME,
    ip VARCHAR(50)
);

-- 题目
CREATE TABLE questions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title TEXT,
    type ENUM('single', 'multiple', 'judge', 'subjective'),
    options JSON,
    answer TEXT,
    analysis TEXT,
    created_by BIGINT,
    created_at DATETIME
);

-- 收藏
CREATE TABLE question_favorites (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    question_id BIGINT,
    created_at DATETIME,
    UNIQUE(user_id, question_id)
);

-- 试卷
CREATE TABLE papers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    type ENUM('exam', 'unit'),
    total_score INT,
    duration INT,
    created_by BIGINT,
    created_at DATETIME
);

-- 试卷题目
CREATE TABLE paper_questions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    paper_id BIGINT,
    question_id BIGINT,
    score INT,
    sort_order INT
);

-- 考试
CREATE TABLE exams (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    paper_id BIGINT,
    name VARCHAR(100),
    start_time DATETIME,
    end_time DATETIME,
    status ENUM('draft', 'published', 'finished'),
    created_at DATETIME
);

-- 考试记录
CREATE TABLE exam_records (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    exam_id BIGINT,
    user_id BIGINT,
    start_time DATETIME,
    end_time DATETIME,
    score DECIMAL(5,2),
    status ENUM('ongoing', 'submitted')
);

-- 答题记录（核心表）
CREATE TABLE exam_answers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    record_id BIGINT,
    question_id BIGINT,
    answer TEXT,
    is_correct BOOLEAN,
    score DECIMAL(5,2)
);

-- 错题本
CREATE TABLE wrong_questions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    question_id BIGINT,
    last_wrong_time DATETIME,
    wrong_count INT DEFAULT 1
);

-- 成绩
CREATE TABLE scores (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    exam_id BIGINT,
    total_score DECIMAL(5,2),
    ranking INT,
    created_at DATETIME
);

-- 下载记录
CREATE TABLE paper_downloads (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    paper_id BIGINT,
    downloaded_at DATETIME
);

-- 消息
CREATE TABLE messages (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    content TEXT,
    type ENUM('exam', 'score', 'system'),
    created_at DATETIME
);

-- 用户消息
CREATE TABLE user_messages (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    message_id BIGINT,
    is_read BOOLEAN DEFAULT FALSE,
    read_time DATETIME
);

-- 密码重置
CREATE TABLE password_resets (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    token VARCHAR(255),
    expire_time DATETIME
);

-- 角色表
CREATE TABLE `roles`  (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                          `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- 用户角色关联表
CREATE TABLE `user_roles`  (
                               `user_id` bigint(20) NOT NULL,
                               `role_id` bigint(20) NOT NULL,
                               PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
                               INDEX `role_id`(`role_id` ASC) USING BTREE,
                               CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                               CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- 权限表
CREATE TABLE `permissions`  (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


