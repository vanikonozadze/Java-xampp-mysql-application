# Bank Account Management

A JavaFX application for managing bank accounts, allowing users to add new accounts and visualize the distribution of account balances using a PieChart.

## Introduction

This JavaFX application provides a straightforward interface for adding and viewing bank accounts. The application integrates with a MySQL database through JDBC for data storage. Users can input account details, and the system visualizes the distribution of account balances using a PieChart.

## Features

- Add new bank accounts with user, balance, and bank name.
- View a PieChart showing the distribution of account balances in predefined intervals.
- Data stored in a MySQL database using JDBC.

## Prerequisites

Ensure you have the following installed:

- Java
- JavaFX
- MySQL (with a database named 'bank' and a table named 'bank' with columns 'id', 'user', 'balance', 'bankname')

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/bank-account-management.git


## Usage
- Launch the application.
- Enter bank account details in the form (user, balance, bank name).
- Click "Add" to add a new bank account.
- View the PieChart to see the distribution of account balances.

## Database Configuration
Make sure your MySQL server is running, and the necessary database and table are set up. Update the database connection details in DatabaseConnector class if needed.
