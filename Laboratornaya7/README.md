# Java Laboratory Work №7: E-commerce Back-End System

## Overview

This Java project implements a simplified back-end system for an e-commerce platform. It leverages Java Collections to manage inventory, user shopping carts, and order processing. The system is designed to provide a basic framework for simulating an e-commerce environment.

## Features

- **Product Management**: Manage products with attributes like ID, name, price, and stock.
- **User Management**: Handle user accounts with shopping carts, enabling the addition, deletion, and modification of products in the cart.
- **Order Processing**: Create orders with detailed information, including user ID, order details, and total price calculation.
- **Inventory Management**: Manage and update the stock levels of products.

## Classes and Methods

- `Product`: Represents a product with attributes and methods for property management.
    - Methods include getters, setters, and `toString()`.
- `User`: Represents a user with a shopping cart.
    - Methods for cart management (add, remove, update items) and cart contents retrieval.
- `Order`: Represents an order with attributes like order ID, user ID, order details, and total price.
    - Includes methods for order creation and total price calculation.
- `ECommercePlatform`: Main class for managing users, products, and orders.
    - Methods for adding users and products, creating orders, listing products, and updating product stock.

## Sorting and Filtering

- Implements `Comparable` in `Product` class for sorting by price.
- Custom `Comparator` classes for sorting products by name and stock.
- Features for displaying sorted product lists and filtering products based on stock availability.

## Recommendations

- Provides functionality to recommend products to users based on their cart contents or order history.

## Testing

Comprehensive unit tests ensure the robustness of the implementation, covering various test cases and edge scenarios. Tests include:
- Testing user interactions with the shopping cart.
- Verifying order creation and processing.
- Ensuring correct product sorting and filtering.
- Validating product recommendation logic.

## Usage

Compile and run the `ECommerceDemo` class to simulate user interactions, cart updates, order processing, and view the final state of users, products, and orders. Unit tests can be run to verify the functionality of the system components.

This project serves as a practical demonstration of Java programming skills, focusing on object-oriented design, collections manipulation, and unit testing.
