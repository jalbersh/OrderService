# Order Service
This is an example of a restaurant order service. The objective is to simulate an order being called in from a customer. <br /><br />

The customer POST would include a user UUID, a restaurant UUID, an array of menu_item UUIDs, and a tip.<br /><br />

The returning JSON would include an order UUID, the total price, the order time, and expected delivery time.

# Frameworks / Libraries Used
1. Spring Boot
2. JDK 11
3. Spring JPA
4. MySQL (Hibernate)
5. Netty

# MySQL Tables
1. Addresses - id, address
2. MenuItems - id, name, price, menu_id(manyToOne)
3. Menus - id, name, restuarant(manyToOne)
4. Restaurants - id, name, address_id(oneToOne) 
5. User - id, name, address_id(oneToOne)

# External Services
1. MapQuest Routing - to calculate the travel time between the restaurant and customer's address

## Application Build

This project uses Maven. 

1. Command to build including running Unit Test Cases - ```./mvnw clean install```
2. Command to build without running Unit Test Cases - ```./mvnw clean install -DskipTests```

## Application Deploy
To run the application, make sure you are logged into the AWS Sandbox account (see Pre-requisites) and execute the below command from the project folder
    ```java -jar target/Sample.jar 
    ```         

## Sample input/output
1. Build sample jar file using per instructions above
2. Run the Application using the command provided in the above section
3. Expected POST JSON input:
    ```
   {
      "user_id": "09e3cb5e-8f97-44b1-9caa-6008f542c082",
      "restaurant_id": "8770d360-a304-4f43-b973-2e956f95274c",
      "menuItems": ["4acbaf98-64de-41cd-b182-3f83c446826e","0eb222e7-3248-42f4-befc-7f03abe1dac1","470763bb-7646-451d-8a24-56ccd60f3bfa","5d24ebc2-0d29-4071-b2fd-7cf4f3ca17ae","af67c7dd-7d6f-495b-809b-14e1ec46847f","6faa7547-0e58-4981-b88a-8893c744deae"],
      "tip": "$9.67"
   }
   ```
   ```
4. Expected JSON output: 
    ```
   {
      "order_id": "75d103c8-782b-4103-97df-051b1b9a7395",
      "total_price": "$37",
      "order_time": "Wed Dec 16 09:09:25 MST 2020",
      "expected_delivery_time": "00:33:08"
   }
   ```
