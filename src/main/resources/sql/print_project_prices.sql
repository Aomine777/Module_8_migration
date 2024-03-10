WITH hq1 AS (
    SELECT p.id AS ID,
           p.name AS NAME,
           SUM(w.salary) AS price,
           (EXTRACT(year FROM p.finish_date) * 12 + EXTRACT(month FROM p.finish_date)) -
           (EXTRACT(year FROM p.start_date) * 12 + EXTRACT(month FROM p.start_date)) AS date_diff
    FROM project p
    LEFT JOIN worker w ON EXISTS (
        SELECT 1
        FROM project_worker pw
        WHERE pw.project_id = p.id AND pw.worker_id = w.id
    )
    GROUP BY p.id, p.name
)

SELECT h.name, h.price * h.date_diff
FROM hq1 h
ORDER BY h.price * h.date_diff DESC;