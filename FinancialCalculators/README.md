# 3 Financial Calculators
A set of financial calculators for clients of financial a institution

# Instructions:
Run CalculatorMenu.java to start the program.

## The Project

Our financial organization provides a set of financial calculators for our clients. The console will prompt the user to select which calculator they would like to use.

### The Mortgage Calculator
The mortgae calculator is used to calculate out how much a monthly payment for a loan would be (minus any insurance or taxes), as well as how much interest you would pay over the life of the loan.

a. Accept the principal, interest rate, and loan length from the user

b. Displays the expected monthly payment and total interest paid

Example: A $53,000 loan at 7.625% interest for 15 years would have a $495.09/mo payment with a total interest of $36,115.99

This calculator uses a compounded interest formula:

- M= Monthly Payment (M)
- Principal (P): This is the total
  amount of the loan.
- Annual Interest Rate (r): The nominal annual
  interest rate in decimal form (e.g., 7.625% = 0.07625).
- Loan Term in Years (y) How many years the loan lasts.
- Number of Monthly Payments (n): This is 12×y (Because there are 12 monthly payments per year.) -
- Monthly Interest Rate (i): This is the annual interest rate divided by
  12, i.e. r/12
- Total Interest =(M×n)−P 5

### Compounding Interest Calculator:
This calculator that determines the future value of a one-time deposit
assuming compound interest - it is used to help you decide how much a CD
will be worth when it matures

a. Accepts the deposit, interest rate, and number of years from the user

b. Displays the future value and the total interest earned

Example: If you deposit $1,000 in a CD that earns 1.75% interest and matures in 5 years, your CD's ending balance will be $1,092.62 and you would have earned $92.62 in interest

Note: The numbers above assume daily compounding FV = P × (1 + (r / 365))^(365 × t)
• Future Value (FV)
• Principal (P): This is the initial deposit amount.
• Annual Interest Rate (r): The nominal annual interest rate in decimal form (e.g., 1.75% = 0.0175).
• Number of Years (t): The total number of years the deposit will earn interest.
• Days Per Year: Daily compounding assumes 365 days per year.
• Total Number of Days: This is 365 × t (because there are 365 days per year).
• Total Interest Earned = FV - P

### Present Value Ordionary Annuity Calculator:
This calculator that determines the present value of an ordinary annuity.

a. Accepts the monthly payout, expected interest rate, and years to pay out from the user

b. Displays the present value of that annuity

Example: To fund an annuity that pays $3,000 monthly for 20 years and
earns an expected 2.5% interest, you would need to invest $566,141.46
today. 