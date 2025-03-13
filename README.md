# Backend_Traini8_UtkarshSinghal
A post and get java api
# Backend_Traini8_YourName

## Training Center API
---

## **📌 Setup Instructions**

### **1️⃣ Prerequisites**
Ensure you have the following installed:
- **Java 17+** (Check with `java -version`)
- **Maven 3.8+** (Check with `mvn -version`)
- **Insomnia** (for API testing)

---

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/your-username/Backend_Traini8_YourName.git
cd Backend_Traini8_YourName
```

---

### **3️⃣ Configure the Database**
If using a database, update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/train8
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
*Ensure your database is running and the credentials are correct.*

---

### **4️⃣ Build and Run the Project**
Run the following command:
```sh
mvn spring-boot:run
```
Or, build a JAR and run:
```sh
mvn clean package
java -jar target/backend-traini8.jar
```

---

## **🚀 API Endpoints**

### **1️⃣ Create a Training Center**
**Endpoint:** `POST /trainingcenters/create`

**Request Body (JSON):**
```json
{
  "centerName": "Tech Learning Hub",
  "centerCode": "123456789012",
  "contactEmail": "techhub@example.com",
  "contactPhone": "9876543210"
}
```

**Validations:**
- `centerName` must be **≤ 40 characters**.
- `centerCode` must be **exactly 12 characters**.
- `contactEmail` must be a **valid email format**.
- `contactPhone` must be **exactly 10 digits**.

**Response:**
- `200 OK` → Training Center Created.
- `400 Bad Request` → Validation Failed.

---

### **2️⃣ Get All Training Centers**
**Endpoint:** `GET /trainingcenters/all`

**Response:**
```json
[
  {
    "centerName": "Tech Learning Hub",
    "centerCode": "123456789012",
    "contactEmail": "techhub@example.com",
    "contactPhone": "9876543210",
    "createdOn": 1710456789000
  }
]
```

---

## **🛠️ Testing with Insomnia/Postman**
- Open **Insomnia**.
- Create a new **POST request** to `http://localhost:8080/trainingcenters/create`.
- Add **JSON Body** (see above).
- Send the request and verify the response.

---




