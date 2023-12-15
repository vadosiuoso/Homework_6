SELECT name, salary
FROM worker
WHERE salary = (
    SELECT 
        salary
    FROM worker AS emp
    ORDER BY salary DESC
    LIMIT 1,1
);