SET SERVEROUTPUT ON;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Loans';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(10)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE
);

INSERT INTO Customers VALUES (1, 'John', 65, 15000, 'FALSE');
INSERT INTO Customers VALUES (2, 'Mary', 45, 8000, 'FALSE');
INSERT INTO Customers VALUES (3, 'David', 70, 25000, 'FALSE');
INSERT INTO Customers VALUES (4, 'Emma', 30, 5000, 'FALSE');

INSERT INTO Loans VALUES (101, 1, 10, SYSDATE + 15);
INSERT INTO Loans VALUES (102, 2, 12, SYSDATE + 45);
INSERT INTO Loans VALUES (103, 3, 11, SYSDATE + 20);
INSERT INTO Loans VALUES (104, 4, 9, SYSDATE + 10);

COMMIT;

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Age
        FROM Customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rate updated successfully');
END;
/

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP customers updated');
END;
/

DECLARE
    CURSOR c_loans IS
        SELECT CustomerID, LoanID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan_rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer ' || loan_rec.CustomerID ||
            ' - Loan ' || loan_rec.LoanID ||
            ' due on ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/

SELECT * FROM Customers;
SELECT * FROM Loans;