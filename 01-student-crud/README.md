# Student CRUD API

Spring Boot 實作的學員管理 REST API。

## 技術

- Java 17
- Spring Boot 4.1
- Spring Data JPA
- H2 Database (file mode)
- Lombok
- Gradle

## 專案結構

src/main/java/com/example/demo/
├── controller/     # REST Controller
├── service/        # 業務邏輯
├── repository/     # 資料存取
├── entity/         # JPA Entity
└── dto/            # 資料傳輸物件
    ├── request/
    └── response/

## API

| Method | URL | 說明 |
|--------|-----|------|
| POST | /students | 新增學員 |
| GET | /students | 查詢全部 |
| GET | /students/{id} | 查詢單一 |
| PUT | /students/{id} | 修改 |
| DELETE | /students/{id} | 刪除 |

## 啟動

./gradlew bootRun

預設 port: 8080
