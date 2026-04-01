# Money Transfer API (Spring Boot)

Design and implement a REST API for transferring money between accounts. **in-memory datastore** based on Java collection framework.

## Features
- Get all dummy accounts
- Get account by id
- Transfer money between accounts
- Validation and error handling
- Runs as a standalone Spring Boot application

## API Endpoints

### 1. Get all accounts
http://localhost:8080/api/accounts

### 2. Get account by id
http://localhost:8080/api/accounts/{accountNumber}

### 3. Transfer money

POST /transfers
```json
curl --location 'http://localhost:8080/api/accounts/transfer' \
--header 'Content-Type: application/json' \
--data '{
  "fromAccountNumber": "ACC1001",
  "toAccountNumber": "ACC1002",
  "amount": 100.00
}'
```
Success response:
```json
{
    "message": "Transfer successful",
    "fromAccountNumber": "ACC1001",
    "toAccountNumber": "ACC1002",
    "transferredAmount": 100.0,
    "fromAccountBalance": 4900.0,
    "toAccountBalance": 3100.0
}
```

## Run
Make sure Java 17+ and Maven are installed.

