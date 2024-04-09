CREATE TABLE account (
                         id VARCHAR(255) PRIMARY KEY,
                         account_type VARCHAR(255),
                         client_id VARCHAR(255),
                         balance DOUBLE,
                         withdraw_allowed BOOLEAN
);
CREATE TABLE transaction (
                             transaction_id INT PRIMARY KEY,
                             transaction VARCHAR(255),
                             id VARCHAR(255)
);
