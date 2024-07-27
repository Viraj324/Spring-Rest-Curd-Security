"# Spring-Rest-Curd-Security" 
User Details
The application uses an in-memory user store with the following users:

Viraj

Username: viraj
Password: sjpv@5555
Roles: EMPLOYEE, MANAGER, ADMIN
Piyush

Username: piyush
Password: piyush@1234
Roles: EMPLOYEE, MANAGER
John

Username: john
Password: john@1234
Roles: EMPLOYEE
Security Configuration
The security configuration is defined in the DemoSecurityConfig class and includes the following settings:

Password Encoding
Password Encoder: BCryptPasswordEncoder
Endpoint Permissions
The following HTTP methods and endpoints are secured based on user roles:

GET /api/employees

Roles: EMPLOYEE, MANAGER, ADMIN
GET /api/employees/{id}

Roles: EMPLOYEE, MANAGER, ADMIN
PUT /api/employees

Roles: MANAGER, ADMIN
POST /api/employees

Roles: MANAGER, ADMIN
DELETE /api/employees/{id}

Roles: ADMIN
Security Features
Authentication Method: Basic Authentication
CSRF Protection: Disabled
