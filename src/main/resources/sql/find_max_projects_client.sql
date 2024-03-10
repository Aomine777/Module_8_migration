SELECT c.id AS client_id, c.name AS client_name, COUNT(p.client_id) AS count_of_projects
FROM client c
LEFT JOIN project p ON c.id = p.client_id
GROUP BY c.id, c.name
HAVING COUNT(p.client_id) = (
    SELECT MAX(project_count)
    FROM (
        SELECT COUNT(p2.client_id) AS project_count
        FROM client c2
        LEFT JOIN project p2 ON c2.id = p2.client_id
        GROUP BY c2.id
    ) AS max_project_count
);