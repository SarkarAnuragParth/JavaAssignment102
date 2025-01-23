# Shopping Cart Application

## Overview
This is a simple shopping cart application implemented in Java. It allows customers to place orders for products by reading customer and product information from CSV files.

## Features
- Read customer and product information from CSV files.
- Place orders by entering customer ID and product details.
- Calculate the total amount for the order.
- Update product stock after placing an order.

## Project Structure
- `src/main/java/com/shopping/`: Contains the main Java source files.
    - `ShoppingCart.java`: Main class for handling the shopping cart operations.
    - `Order.java`: Represents an order placed by a customer.
    - `OrderItem.java`: Represents an item in an order.
    - `Product.java`: Represents a product.
    - `Customer.java`: Represents a customer.
    - `CSVReader.java`: Utility class for reading CSV files.
    - `Main.java`: Entry point of the application.
- `src/main/resources/`: Contains the CSV files with customer and product information.
    - `CustomerInfo.csv`: Contains customer data.
    - `ProductInfo.csv`: Contains product data.

## How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Run the following command to compile the project:
     ```sh
     mvn clean install
     ```
4. Run the application:
     ```sh
     java -cp target/shopping_cart-1.0-SNAPSHOT.jar com.shopping.Main
     ```

## CSV File Format
### CustomerInfo.csv
```
Customer ID,Name
100,David
101,Robert
102,James
103,John
104,Ruby
```

### ProductInfo.csv
```
Product Code,Name,Unit Price,Stock Available
1001,Laptop,30000,50
1003,CD,5000,10
1002,Mouse,1000,100
1004,KeyBoard,1500,20
1005,Monitors,7000,70
```

## Example Usage
1. Run the application.
2. Enter the customer ID when prompted.
3. Enter product IDs and quantities to add to the order.
4. Enter 'done' to finish the order.
5. The application will display the total amount and update the product stock.

## Dependencies
- Maven for project management and build.
