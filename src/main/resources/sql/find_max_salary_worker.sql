SELECT w.*
FROM worker w
GROUP BY w.id
HAVING w.salary = (SELECT MAX(salary) FROM worker);
