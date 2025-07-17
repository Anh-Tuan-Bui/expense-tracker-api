# 💰 Expense Tracker API - Hệ thống quản lý chi tiêu cá nhân

[![Java](https://img.shields.io/badge/Java-21-blue)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## 📘 Giới thiệu

**Expense Tracker API** là một RESTful API cho phép người dùng quản lý chi tiêu cá nhân theo danh mục, thời gian, và loại giao dịch (thu nhập/chi phí). Ứng dụng sử dụng Java Spring Boot, JWT Authentication.

---

## 🧩 Tính năng nổi bật
- 📥 Đăng ký và đăng nhập người dùng
- 🛡️ Xác thực người dùng bằng JWT
- 🔐 Phân quyền người dùng: Admin / Người dùng thường
- ➕ Thêm giao dịch thu nhập hoặc chi tiêu
- 🧾 Quản lý giao dịch: xem, sửa, xoá
- 🗂️ Gán giao dịch theo danh mục
- 📆 Lọc giao dịch theo thời gian (ngày / tháng / năm)

---

## 🏗️ Kiến trúc tổng thể

- Mô hình phân tầng: `Controller -> Service -> Repository`
- Sử dụng DTO để tách biệt entity & API contract
- Áp dụng nguyên tắc SOLID, clean code
- Dữ liệu người dùng và giao dịch được ràng buộc chặt chẽ theo quyền sở hữu

---

## 📁 Cấu trúc thư mục chính
```
expense-tracker-api/
├── config/               # Cấu hình của ứng dụng: bảo mật & JWT, ModelMapper, v.v...
├── controller/           # REST API controller
├── dto/                  # Data Transfer Object
├── entity/               # Các thực thể JPA
├── enumeration           # Các enum
├── exception/            # Xử lý lỗi
├── repository/           # Tầng tương tác DB
├── security/             # JWT Filter và cấu hình
├── service/              # Business logic
├── util/                 # Các class tiện ích (nếu có hoặc phát triển trong tương lai)
└── application.yml       # Cấu hình ứng dụng
```

---

## ⚙️ Công nghệ sử dụng

| Công nghệ | Mô tả |
|----------|-------|
| Java 21 | Ngôn ngữ lập trình chính |
| Spring Boot 3 | Framework backend chính |
| Spring Security | Xác thực & phân quyền |
| JSON Web Token (JWT) | Bảo mật phiên đăng nhập |
| Hibernate JPA | ORM thao tác cơ sở dữ liệu |
| ModelMapper | Mapping DTO ↔ Entity |
| Jakarta Validation | Kiểm tra dữ liệu đầu vào |
| MySQL | Lưu trữ dữ liệu |
| Postman | Kiểm thử thủ công các API |

---

## ▶️ Hướng dẫn cài đặt
### 1. Yêu cầu hệ thống
- Java 17+
- Maven 3.8+
- MySQL 8+
- IntelliJ IDEA / VS Code
- Docker (tuỳ chọn)

### 2. Clone và chạy dự án
#### Chạy bằng IntelliJ / VScode
1. Clone repo:
  ```bash
    git clone https://github.com/Anh-Tuan-Bui/expense-tracker-api.git
  ```
2. Mở project trong IntelliJ
3. Cấu hình file src/main/resources/application.yml theo MySQL của bạn
4. Chạy file ExpenseTrackerApplication.java

#### Chạy thủ công
```bash
# Clone repo
git clone https://github.com/Anh-Tuan-Bui/expense-tracker-api.git
cd expense-tracker-api

# Chỉnh sửa cấu hình MySQL trong src/main/resources/application.yml theo MySQL của bạn

# Chạy dự án
./mvnw spring-boot:run
```

### 3. Truy cập API
API Base URL: http://localhost:8080/api/expenses

---

## 🌐 API mẫu (sử dụng với Postman)
### 📝 1. Đăng ký tài khoản
```http
POST /api/auth/register
Content-Type: application/json

{
  "name": "Tuan Anh",
  "email": "tuananh@gmail.com",
  "password": "123456"
}
```

### 🔑 2. Đăng nhập
```http
POST /api/auth/login
{
  "email": "tuananh@gmail.com",
  "password": "123456"
}
```
→ Trả về access token (JWT)

### 💸 3. Tạo chi tiêu
```POST /api/expenses
Authorization: Bearer <JWT>
{
  "amount": 300000,
  "description": "Mua đồ siêu thị",
  "category": "GROCERIES",
  "expenseDate": "2025-07-16"
}
```

### 📊 4. Lọc chi tiêu theo khoảng thời gian
```
GET /api/expenses?startDate=2025-06-16&endDate=2025-07-16
```

---

## ⚠️ Xử lý lỗi
- 400 Bad Request: Trả về message + danh sách lỗi validation
- 401 Unauthorized: người dùng chưa xác thực
- 403 Access Denied: Người dùng không có quyền
- 404 Not Found: Không tìm thấy tài nguyên
- 500 Internal Server Error: Lỗi hệ thống

---

## 🧪 Kiểm thử
- Dùng Postman nếu muốn test thủ công
- Kiểm thử các tính năng:
    - Đăng ký / đăng nhập
    - Tạo, sửa, xoá giao dịch
    - Truy vấn theo thời gian

---

## 🧠 Hướng phát triển tiếp theo (dự kiến)
- Thêm tính năng xuất file CSV / Excel
- Giao diện frontend bằng VueJS hoặc React
- Tự động gợi ý chi tiêu bất thường
- Biểu đồ thống kê thu/chi
- Xem tổng thu nhập, tổng chi tiêu theo thời gian
- Phân trang danh sách giao dịch

---

## 📄 License
Dự án này được cấp phép theo giấy phép MIT – sử dụng tự do cho mục đích học tập và cá nhân.

---