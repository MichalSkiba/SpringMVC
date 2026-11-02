# SpringMVC modernization

Java 21 / Jakarta Servlet 6 / Spring MVC 6.2.19 / Spring Security 6.5.11 (intermediate migration versions).
Requires Tomcat 10.1+ and configured environment variables `MVC_ADMIN_USER` and `MVC_ADMIN_PASSWORD_BCRYPT` (BCrypt hash).
Old hard-coded admin password was present in Git history; rotate the password and restrict access. Login and upload workflows require runtime verification.
The application is still a legacy XML-configured WAR. The CI build verifies Java and XML syntax; no deployed-container integration test is available.
