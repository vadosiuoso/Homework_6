SELECT name,
COUNT(*) AS project_count
FROM project p
INNER JOIN client c ON p.CLIENT_ID = c.id
GROUP BY name
HAVING project_count = (SELECT
COUNT(p.client_id) as project_count
FROM client c
INNER JOIN project p ON p.CLIENT_ID = c.id
GROUP BY name
ORDER BY project_count DESC
limit 1);