
-- https://leetcode.com/problems/capital-gainloss/
SELECT stock_name, SUM(
        CASE WHEN operation = "buy" THEN -1*price
            ELSE price END) AS capital_gain_loss
FROM Stocks
GROUP BY 1
