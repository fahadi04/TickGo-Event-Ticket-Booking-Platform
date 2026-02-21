**🎟️ TickGo — Event Ticket Booking Platform**

TickGo is a full-stack event ticketing platform that enables users to discover events, book tickets, and manage reservations through a secure and seamless digital experience.

The platform uses Keycloak for identity & access management, PostgreSQL for reliable data storage, and provides real-time ticket availability with an intuitive user interface for users and event organizers.

**🚀 Features**
✅ Secure authentication & authorization via Keycloak
✅ User registration & role-based access (User / Organizer / Admin)
✅ Browse & search events by category, date, or location
✅ Real-time ticket availability & booking
✅ Organizer dashboard to manage events & ticket inventory
✅ Booking history & digital ticket generation
✅ Responsive and user-friendly interface

**🛠️ Tech Stack**
**Frontend**
React.js
HTML, CSS, JavaScript

**Backend**
Spring Boot
RESTful APIs
Spring Security
Database
PostgreSQL
Authentication & Security
Keycloak (IAM & SSO)
OAuth2 / OpenID Connect
Role-Based Access Control (RBAC)
Tools & DevOps
Adminer (DB management)
Docker (optional)
Maven
Git & GitHub
Postman

**🏗️ System Architecture**
REST API–based architecture
Controller → Service → Repository layered design
Keycloak-based centralized authentication
Role-based authorization for secure access
Scalable relational schema for event & ticket management

**📂 Project Structure**
tickgo/
│
├── backend/
│   ├── controllers/
│   ├── services/
│   ├── repositories/
│   └── models/
│
├── frontend/
│   ├── components/
│   ├── pages/
│   └── assets/
│
└── docker/ (optional)

**⚙️ Installation & Setup**
1️⃣ Clone Repository
git clone https://github.com/yourusername/tickgo.git
cd tickgo

2️⃣ Start PostgreSQL & Adminer
docker run --name tickgo-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
docker run --name adminer -p 8081:8080 -d adminer
Adminer → http://localhost:8081

3️⃣ Configure Database
Update application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/tickgo
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

4️⃣ Setup Keycloak
Start Keycloak:
docker run -p 8080:8080 \
-e KEYCLOAK_ADMIN=admin \
-e KEYCLOAK_ADMIN_PASSWORD=admin \
quay.io/keycloak/keycloak:latest start-dev

Create:
Realm: tickgo
Client: tickgo-app
Roles: USER, ORGANIZER, ADMIN
Users & role mappings

5️⃣ Run Backend
cd backend
mvn clean install
mvn spring-boot:run

6️⃣ Run Frontend
cd frontend
npm install
npm start

**🔐 Authentication Flow**
User logs in via Keycloak
Keycloak issues JWT token
Frontend sends token with API requests
Backend validates token & roles
Secure resource access granted

**📈 Future Enhancements**
Online payment integration (Stripe/Razorpay)
QR code ticket validation
Email & SMS notifications
Event analytics dashboard
Mobile application

**🤝 Contributing**
Contributions are welcome! Fork the repo and submit a pull request

**👨‍💻 Author**
Fahad Masroor
Full Stack Developer | Spring Boot & React Enthusiast

