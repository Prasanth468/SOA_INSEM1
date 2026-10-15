# Microservice Load Balancing — Order Service

A beginner-friendly Spring Boot example with two order-service instances and a Spring Cloud LoadBalancer client.

## Requirements
- JDK 17 or later
- Maven 3.8+
- Spring Tool Suite (STS) or VS Code

## Project structure
- `order-service`: the same service application runs twice, on ports 8081 and 8082.
- `order-client`: runs on port 8080 and calls `http://order-service/orders`; Spring Cloud LoadBalancer selects an instance.

## Run in STS
1. Extract the ZIP.
2. In STS, choose **File → Import → Maven → Existing Maven Projects**.
3. Select the extracted `microservice-load-balancing` root folder (the one containing the parent `pom.xml`) and click **Finish**.
4. Wait for Maven dependencies to download.

### Start order-service instance 1 (port 8081)
Run `OrderServiceApplication.java` as **Spring Boot App**. It uses `order-service/src/main/resources/application.properties`, where the default port is 8081.

### Start order-service instance 2 (port 8082)
Run the same `OrderServiceApplication.java` a second time with a different port:
- Open **Run → Run Configurations...**
- Select the `OrderServiceApplication` Spring Boot App configuration and duplicate it (or create another).
- In **Arguments → Program arguments**, enter:
  `--server.port=8082`
- Click **Apply → Run**.

Keep both service instances running.

### Start the client (port 8080)
Run `OrderClientApplication.java` as **Spring Boot App**.

## Test load distribution
Open this URL several times in a browser:
`http://localhost:8080/client/orders`

The JSON response includes `instancePort`. You should see responses from both `8081` and `8082` over repeated calls. The exact sequence is not guaranteed.

You can also test with curl:
```bash
curl http://localhost:8080/client/orders
```

Direct checks:
- `http://localhost:8081/orders`
- `http://localhost:8082/orders`

## Push to GitHub from VS Code
1. Extract the ZIP and open the `microservice-load-balancing` folder in VS Code.
2. Open **Terminal → New Terminal**.
3. Run these commands, replacing the URL with your own empty GitHub repository URL:
```bash
git init
git add .
git commit -m "Add order microservice load balancing demo"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
git push -u origin main
```
4. If Git asks you to sign in, finish the browser sign-in prompt. If the push is rejected because the GitHub repository already has files, create an empty repository or pull/merge its existing contents first.

## Notes
- This demo uses Spring Cloud's simple static discovery list, not Eureka. Both service instances must be running.
- If you get a Java version error, configure the project and STS to use JDK 17.
