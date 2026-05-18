# RESTful API Design - Task Management System

## 1. Giới thiệu

Hệ thống quản lý:
- User (Người dùng)
- Task (Công việc)

Mỗi Task sẽ thuộc về một User thông qua `userId`.

---

# 2. Models

## User

```json
{
  "id": 1,
  "name": "Nguyen Van A",
  "email": "a@gmail.com",
  "role": "admin"
}
```

### Validation
- `name` không được để trống
- `email` đúng định dạng email
- `role` chỉ nhận:
    - admin
    - user

---

## Task

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Practice REST API",
  "priority": "high",
  "status": "pending",
  "userId": 1
}
```

### Validation
- `title` không được để trống
- `priority` chỉ nhận:
    - low
    - medium
    - high
- `status` chỉ nhận:
    - pending
    - doing
    - done
- `userId` phải tồn tại trong bảng User

---

# 3. RESTful API Endpoints

# USER APIs

## Lấy toàn bộ danh sách người dùng

```http
GET /users
```

---

## Tạo mới người dùng

```http
POST /users
```

### Request Body

```json
{
  "name": "Tran Van B",
  "email": "b@gmail.com",
  "role": "user"
}
```

---

## Cập nhật vai trò người dùng

```http
PUT /users/{id}/role
```

### Request Body

```json
{
  "role": "admin"
}
```

---

## Xóa người dùng

```http
DELETE /users/{id}
```

---

## Liệt kê toàn bộ công việc của một người dùng

```http
GET /users/{id}/tasks
```

---

# TASK APIs

## Lấy toàn bộ danh sách công việc

```http
GET /tasks
```

---

## Tạo mới công việc

```http
POST /tasks
```

### Request Body

```json
{
  "title": "Complete Assignment",
  "description": "Finish REST API homework",
  "priority": "high",
  "status": "pending",
  "userId": 1
}
```

---

## Cập nhật trạng thái công việc

```http
PUT /tasks/{id}/status
```

### Request Body

```json
{
  "status": "done"
}
```

---

## Xóa công việc

```http
DELETE /tasks/{id}
```

---

## Tìm công việc có độ ưu tiên là high

```http
GET /tasks?priority=high
```

---

## Tìm công việc có độ ưu tiên high và userId = 1

```http
GET /tasks?priority=high&userId=1
```

---

## Gắn công việc cho người dùng

```http
PUT /tasks/{taskId}/assign
```

### Request Body

```json
{
  "userId": 1
}
```

---

# 4. HTTP Status Codes

| Status Code | Ý nghĩa |
|---|---|
| 200 | Thành công |
| 201 | Tạo dữ liệu thành công |
| 400 | Dữ liệu không hợp lệ |
| 404 | Không tìm thấy dữ liệu |
| 500 | Lỗi hệ thống |

---

# 5. Quan hệ giữa User và Task

- Một User có nhiều Task
- Một Task chỉ thuộc về một User
- Liên kết bằng `userId`